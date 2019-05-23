/**
 * <b>包   名：</b>com.example.testDemo.config<br/>
 * <b>文件名：</b>JedisConnectionFactoryConfig.java<br/>
 * <b>版本信息：</b>1.0.0<br/>
 * <b>日期：</b>2019年4月26日-下午1:20:58<br/>
 * <b>Copyright (c)</b> 2019 中国联通上海分公司产互研发中心-版权所有<br/>
 * 
 */
package com.example.testDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.example.testDemo.entity.UserInfoEntity;

/**
 * <b>类   名：</b>JedisConnectionFactoryConfig<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>lenovo<br/>
 * <b>创建时间：</b>2019年4月26日 下午1:20:58<br/>
 * <b>修改人：</b>lenovo<br/>
 * <b>修改时间：</b>2019年4月26日 下午1:20:58<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br/>
 * 
 */
@Configuration
public class JedisConnectionFactoryConfig {

	@Bean
	public JedisConnectionFactory jedisConnectionFactory(){
		RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
//		config.setHostName("localhost");
//		config.setPassword("");
//		config.setPort(6379);
//		config.setDatabase(0);
//		JedisConnectionFactory factory = new JedisConnectionFactory();
//		factory.setPassword("");
//		factory.setPort(6379);
//		factory.setHostName("localhost");
		return new JedisConnectionFactory(config);
	}

	@Bean("jedisPool")
	public JedisPool jedisPoolConfig(){
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(10);
        return new JedisPool(jedisPoolConfig,"localhost",6379);
	}
	@Bean("userInfo")
	public UserInfoEntity userInfoEntity(){
		UserInfoEntity entity = new UserInfoEntity();
		entity.setUserAccont("123");
		return entity;
	}
	
}
