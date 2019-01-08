package com.jzsk.model.form;

import com.jzsk.model.value.UserInfo;

public class UserLoginForm {

	private UserInfo userInfo;
	private String code;

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "UserLoginForm [userInfo=" + userInfo + ", code=" + code + "]";
	}


}
