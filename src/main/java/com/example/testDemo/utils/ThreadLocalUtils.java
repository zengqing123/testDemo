/**
 * <b>包   名：</b>com.example.testDemo.utils<br/>
 * <b>文件名：</b>ThreadLocalUtils.java<br/>
 * <b>版本信息：</b>1.0.0<br/>
 * <b>日期：</b>2019年4月26日-上午11:24:04<br/>
 * <b>Copyright (c)</b> 2019 中国联通上海分公司产互研发中心-版权所有<br/>
 * 
 */
package com.example.testDemo.utils;

/**
 * <b>类   名：</b>ThreadLocalUtils<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>lenovo<br/>
 * <b>创建时间：</b>2019年4月26日 上午11:24:04<br/>
 * <b>修改人：</b>lenovo<br/>
 * <b>修改时间：</b>2019年4月26日 上午11:24:04<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br/>
 * 
 */
public class ThreadLocalUtils {
	private static ThreadLocal<Object> local = new ThreadLocal<Object>();
	public static Object get(){
		return local.get();
	}
	public static void set(String a){
		local.set(a);
	}

}
