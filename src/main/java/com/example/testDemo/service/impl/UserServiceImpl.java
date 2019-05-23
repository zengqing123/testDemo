/**
 * <b>项目名：</b>中国联通工程质量管理系统<br/>
 * <b>包   名：</b>com.example.testDemo.service.impl<br/>
 * <b>文件名：</b>UserServiceImpl.java<br/>
 * <b>版本信息：</b>1.0.0<br/>
 * <b>日期：</b>2019年3月20日-上午9:30:24<br/>
 * <b>Copyright (c)</b> 2019 中国联通上海分公司产互研发中心-版权所有<br/>
 * 
 */
package com.example.testDemo.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testDemo.dao.UserInfoDao;
import com.example.testDemo.entity.UserInfoEntity;
import com.example.testDemo.service.UserService;

/**
 * <b>类   名：</b>UserServiceImpl<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>lenovo<br/>
 * <b>创建时间：</b>2019年3月20日 上午9:30:24<br/>
 * <b>修改人：</b>lenovo<br/>
 * <b>修改时间：</b>2019年3月20日 上午9:30:24<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br/>
 * 
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserInfoDao userInfoDao;
	/* (non-Javadoc)
	 * @see com.example.testDemo.service.UserService#login()
	 */
	@Override
	public UserInfoEntity login(Map<String, Object> map) {
		return userInfoDao.infoList(map);
	}

}
