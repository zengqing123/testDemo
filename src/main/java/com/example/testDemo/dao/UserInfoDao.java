/**
 * <b>项目名：</b>中国联通工程质量管理系统<br/>
 * <b>包   名：</b>com.example.testDemo.dao<br/>
 * <b>文件名：</b>UserInfoDao.java<br/>
 * <b>版本信息：</b>1.0.0<br/>
 * <b>日期：</b>2019年3月20日-上午9:30:56<br/>
 * <b>Copyright (c)</b> 2019 中国联通上海分公司产互研发中心-版权所有<br/>
 * 
 */
package com.example.testDemo.dao;

import java.util.Map;

import com.example.testDemo.entity.UserInfoEntity;

/**
 * <b>类   名：</b>UserInfoDao<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>lenovo<br/>
 * <b>创建时间：</b>2019年3月20日 上午9:30:56<br/>
 * <b>修改人：</b>lenovo<br/>
 * <b>修改时间：</b>2019年3月20日 上午9:30:56<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br/>
 * 
 */
public interface UserInfoDao {

	UserInfoEntity infoList(Map<String, Object> map);
	
	Integer count();
	
	void buy(Map<String, Object> map);
}
