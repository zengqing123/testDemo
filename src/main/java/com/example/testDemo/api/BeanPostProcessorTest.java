package com.example.testDemo.api;

import com.example.testDemo.service.BaseService;
import com.example.testDemo.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * <b>类   名：</b>BeanPostProcessorTest<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>luozengqing<br/>
 * <b>创建时间：</b>2019/5/13 13:37<br/>
 * <b>修改人：</b>luozengqing<br/>
 * <b>修改时间：</b>2019/5/13 13:37<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br />
 */
@RestController
@RequestMapping("/api/test")
@Api("后置处理器测试")
public class BeanPostProcessorTest {
    @Autowired
    private BaseService baseService;

    @GetMapping("/test1")
    @ApiOperation("测试一")
    public Result test1(){
        return Result.ok().put("result",baseService.doSomething());
    }

    @GetMapping("/test2")
    @ApiOperation("测试二")
    public Result test2(){
        return Result.ok().put("result",baseService.eat());
    }

    @GetMapping("/test3")
    @ApiOperation("测试三")
    public Result test3(){
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet("http://localhost:8081/testUrl/api/test/test2");
        String result = "";
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity());
            EntityUtils.consume(response.getEntity());
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }


        return Result.ok().put("result",result);
    }



}
