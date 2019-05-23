/**
 * @author Glan.duanyj
 * @date 2014-05-12
 * @project rest_demo
 */
package com.example.testDemo.service;

import com.example.testDemo.utils.SysConfig;




public abstract class AbsRestClient {
	public String server=SysConfig.getInstance().getProperty("rest_server");
	
	/**
	 * 
	 * @param sid
	 * @param token
	 * @param appid
	 * @param templateid
	 * @param param
	 * @param mobile
	 * @param uid
	 * @return
	 */
	public abstract String sendSms(String templateid, String param, String mobile, String uid);
	
	/**
	 * 
	 * @param sid
	 * @param token
	 * @param appid
	 * @param templateid
	 * @param param
	 * @param mobile
	 * @param uid
	 * @return
	 */
	public abstract String sendSmsBatch(String templateid, String param, String mobile, String uid);
	
	/**
	 * 
	 * @param sid
	 * @param token
	 * @param appid
	 * @param type
	 * @param template_name
	 * @param autograph
	 * @param content
	 * @return
	 */
	public abstract String addSmsTemplate(String type, String template_name, String autograph, String content);
	 
	/**
	 * 
	 * @param sid
	 * @param token
	 * @param appid
	 * @param templateid
	 * @param page_num
	 * @param page_size
	 * @return
	 */
	public abstract String getSmsTemplate(String templateid, String page_num, String page_size);
	
	/**
	 * 
	 * @param sid
	 * @param token
	 * @param appid
	 * @param templateid
	 * @param type
	 * @param template_name
	 * @param autograph
	 * @param content
	 * @return
	 */
	public abstract String editSmsTemplate(String templateid, String type, String template_name, String autograph, String content);
	
	/**
	 * 
	 * @param sid
	 * @param token
	 * @param appid
	 * @param templateid
	 * @return
	 */
	public abstract String deleterSmsTemplate(String templateid);
	
	
	public StringBuffer getStringBuffer() {
		StringBuffer sb = new StringBuffer("https://");
		sb.append(server).append("/ol/sms");
		return sb;
	}
}
