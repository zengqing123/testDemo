/**
 * <b>项目名：</b>中国联通工程质量管理系统<br/>
 * <b>包   名：</b>com.example.testDemo.interceptor<br/>
 * <b>文件名：</b>AllAdapter.java<br/>
 * <b>版本信息：</b>1.0.0<br/>
 * <b>日期：</b>2019年3月26日-上午9:22:07<br/>
 * <b>Copyright (c)</b> 2019 中国联通上海分公司产互研发中心-版权所有<br/>
 * 
 */
package com.example.testDemo.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;


/**
 * <b>类   名：</b>AllAdapter<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>lenovo<br/>
 * <b>创建时间：</b>2019年3月26日 上午9:22:07<br/>
 * <b>修改人：</b>lenovo<br/>
 * <b>修改时间：</b>2019年3月26日 上午9:22:07<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br/>
 * 
 */
@Component
public class AllAdapter extends HandlerInterceptorAdapter{
	
	private static Logger log = LoggerFactory.getLogger(AppUserAuthorizationInterceptor.class);
	 @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		 String url =request.getRequestURL().toString();
			log.info("访问地址："+url+"  ["+request.getMethod()+"]");
			Map<String, String[]> map =request.getParameterMap();
			if (map.size()>0){
				StringBuffer param=new StringBuffer("");
				for (Map.Entry<?,?> entry :map.entrySet()){
					param.append("&"+(String)entry.getKey()+"=");
					String[] val=(String[])entry.getValue();
					param.append(Arrays.toString(val));
				}
				log.info("访问参数："+param.toString());
			}

			return true;
		}

}

