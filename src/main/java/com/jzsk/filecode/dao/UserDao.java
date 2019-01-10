package com.jzsk.filecode.dao;

import java.util.List;

import com.jzsk.filecode.model.entity.TrUser;

public interface UserDao {

	TrUser selectByLoginName(String loginName);
	
	List<TrUser> selectAllUser();
	
	Integer addUser(TrUser user);
}
