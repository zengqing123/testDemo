/**
 * <b>项目名：</b>中国联通工程质量管理系统<br/>
 * <b>包   名：</b>com.example.testDemo.entity<br/>
 * <b>文件名：</b>UserInfoEntity.java<br/>
 * <b>版本信息：</b>1.0.0<br/>
 * <b>日期：</b>2019年3月26日-下午3:24:48<br/>
 * <b>Copyright (c)</b> 2019 中国联通上海分公司产互研发中心-版权所有<br/>
 * 
 */
package com.example.testDemo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>类   名：</b>UserInfoEntity<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>lenovo<br/>
 * <b>创建时间：</b>2019年3月26日 下午3:24:48<br/>
 * <b>修改人：</b>lenovo<br/>
 * <b>修改时间：</b>2019年3月26日 下午3:24:48<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br/>
 * 
 */
public class UserInfoEntity implements Serializable{

	private static final long serialVersionUID = 4537534070416809700L;
	
	private int id;
	private String userName;
	private String userAccont;
	private String passWord;
	private int userRole;
	private Date userBorth;
	private String userPhone;
	private int createUserId;
	private Date createTime;
	private int deletFlag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAccont() {
		return userAccont;
	}

	public void setUserAccont(String userAccont) {
		this.userAccont = userAccont;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getUserRole() {
		return userRole;
	}

	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

	public Date getUserBorth() {
		return userBorth;
	}

	public void setUserBorth(Date userBorth) {
		this.userBorth = userBorth;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public int getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getDeletFlag() {
		return deletFlag;
	}

	public void setDeletFlag(int deletFlag) {
		this.deletFlag = deletFlag;
	}

//	@Override
//	public int hashCode() {
//		String result = userAccont;
//		return result.hashCode();
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj) return true;
//		Entity entity = (Entity)obj;
//		return entity.getUserAccont().equalsIgnoreCase(this.userAccont);
//	}
}
