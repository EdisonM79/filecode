/**
 * CookieUtility.java
 * 
 * zhnf 2016
 * 
 * LiuYangtao
 */
package com.jzsk.filecode.utility;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.jzsk.filecode.model.value.common.CookieValue;

/**
 * @author LiuYangtao
 *
 */
public class CookieUtility {

	/**
	 * 创建Cookie（添加或者删除）
	 * 
	 * @param cookieValue {@link CookieValue}
	 * @param saveCookie boolean
	 * 
	 * @return {@link Cookie}
	 */
	public Cookie addCookie(CookieValue cookieValue, boolean saveCookie) {
		Cookie cookie = new Cookie(CookieValue.getCookieName(), cookieValue.getUserId() + "|"
				+ cookieValue.getPassword());
		cookie.setPath("/");
		if (saveCookie) {
			cookie.setMaxAge(60 * 60 * 24 * 14);// cookie保存两周
		} else {
			cookie.setMaxAge(-1);// 浏览器关闭
		}
		return cookie;
	}

	/**
	 * 取得Cookie
	 * 
	 * @param request {@link HttpServletRequest}
	 * @return {@link CookieValue}
	 */
	public CookieValue getCookie(HttpServletRequest request) {
		CookieValue cookieValue = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (CookieValue.getCookieName().equals(cookie.getName())) {
					String value = cookie.getValue();
					if (!StringUtility.isEmptyAfterTrim(value)) {
						String[] split = value.split("\\|");
						String userId = split[0];
						String password = split[1];
						if (!StringUtility.isEmptyAfterTrim(userId) && !StringUtility.isEmptyAfterTrim(password)) {
							cookieValue = new CookieValue();
							cookieValue.setUserId(userId);
							cookieValue.setPassword(password);
						}
					}
					break;
				}
			}
		}
		return cookieValue;
	}

	/**
	 * 删除Cookie
	 * 
	 * @return {@link Cookie}
	 */
	public Cookie removeCookie() {
		Cookie cookie = new Cookie(CookieValue.getCookieName(), null);
		cookie.setMaxAge(0); // 删除该Cookie
		cookie.setPath("/");
		return cookie;
	}
}
