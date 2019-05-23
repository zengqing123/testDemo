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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/appUser/card")
@Api("卡号管理")
public class CardContrller {

	@PostMapping("/login")
	@ApiOperation(value="获取用户详细信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "访问凭证", required = true, dataType = "String",paramType="header"),
		@ApiImplicitParam(name = "userName", value = "帐号", required = true, dataType = "String",paramType = "query"),
		@ApiImplicitParam(name = "passWord", value = "密码", required = true, dataType = "String",paramType = "query")
	})
	public Result login(String userName,String passWord){
		return Result.ok().put("msg","启动成功");
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
	
	@GetMapping("/list")
	@ApiOperation(value="列表")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "访问凭证", required = true, dataType = "String",paramType="header"),
		@ApiImplicitParam(name = "userName", value = "帐号", required = true, dataType = "String",paramType = "query"),
		@ApiImplicitParam(name = "passWord", value = "密码", required = true, dataType = "String",paramType = "query")
	})
	public Result list(String userName,String passWord){
		return Result.ok().put("msg","启动成功");
	}
}
