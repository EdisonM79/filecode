package com.jzsk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzsk.model.entity.TrUser;
import com.jzsk.model.mapper.TrUserMapper;
import com.jzsk.model.value.UserInfo;

@Service
public class UserService {
	
	@Autowired
	private TrUserMapper trUserMapper;
	
	public UserInfo selectByLoginName(String loginName){
		
		UserInfo userInfo = new UserInfo();
		TrUser trUser = new TrUser();
		
		trUser = trUserMapper.selectByLoginName(loginName);
		
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
