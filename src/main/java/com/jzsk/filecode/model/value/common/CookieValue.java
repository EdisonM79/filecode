/**
 * CookieValue.java
 * 
 * zhnf 2016
 * 
 * LiuYangtao
 */
package com.jzsk.filecode.model.value.common;

/**
 * @author LiuYangtao
 *
 */
public class CookieValue {

	/** Cookie名 */
	private static final String COOKIE_NAME = "jzsk.cookie";
	/** 用户ID */
	private String userId;
	/** 密码 */
	private String password;

	/**
	 * @return the cookieName
	 */
	public static String getCookieName() {
		return COOKIE_NAME;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CookieValue [userId=" + userId + ", password=" + password + "]";
	}

}
