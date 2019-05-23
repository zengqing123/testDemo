package com.example.testDemo;

import com.alibaba.fastjson.JSONObject;
import com.example.testDemo.entity.Entity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDemoApplicationTests {

	@Test
	public void contextLoads() {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("startDate", "2019-04-28 07");
		jsonObject.put("endDate", "2019-04-28 09");
		String url = "http://delanshi.cn/openApi/getDeliveryData";
		jsonObject.put("key", "6a7d9c51f111de5cd4c4a1e914025f9d");
		RestTemplate template = new RestTemplate();
		MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
		requestEntity.add("data",jsonObject.toString());
        System.out.println(requestEntity);
		String result = template.postForObject(url, requestEntity, String.class);
		System.out.println("返回的结果："+result);
		List<Entity> resultList = JSONObject.parseArray(result,Entity.class);
		System.out.println(resultList.size());


	}
	@Test
	public void contextLoadss() {
        String nowTime = getBeforeByHourTime(0);
        String nowTimes = getBeforeByHourTime(2);
        System.out.println(nowTime+":"+nowTimes);

	}
    public String getBeforeByHourTime(int ihour){
        String returnstr = "";
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - ihour);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH");
        returnstr = df.format(calendar.getTime());
        return returnstr;
    }

}
