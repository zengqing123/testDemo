/**
 * <b>项目名：</b>中国联通工程质量管理系统<br/>
 * <b>包   名：</b>com.example.testDemo.api<br/>
 * <b>文件名：</b>UserInfoContrller.java<br/>
 * <b>版本信息：</b>1.0.0<br/>
 * <b>日期：</b>2019年3月19日-下午1:52:38<br/>
 * <b>Copyright (c)</b> 2019 中国联通上海分公司产互研发中心-版权所有<br/>
 * 
 */
package com.example.testDemo.api;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testDemo.annotation.IgnoreAuth;
import com.example.testDemo.entity.UserInfoEntity;
import com.example.testDemo.service.AbsRestClient;
import com.example.testDemo.service.UserService;
import com.example.testDemo.utils.MD5Util;
import com.example.testDemo.utils.RRException;
import com.example.testDemo.utils.Result;

/**
 * <b>类   名：</b>UserInfoContrller<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>lenovo<br/>
 * <b>创建时间：</b>2019年3月19日 下午1:52:38<br/>
 * <b>修改人：</b>lenovo<br/>
 * <b>修改时间：</b>2019年3月19日 下午1:52:38<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br/>
 * 
 */
@RestController
@RequestMapping("/api/test")
@Api("用户信息")
public class UserInfoContrller {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AbsRestClient absRestClient;
//	@Autowired
//	private StringRedisTemplate stringRedisTemplate;
	
	@IgnoreAuth
	@PostMapping("/login")
	@ApiOperation(value="获取用户详细信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "访问凭证", required = false, dataType = "String",paramType="header"),
		@ApiImplicitParam(name = "userAccont", value = "帐号", required = true, dataType = "String",paramType = "query"),
		@ApiImplicitParam(name = "passWord", value = "密码", required = true, dataType = "String",paramType = "query")
	})
	public Result login(String userAccont,String passWord){
		
//		absRestClient.sendSms("444299","","18516383352","");发送短信
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isEmpty(userAccont)) {
			throw new RRException("帐号不能为空");
		}
		if (StringUtils.isEmpty(passWord)) {
			throw new RRException("密码不能为空");
		}
		map.put("userAccont", userAccont);
//		stringRedisTemplate.opsForValue().set("键", "值",过期时间 , 时间单位);
		UserInfoEntity entity = userService.login(map);
		if (entity == null) {
			throw new RRException("用户不存在");
		}
		String pwd = MD5Util.stringMD5(passWord);
		if (!pwd.equalsIgnoreCase(entity.getPassWord())) {
			throw new RRException("密码错误");
		}
		String uuid = UUID.randomUUID().toString();
		String token = uuid.replaceAll("-", "");
//		stringRedisTemplate.opsForValue().set(userAccont, token,60*60,TimeUnit.SECONDS);
//		stringRedisTemplate.opsForValue().set(token,JSON.toJSONString(entity),60*60,TimeUnit.SECONDS);
		return Result.ok().put("token", token).put("result", entity);
	}
	
	@PostMapping("/update")
	@ApiOperation(value="获取用户详细信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "访问凭证", required = true, dataType = "String",paramType="header"),
		@ApiImplicitParam(name = "userName", value = "帐号", required = true, dataType = "String",paramType = "query"),
		@ApiImplicitParam(name = "passWord", value = "密码", required = true, dataType = "String",paramType = "query")
	})
	public Result update(String userName,String passWord){
		System.out.println("帐号："+userName+"\n"+"密码："+passWord);
		return Result.ok().put("msg","启动成功");
	}
}
