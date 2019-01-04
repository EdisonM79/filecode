package com.jzsk.dao;

import com.jzsk.entity.User;

public interface  UserDao {
	public abstract User findByUsername(String username);
}
