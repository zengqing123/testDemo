/**
 * <b>项目名：</b>中国联通工程质量管理系统<br/>
 * <b>包   名：</b>com.example.testDemo.api<br/>
 * <b>文件名：</b>ThreadContrller.java<br/>
 * <b>版本信息：</b>1.0.0<br/>
 * <b>日期：</b>2019年4月2日-下午2:22:07<br/>
 * <b>Copyright (c)</b> 2019 中国联通上海分公司产互研发中心-版权所有<br/>
 * 
 */
package com.example.testDemo.api;

import com.example.testDemo.service.AsyncService;
import com.example.testDemo.service.impl.RunnAbleImpl;
import com.example.testDemo.utils.Result;
import com.google.common.util.concurrent.RateLimiter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

/**
 * <b>类   名：</b>ThreadContrller<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>lenovo<br/>
 * <b>创建时间：</b>2019年4月2日 下午2:22:07<br/>
 * <b>修改人：</b>lenovo<br/>
 * <b>修改时间：</b>2019年4月2日 下午2:22:07<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br/>
 * 
 */
@RestController
@Api("线程池测试")
@RequestMapping("/api/thread")
public class ThreadContrller{
	private static final Logger logger = LoggerFactory.getLogger(ThreadContrller.class);

	@Autowired
	private AsyncService asyncService;
	@Resource(name="redisLock")
	private Lock lock;


	RateLimiter limiter = RateLimiter.create(2.0);

	@GetMapping("/test1")
	@ApiOperation("demo1")
	public Result test1(){
		logger.info("开始contrller");
		Future<String> async = asyncService.executeAsync();
		logger.info("调用结束");
		String string = "";
		try {
			string = async.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return Result.ok().put("threadName", string);
	}
	@GetMapping("/test2")
	@ApiOperation("123")
	public Result test2(){
		CountDownLatch latch = new CountDownLatch(100);
		RunnAbleImpl impl = new RunnAbleImpl(asyncService,latch);
		int a = 100;
		List<String> resultList = new ArrayList<>();
		for (int i = 0; i < a; i++) {
			new Thread(impl,String.valueOf(i)).start();
		}
		try {
			Thread.currentThread().join(5000);
			resultList = impl.getList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Result.ok().put("result", resultList);
	}
	
}
