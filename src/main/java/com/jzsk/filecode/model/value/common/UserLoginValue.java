/**
 * 
 */
package com.jzsk.filecode.model.value.common;

/**
 * @author LiuYangTao
 *
 */
public class UserLoginValue {

	/** 用户ID */
	private String userId;
	/** 用户账户 */
	private String userAccount;
	/** 密码 */
	private String password;
	/** cookie密码 */
	private String cookiePassword;
	/** 保存cookie */
	private boolean saveCookie;

	/**
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            要设置的 userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return userAccount
	 */
	public String getUserAccount() {
		return userAccount;
	}

	/**
	 * @param userAccount
	 *            要设置的 userAccount
	 */
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            要设置的 password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return cookiePassword
	 */
	public String getCookiePassword() {
		return cookiePassword;
	}

	/**
	 * @param cookiePassword
	 *            要设置的 cookiePassword
	 */
	public void setCookiePassword(String cookiePassword) {
		this.cookiePassword = cookiePassword;
	}

	/**
	 * @return saveCookie
	 */
	public boolean isSaveCookie() {
		return saveCookie;
	}

	/**
	 * @param saveCookie
	 *            要设置的 saveCookie
	 */
	public void setSaveCookie(boolean saveCookie) {
		this.saveCookie = saveCookie;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AppUserLoginValue [userId=" + userId + ", userAccount=" + userAccount + ", password=" + password + ", cookiePassword=" + cookiePassword + ", saveCookie=" + saveCookie + "]";
	}

}
