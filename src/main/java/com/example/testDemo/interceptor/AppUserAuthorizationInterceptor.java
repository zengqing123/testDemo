/**
 * <b>项目名：</b>中国联通工程质量管理系统<br/>
 * <b>包   名：</b>com.example.testDemo.interceptor<br/>
 * <b>文件名：</b>AppUserAuthorizationInterceptor.java<br/>
 * <b>版本信息：</b>1.0.0<br/>
 * <b>日期：</b>2019年3月25日-下午1:44:18<br/>
 * <b>Copyright (c)</b> 2019 中国联通上海分公司产互研发中心-版权所有<br/>
 * 
 */
package com.example.testDemo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.druid.util.StringUtils;
import com.example.testDemo.annotation.IgnoreAuth;
import com.example.testDemo.utils.RRException;


/**
 * <b>类   名：</b>AppUserAuthorizationInterceptor<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>lenovo<br/>
 * <b>创建时间：</b>2019年3月25日 下午1:44:18<br/>
 * <b>修改人：</b>lenovo<br/>
 * <b>修改时间：</b>2019年3月25日 下午1:44:18<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br/>
 * 
 */
@Component
public class AppUserAuthorizationInterceptor extends HandlerInterceptorAdapter{

	private static Logger log = LoggerFactory.getLogger(AppUserAuthorizationInterceptor.class);
	 @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	        // 请求开始时间

	        if (handler != null && handler instanceof HandlerMethod && log.isInfoEnabled()) {
	            HandlerMethod methodHandler = (HandlerMethod) handler;
	            log.info("  Request URL = {}", request.getRequestURL().toString());
	            log.info(">> Controller BEGIN:{}.{}", methodHandler.getBean().getClass().getName(), methodHandler.getMethod().getName());
	        }
	        
	        IgnoreAuth ignoreAuth;
			if (handler instanceof HandlerMethod) {
				ignoreAuth = ((HandlerMethod) handler).getMethodAnnotation(IgnoreAuth.class);
			}else {
				return true;
			}
			
			if (ignoreAuth != null) {
				return true;
			}
			String token = request.getHeader("token");
			if (StringUtils.isEmpty(token)) {
				token = request.getParameter("token");
			}
			
			if (StringUtils.isEmpty(token)) {
				throw new RRException("token不能为空");
			}
			return true;

}
}