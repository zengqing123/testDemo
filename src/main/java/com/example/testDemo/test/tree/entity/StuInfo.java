/**
 * <b>包   名：</b>com.example.testDemo.test.tree.entity<br/>
 * <b>文件名：</b>Stu.java<br/>
 * <b>版本信息：</b>1.0.0<br/>
 * <b>日期：</b>2019年4月28日-上午10:44:26<br/>
 * <b>Copyright (c)</b> 2019 中国联通上海分公司产互研发中心-版权所有<br/>
 * 
 */
package com.example.testDemo.test.tree.entity;

import java.io.Serializable;

/**
 * <b>类   名：</b>Stu<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>lenovo<br/>
 * <b>创建时间：</b>2019年4月28日 上午10:44:26<br/>
 * <b>修改人：</b>lenovo<br/>
 * <b>修改时间：</b>2019年4月28日 上午10:44:26<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br/>
 * 
 */
public class StuInfo implements Serializable{

	private static final long serialVersionUID = -5143930806907061336L;
	
	private Integer age;
	private String name;
	private String sex;
	/**
	 * 取得 age
	 *
	 * @return age
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * 设置 age
	 *
	 * @param age
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * 取得 name
	 *
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置 name
	 *
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 取得 sex
	 *
	 * @return sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 设置 sex
	 *
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

}
