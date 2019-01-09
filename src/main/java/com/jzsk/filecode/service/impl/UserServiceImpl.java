package com.jzsk.filecode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzsk.filecode.dao.UserDao;
import com.jzsk.filecode.model.entity.TrUser;
import com.jzsk.filecode.model.value.UserInfo;
import com.jzsk.filecode.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserInfo selectByLoginName(String loginName){
		
		UserInfo userInfo = new UserInfo();
		TrUser trUser = new TrUser();
		
		trUser = userDao.selectByLoginName(loginName);
		
		userInfo.setDepartment(trUser.getDepartment());
		userInfo.setEmail(trUser.getEmail());
		userInfo.setPassword(trUser.getPassword());
		userInfo.setLoginName(trUser.getLoginName());
		userInfo.setRole(trUser.getRole());
		userInfo.setUserId(trUser.getUserId());
		userInfo.setUserName(trUser.getUserName());
		
		return userInfo;
	}
}
