package com.jzsk.filecode.service;

import org.springframework.stereotype.Service;

import com.jzsk.filecode.model.value.UserInfo;

@Service
public interface UserService {
	
	public UserInfo selectByLoginName(String loginName);
}
