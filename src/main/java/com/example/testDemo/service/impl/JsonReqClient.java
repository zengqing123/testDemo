
package com.example.testDemo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.example.testDemo.config.SMSConfig;
import com.example.testDemo.service.AbsRestClient;
import com.example.testDemo.utils.HttpClientUtil;

@Service
public class JsonReqClient extends AbsRestClient {
	@Autowired()
	 SMSConfig config;
	
	
	@Override
	public String sendSms(String templateid, String param, String mobile, 
			String uid) {
		
		String result = "";
		
		try {
			String url = getStringBuffer().append("/sendsms").toString();
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("sid", config.getSid());
			jsonObject.put("token", config.getToken());
			jsonObject.put("appid", config.getAppid());
			jsonObject.put("templateid", templateid);
			jsonObject.put("param", param);
			jsonObject.put("mobile", mobile);
			jsonObject.put("uid", uid);
			
			String body = jsonObject.toJSONString();
			
			System.out.println("body = " + body);
			
			result = HttpClientUtil.postJson(url, body, null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String sendSmsBatch(String templateid, String param, String mobile,
			String uid) {
		
		String result = "";
		
		try {
			String url = getStringBuffer().append("/sendsms_batch").toString();
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("sid", config.getSid());
			jsonObject.put("token", config.getToken());
			jsonObject.put("appid", config.getAppid());
			jsonObject.put("templateid", templateid);
			jsonObject.put("param", param);
			jsonObject.put("mobile", mobile);
			jsonObject.put("uid", uid);
			
			String body = jsonObject.toJSONString();
			
			System.out.println("body = " + body);
			
			result = HttpClientUtil.postJson(url, body, null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String addSmsTemplate(String type, String template_name,
			String autograph, String content) {
		
		String result = "";
		
		try {
			String url = getStringBuffer().append("/addsmstemplate").toString();
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("sid", config.getSid());
			jsonObject.put("token", config.getToken());
			jsonObject.put("appid", config.getAppid());
			jsonObject.put("type", type);
			jsonObject.put("template_name", template_name);
			jsonObject.put("autograph", autograph);
			jsonObject.put("content", content);
			
			String body = jsonObject.toJSONString();
			
			System.out.println("body = " + body);
			
			result = HttpClientUtil.postJson(url, body, null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String getSmsTemplate(String templateid, String page_num,
			String page_size) {
		
		String result = "";
		
		try {
			String url = getStringBuffer().append("/getsmstemplate").toString();
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("sid", config.getSid());
			jsonObject.put("token", config.getToken());
			jsonObject.put("appid", config.getAppid());
			jsonObject.put("templateid", templateid);
			jsonObject.put("page_num", page_num);
			jsonObject.put("page_size", page_size);
			
			String body = jsonObject.toJSONString();
			
			System.out.println("body = " + body);
			
			result = HttpClientUtil.postJson(url, body, null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String editSmsTemplate(String templateid, String type,
			String template_name, String autograph, String content) {
		
		String result = "";
		
		try {
			String url = getStringBuffer().append("/editsmstemplate").toString();
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("sid", config.getSid());
			jsonObject.put("token", config.getToken());
			jsonObject.put("appid", config.getAppid());
			jsonObject.put("templateid", templateid);
			jsonObject.put("type", type);
			jsonObject.put("template_name", template_name);
			jsonObject.put("autograph", autograph);
			jsonObject.put("content", content);
			
			String body = jsonObject.toJSONString();
			
			System.out.println("body = " + body);
			
			result = HttpClientUtil.postJson(url, body, null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String deleterSmsTemplate(String templateid) {

		String result = "";
		
		try {
			String url = getStringBuffer().append("/deletesmstemplate").toString();
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("sid", config.getSid());
			jsonObject.put("token", config.getToken());
			jsonObject.put("appid", config.getAppid());
			jsonObject.put("templateid", templateid);
			
			String body = jsonObject.toJSONString();
			
			System.out.println("body = " + body);
			
			result = HttpClientUtil.postJson(url, body, null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
