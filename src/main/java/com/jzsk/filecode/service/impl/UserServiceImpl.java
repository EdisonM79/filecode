package com.jzsk.filecode.service.impl;

import java.util.ArrayList;
import java.util.List;

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
	public UserInfo selectByLoginName(String loginName) {

		UserInfo userInfo = new UserInfo();
		TrUser trUser = new TrUser();

		trUser = userDao.selectByLoginName(loginName);
		if (null != trUser) {
			userInfo.setDepartment(trUser.getDepartment());
			userInfo.setEmail(trUser.getEmail());
			userInfo.setPassword(trUser.getPassword());
			userInfo.setLoginName(trUser.getLoginName());
			userInfo.setRole(trUser.getRole());
			userInfo.setUserId(trUser.getUserId());
			userInfo.setUserName(trUser.getUserName());
		}

		return userInfo;
	}

	@Override
	public List<UserInfo> selectAllUser() {
		// TODO Auto-generated method stub
		
		List<UserInfo> userInfoList = new ArrayList<>();
		List<TrUser> trUserList = new ArrayList<>();
		trUserList = userDao.selectAllUser();
		for (TrUser trUser : trUserList) {
			
			UserInfo user = new UserInfo();
			user.setDepartment(trUser.getDepartment());
			user.setEmail(trUser.getEmail());
			user.setPassword(trUser.getPassword());
			user.setLoginName(trUser.getLoginName());
			user.setRole(trUser.getRole());
			user.setUserId(trUser.getUserId());
			user.setUserName(trUser.getUserName());
			userInfoList.add(user);
		}
		return userInfoList;
	}

	@Override
	public int addUser(UserInfo user) {
		TrUser newUser = new TrUser();
		
		newUser.setDepartment(user.getDepartment());
		newUser.setEmail(user.getEmail());
		newUser.setLoginName(user.getLoginName());
		newUser.setPassword(user.getPassword());
		newUser.setRole(user.getRole());
		newUser.setUserId(user.getUserId());
		newUser.setUserName(user.getUserName());
		int result = userDao.addUser(newUser);
		return result;
	}

	@Override
	public UserInfo selectByPrimaryKey(String userId) {
		// TODO Auto-generated method stub
		TrUser trUser = userDao.selectByPrimaryKey(userId);
		UserInfo user = new UserInfo();
		user.setDepartment(trUser.getDepartment());
		user.setEmail(trUser.getEmail());
		user.setPassword(trUser.getPassword());
		user.setLoginName(trUser.getLoginName());
		user.setRole(trUser.getRole());
		user.setUserId(trUser.getUserId());
		user.setUserName(trUser.getUserName());
		
		return user;
	}
}
