/**
 * <b>项目名：</b>中国联通工程质量管理系统<br/>
 * <b>包   名：</b>com.example.testDemo.config<br/>
 * <b>文件名：</b>SMSConfig.java<br/>
 * <b>版本信息：</b>1.0.0<br/>
 * <b>日期：</b>2019年3月20日-下午4:53:55<br/>
 * <b>Copyright (c)</b> 2019 中国联通上海分公司产互研发中心-版权所有<br/>
 * 
 */
package com.example.testDemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * <b>类   名：</b>SMSConfig<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>lenovo<br/>
 * <b>创建时间：</b>2019年3月20日 下午4:53:55<br/>
 * <b>修改人：</b>lenovo<br/>
 * <b>修改时间：</b>2019年3月20日 下午4:53:55<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br/>
 * 
 */
@Component
public class SMSConfig {
	
	@Value("${SMS.sid}")
	private String sid;
	@Value("${SMS.token}")
	private String token;
	@Value("${SMS.appid}")
	private String appid;
	/**
	 * 取得 sid
	 *
	 * @return sid
	 */
	public String getSid() {
		return sid;
	}
//	/**
//	 * 设置 sid
//	 *
//	 * @param sid
//	 */
//	public void setSid(String sid) {
//		this.sid = sid;
//	}
	/**
	 * 取得 token
	 *
	 * @return token
	 */
	public String getToken() {
		return token;
	}
//	/**
//	 * 设置 token
//	 *
//	 * @param token
//	 */
//	public void setToken(String token) {
//		this.token = token;
//	}
	/**
	 * 取得 appid
	 *
	 * @return appid
	 */
	public String getAppid() {
		return appid;
	}
//	/**
//	 * 设置 appid
//	 *
//	 * @param appid
//	 */
//	public void setAppid(String appid) {
//		this.appid = appid;
//	}

}
