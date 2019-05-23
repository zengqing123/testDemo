/**
 * <b>项目名：</b>中国联通工程质量管理系统<br/>
 * <b>包   名：</b>com.example.testDemo.interceptor<br/>
 * <b>文件名：</b>Adapter.java<br/>
 * <b>版本信息：</b>1.0.0<br/>
 * <b>日期：</b>2019年3月19日-下午3:34:28<br/>
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

import com.example.testDemo.annotation.IgnoreAuth;

/**
 * <b>类   名：</b>Adapter<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>lenovo<br/>
 * <b>创建时间：</b>2019年3月19日 下午3:34:28<br/>
 * <b>修改人：</b>lenovo<br/>
 * <b>修改时间：</b>2019年3月19日 下午3:34:28<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br/>
 * 
 */
@Component
public class Adapter extends HandlerInterceptorAdapter{
	
//	@Autowired
//	private StringRedisTemplate stringRedisTemplate;
	
	private static Logger log = LoggerFactory.getLogger(Adapter.class);
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (handler != null && handler instanceof HandlerMethod && log.isInfoEnabled()) {
			HandlerMethod methodHandler = (HandlerMethod)handler;
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
//		String token = request.getHeader("token");
//		if (StringUtils.isEmpty(token)) {
//			token = request.getParameter("token");
//		}
//
//		if (StringUtils.isEmpty(token)) {
//			throw new RRException("token不能为空");
//		}
//		String result = stringRedisTemplate.opsForValue().get(token);
//		if (StringUtils.isEmpty(result)) {
//			throw new RRException("token失效！",-999);
//		}
//		UserInfoEntity entity = JSON.parseObject(result,UserInfoEntity.class);
//		stringRedisTemplate.opsForValue().set(entity.getUserAccont(), token,60*60,TimeUnit.SECONDS);
//		stringRedisTemplate.opsForValue().set(token, JSON.toJSONString(entity),60*60,TimeUnit.SECONDS);
		return true;
	}
}
