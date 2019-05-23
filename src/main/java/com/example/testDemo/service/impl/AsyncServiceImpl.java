/**
 * <b>项目名：</b>中国联通工程质量管理系统<br/>
 * <b>包   名：</b>com.example.testDemo.service.impl<br/>
 * <b>文件名：</b>AsyncServiceImpl.java<br/>
 * <b>版本信息：</b>1.0.0<br/>
 * <b>日期：</b>2019年4月2日-下午2:16:37<br/>
 * <b>Copyright (c)</b> 2019 中国联通上海分公司产互研发中心-版权所有<br/>
 * 
 */
package com.example.testDemo.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.testDemo.dao.UserInfoDao;
import com.example.testDemo.service.AsyncService;

/**
 * <b>类   名：</b>AsyncServiceImpl<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>lenovo<br/>
 * <b>创建时间：</b>2019年4月2日 下午2:16:37<br/>
 * <b>修改人：</b>lenovo<br/>
 * <b>修改时间：</b>2019年4月2日 下午2:16:37<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br/>
 * 
 */
@Service
public class AsyncServiceImpl implements AsyncService {

	private static final Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);
	@Autowired
	private UserInfoDao userInfoDao;
	
	
	@Resource(name="redisLock")
	private Lock lock;
	/* (non-Javadoc)
	 * @see com.example.testDemo.service.AsyncService#executeAsync()
	 */
	@Override
	@Async("asyncServiceExecutor")
	public Future<String> executeAsync() {
		logger.info("start executeAsync");
		System.out.println(Thread.currentThread().getName());
		try {
			if (lock.tryLock()) {
				System.out.println("加锁了");
				Map<String, Object> map = new HashMap<>();
				Integer count = userInfoDao.count();
				Integer shen = count-1;
				map.put("dd", shen);
				userInfoDao.buy(map);
				System.out.println(Thread.currentThread().getName()+"买了第"+count+"张票，还剩下"+shen+"张票");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
			System.out.println("解锁了");
		}
		logger.info("end executeAsync");
//		new AsyncResult<V>();线程池执行的结果
		return new AsyncResult<>(Thread.currentThread().getName());
	}
	/* (non-Javadoc)
	 * @see com.example.testDemo.service.AsyncService#buy()
	 */
	@Override
	public String buy() {
		lock.lock();
		String a = "";
				try {
					Map<String, Object> map = new HashMap<>();
					Integer count = userInfoDao.count();
					Integer shen = count-1;
					map.put("dd", shen);
					userInfoDao.buy(map);
					System.out.println(Thread.currentThread().getName()+":"+count+"，"+shen);
					a = Thread.currentThread().getName()+":"+count+"，"+shen;
				} catch (Exception e) {
					
				}finally{
					lock.unlock();
				}
		 return a;
	}

}
