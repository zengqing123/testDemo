/**
 * <b>项目名：</b>中国联通工程质量管理系统<br/>
 * <b>包   名：</b>com.example.testDemo.config<br/>
 * <b>文件名：</b>ThreadConfig.java<br/>
 * <b>版本信息：</b>1.0.0<br/>
 * <b>日期：</b>2019年4月2日-下午2:09:51<br/>
 * <b>Copyright (c)</b> 2019 中国联通上海分公司产互研发中心-版权所有<br/>
 * 
 */
package com.example.testDemo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * <b>类   名：</b>ThreadConfig<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>lenovo<br/>
 * <b>创建时间：</b>2019年4月2日 下午2:09:51<br/>
 * <b>修改人：</b>lenovo<br/>
 * <b>修改时间：</b>2019年4月2日 下午2:09:51<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br/>
 * 
 */
@Configuration
@EnableAsync
public class ThreadConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(ThreadConfig.class);

	@Bean("asyncServiceExecutor")
	public Executor asyncServiceExecutor(){
		logger.info("start asyncServiceExecutor");
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setMaxPoolSize(20);
		executor.setCorePoolSize(5);
		executor.setQueueCapacity(9999);
		executor.setThreadNamePrefix("async-service-");
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		executor.setKeepAliveSeconds(10000);
		executor.initialize();
		return executor;
	}
}
