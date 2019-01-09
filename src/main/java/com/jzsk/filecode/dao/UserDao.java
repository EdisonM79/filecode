package com.jzsk.filecode.dao;

import com.jzsk.filecode.model.entity.TrUser;

public interface UserDao {

	TrUser selectByLoginName(String loginName);
}
