/**
 * 
 */
package com.jzsk.model.value.common;

import java.util.Set;

/**
 * @author LiuYangTao
 *
 */
public class UserValue {

	/** 用户ID */
	private String userId;
	/** 用户账户 */
	private String userIp;
	/** COOKIE用密码 */
	private String cookiePassword;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getCookiePassword() {
		return cookiePassword;
	}

	public void setCookiePassword(String cookiePassword) {
		this.cookiePassword = cookiePassword;
	}

	@Override
	public String toString() {
		return "UserValue [userId=" + userId + ", userIp=" + userIp + ", cookiePassword=" + cookiePassword + "]";
	}

}
