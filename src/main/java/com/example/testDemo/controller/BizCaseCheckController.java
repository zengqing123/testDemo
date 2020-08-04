package com.example.testDemo.controller;

import com.example.testDemo.entity.BizCaseCheck;
import com.example.testDemo.service.IBizCaseCheckService;
import com.example.testDemo.service.RequsetTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

/**
 * <p>
 * 案件审核表 控制器
 * </p>
 *
 * @author luozq
 * @since 2020-07-23
*/
@RestController
@RequestMapping("/biz-case-check")
@Api(value = "future测试", tags = {"future测试"})
public class BizCaseCheckController {
    @Autowired
    private IBizCaseCheckService service;

    @Autowired
    private RequsetTestService requsetTestService;

    private volatile int b = 10;

    @GetMapping("/demo")
    @ApiOperation("demo")
    public void test(){
        List<BizCaseCheck> list = service.selectLists();
        CountDownLatch latch = new CountDownLatch(10);
        for (int a = 0; a< 10;a++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String caseNo = list.get(b--).getCaseNo();
                        latch.await();
                        System.out.println(Thread.currentThread()+"传入参数:"+caseNo);
                        BizCaseCheck entity = requsetTestService.getEntity(caseNo);
                        System.out.println(Thread.currentThread()+"----"+"执行结果"+entity.getCaseNo());
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
            latch.countDown();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

        }

    }
}
