package com.jzsk.filecode.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jzsk.filecode.model.value.UserInfo;

@Service
public interface UserService {
	
	UserInfo selectByLoginName(String loginName);
	
	List<UserInfo> selectAllUser();
	
	int addUser(UserInfo user);
	
	UserInfo selectByPrimaryKey(String userId);
	
	int countAll();
}
