/**
 * <b>项目名：</b>中国联通工程质量管理系统<br/>
 * <b>包   名：</b>com.example.testDemo.service.impl<br/>
 * <b>文件名：</b>RedisLockImpl.java<br/>
 * <b>版本信息：</b>1.0.0<br/>
 * <b>日期：</b>2019年4月4日-下午3:13:25<br/>
 * <b>Copyright (c)</b> 2019 中国联通上海分公司产互研发中心-版权所有<br/>
 * 
 */
package com.example.testDemo.service.impl;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import javax.annotation.Resource;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.example.testDemo.utils.ThreadLocalUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * <b>类   名：</b>RedisLockImpl<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>lenovo<br/>
 * <b>创建时间：</b>2019年4月4日 下午3:13:25<br/>
 * <b>修改人：</b>lenovo<br/>
 * <b>修改时间：</b>2019年4月4日 下午3:13:25<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br/>
 * 
 */
@Service("redisLock")
public class RedisLockImpl implements Lock {
//	Jedis jedis = new Jedis("localhost",6379);
//	@Autowired
//	private JedisConnectionFactory factory;
//	JedisConnectionFactory factory = new JedisConnectionFactory();
//	public RedisLockImpl(){
//		this.factory.setPassword("");
//		this.factory.setPort(6379);
//		this.factory.setHostName("localhost");
//	}
//	@Autowired
	@Resource(name = "jedisPool")
	private JedisPool pool;
	
	
//	private Jedis jedis = (Jedis)factory.getConnection().getNativeConnection();
	private static final String key = "key";
	
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	/* (non-Javadoc)
	 * @see java.util.concurrent.locks.Lock#lock()
	 */
	@Override
	public void lock() {
		while (true) {
			if (tryLock()) {
				return;
            }
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/* (non-Javadoc)
	 * @see java.util.concurrent.locks.Lock#lockInterruptibly()
	 */
	@Override
	public void lockInterruptibly() throws InterruptedException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.util.concurrent.locks.Lock#newCondition()
	 */
	@Override
	public Condition newCondition() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.concurrent.locks.Lock#tryLock()
	 */
	@Override
	public boolean tryLock() {
//		Jedis jedis = (Jedis)factory.getConnection().getNativeConnection();
		Jedis jedis = pool.getResource();
		String value = UUID.randomUUID().toString();
		ThreadLocalUtils.set(value);
//		stringRedisTemplate.opsForValue().setIfAbsent("","");
		try {
			String result = jedis.set(key, value, "NX", "PX",2000);
				if (!StringUtils.isEmpty(result)&&result.equalsIgnoreCase("ok")) {
					return true;
				}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			if (jedis != null) {
				jedis.close();
			}
		}
			return false;
	}

	/* (non-Javadoc)
	 * @see java.util.concurrent.locks.Lock#tryLock(long, java.util.concurrent.TimeUnit)
	 */
	@Override
	public boolean tryLock(long arg0, TimeUnit arg1)
			throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.concurrent.locks.Lock#unlock()
	 */
	@Override
	public void unlock() {
//		Jedis jedis = (Jedis)factory.getConnection().getNativeConnection();
		Jedis jedis = pool.getResource();
		String value = ThreadLocalUtils.get().toString();
		String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        jedis.eval(script, Collections.singletonList(key), Collections.singletonList(value));
        if (jedis != null) {
			jedis.close();
		}
	}

}
