/**
 * <b>项目名：</b>中国联通工程质量管理系统<br/>
 * <b>包   名：</b>com.example.testDemo.config<br/>
 * <b>文件名：</b>MvcConfig.java<br/>
 * <b>版本信息：</b>1.0.0<br/>
 * <b>日期：</b>2019年3月19日-下午3:39:17<br/>
 * <b>Copyright (c)</b> 2019 中国联通上海分公司产互研发中心-版权所有<br/>
 * 
 */
package com.example.testDemo.config;

import com.example.testDemo.interceptor.Adapter;
import com.example.testDemo.interceptor.AllAdapter;
import com.example.testDemo.interceptor.AppUserAuthorizationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <b>类   名：</b>MvcConfig<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>lenovo<br/>
 * <b>创建时间：</b>2019年3月19日 下午3:39:17<br/>
 * <b>修改人：</b>lenovo<br/>
 * <b>修改时间：</b>2019年3月19日 下午3:39:17<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br/>
 * 
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer{

	 	@Autowired
	   private Adapter adapter;
	 	@Autowired
	 	private AppUserAuthorizationInterceptor appUserAuthorizationInterceptor;
	 	@Autowired
	 	private AllAdapter allAdapter;
	 	
	 	 @Override
	     public void addInterceptors(InterceptorRegistry registry) {
	         registry.addInterceptor(appUserAuthorizationInterceptor).addPathPatterns("/appUser/**");
	         registry.addInterceptor(adapter).addPathPatterns("/api/**");
	         registry.addInterceptor(allAdapter).addPathPatterns("/**");

	     }
	 	 
	 	@Bean
	    public FilterRegistrationBean<CorsFilter> corsFilter() {
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        CorsConfiguration config = new CorsConfiguration();
	        config.setAllowCredentials(true);
	        config.addAllowedOrigin("*");
	        config.addAllowedHeader("*");
	        config.addAllowedMethod("*");
	        source.registerCorsConfiguration("/**", config);
	        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(source));
	        bean.setOrder(0);
	        return bean;	
	    }
}
