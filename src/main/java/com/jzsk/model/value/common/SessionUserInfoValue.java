/**
 * 
 */
package com.jzsk.model.value.common;

/**
 * @author LiuYangTao
 *
 */
public class SessionUserInfoValue {

	/** 用户ID */
	private String userId;
	/** 用户账户 */
	private String userAccount;
	/** 用户名 */
	private String realName;
	/** COOKIE用密码 */
	private String cookiePassword;

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
	 * @return realName
	 */
	public String getRealName() {
		return realName;
	}

	/**
	 * @param realName
	 *            要设置的 realName
	 */
	public void setRealName(String realName) {
		this.realName = realName;
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

}
