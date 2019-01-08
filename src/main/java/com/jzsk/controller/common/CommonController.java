package com.jzsk.controller.common;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.apache.shiro.authc.AuthenticationException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jzsk.constants.Constants;
import com.jzsk.constants.MsgConstants;
import com.jzsk.model.value.common.CookieValue;
import com.jzsk.model.value.common.UserLoginValue;
import com.jzsk.model.value.common.UserValue;
import com.jzsk.utility.CookieUtility;
import com.jzsk.utility.StringUtility;

public class CommonController {
	/** 消息区分.错误 */
	protected static final String MESSAGE_DIV_ERROR = "01";
	/** 消息区分.信息 */
	protected static final String MESSAGE_DIV_INFO = "02";
	/** cookieUtility */
	private CookieUtility cookieUtility = new CookieUtility();

	/**
	 * 自动登录
	 * 
	 * @param request
	 * @param response
	 * @param modelMap
	 */
	protected void autoLogin(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
		
		UserValue userValue = null;
		
		try {
			// 取得SESSION用户Value
			UserValue sessionUserValue = getSessionUser(request);
			// 取得cookie
			CookieValue cookieValue = getCookie(request);
			if (cookieValue != null) {
				if (sessionUserValue == null || !cookieValue.getUserId().equals(sessionUserValue.getUserId()) || !cookieValue.getPassword().equals(sessionUserValue.getCookiePassword())) {
					// 自动登录
					UserLoginValue userLoginValue = new UserLoginValue();
					userLoginValue.setUserId(cookieValue.getUserId());
					userLoginValue.setCookiePassword(cookieValue.getPassword());
					//userValue = webLoginService.login(userLoginValue);
					
					if (!StringUtility.isEmptyAfterTrim(userValue.getUserId())) {
						
						try {
							// 保存cookie
							cookieValue = new CookieValue();
							cookieValue.setUserId(userValue.getUserId());
							cookieValue.setPassword(userValue.getCookiePassword());
							CookieUtility cookieUtility = new CookieUtility();
							Cookie cookie = cookieUtility.addCookie(cookieValue, false);
							response.addCookie(cookie);
							Cookie cookieSessionId = new Cookie("JSESSIONID", request.getSession().getId());
							cookieSessionId.setPath("/");
							cookieSessionId.setMaxAge(-1);
							response.addCookie(cookieSessionId);
//							userValue.setPassword(null);
							// 登录信息放入SESSION
							addSessionUser(userValue, request);
						} catch (AuthenticationException e) {
							// 什么都不做
						}
					}
				} else {
					userValue = sessionUserValue;
				}
			} else {
				if (sessionUserValue != null) {
					userValue = sessionUserValue;
				} else {
					userValue = new UserValue();
				}
			}
		} catch (Exception e) {
			userValue = new UserValue();
		}
		modelMap.put(Constants.SESSION_USER_VALUE, userValue);
	}

	/**
	 * 设置json的response
	 * 
	 * @param request
	 * @param response
	 */
	protected void setResponseForJson(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setHeader("JSESSIONID", request.getSession().getId());
	}

	/**
	 * 返回json数据（登录失效）
	 * 
	 * @param jsonResult
	 * @param response
	 * @throws IOException
	 */
	protected void postJsonResultForLoginInvalid(HttpServletResponse response) throws IOException {
		postJsonResult(null, "login", true, "", response);
	}

	/**
	 * 返回json数据（错误）
	 * 
	 * @param jsonResult
	 * @param response
	 * @throws IOException
	 */
	protected void postJsonResultForError(String message, HttpServletResponse response) throws IOException {
		postJsonResultForErrorField(null, message, response);
	}

	/**
	 * 返回json数据（错误字段）
	 * 
	 * @param jsonResult
	 * @param response
	 * @throws IOException
	 */
	protected void postJsonResultForErrorField(String field, String message, HttpServletResponse response) throws IOException {
		postJsonResult(null, field, true, message, response);
	}

	/**
	 * 返回json数据（成功）
	 * 
	 * @param jsonResult
	 * @param response
	 * @throws IOException
	 */
	protected void postJsonResultForSuccess(Map<String, Object> data, String message, HttpServletResponse response) throws IOException {
		postJsonResult(data, null, false, message, response);
	}

	/**
	 * 返回json数据（成功）
	 * 
	 * @param jsonResult
	 * @param response
	 * @throws IOException
	 */
	protected void postJsonResultForeignSuccess(Map<String, Object> data, String message, HttpServletResponse response) throws IOException {
		postJsonResultForeign(data, "00", message, response);
	}

	/**
	 * 返回json数据（失败）
	 * 
	 * @param jsonResult
	 * @param response
	 * @throws IOException
	 */
	protected void postJsonResultForeignError(String message, HttpServletResponse response) throws IOException {
		postJsonResultForeign(new HashMap<>(), "01", message, response);
	}

	/**
	 * 返回对外json数据
	 * 
	 * @param jsonResult
	 * @param response
	 * @throws IOException
	 */
	private void postJsonResultForeign(Map<String, Object> data, String code, String message, HttpServletResponse response) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> dataMap = new HashMap<>();
		if (message == null) {
			message = "";
		}
		dataMap.put(MsgConstants.DATA, data);
		dataMap.put(MsgConstants.CODE, code);
		dataMap.put(MsgConstants.ERROR_MESSAGE, message);
		String jsonResult = mapper.writeValueAsString(dataMap);
		postJsonResult(jsonResult, response);
	}

	/**
	 * 返回json数据
	 * 
	 * @param jsonResult
	 * @param response
	 * @throws IOException
	 */
	private void postJsonResult(Map<String, Object> data, String filed, boolean error, String message, HttpServletResponse response) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> dataMap = new HashMap<>();
		if (filed == null) {
			filed = "";
		}
		if (message == null) {
			message = "";
		}
		dataMap.put(MsgConstants.DATA, data);
		dataMap.put(MsgConstants.FIELD, filed);
		dataMap.put(MsgConstants.ERROR, error);
		dataMap.put(MsgConstants.MESSAGE, message);
		String jsonResult = mapper.writeValueAsString(dataMap);
		postJsonResult(jsonResult, response);
	}

	/**
	 * 返回json数据
	 * 
	 * @param jsonResult
	 * @param response
	 * @throws IOException
	 */
	protected void postJsonResult(String jsonResult, HttpServletResponse response) throws IOException {
		response.getWriter().write(jsonResult);
	}

	/**
	 * 取得cookie
	 * 
	 * @param request
	 * @return
	 */
	protected CookieValue getCookie(HttpServletRequest request) {
		return cookieUtility.getCookie(request);
	}

	/**
	 * 
	 * @param userCookieValue
	 * @param saveCookie
	 * @param response
	 */
	protected void addCookie(CookieValue cookieValue, boolean saveCookie, HttpServletResponse response) {
		Cookie cookie = cookieUtility.addCookie(cookieValue, saveCookie);
		response.addCookie(cookie);
	}

	/**
	 * 清除cookie
	 * 
	 * @param response
	 */
	protected void removeCookie(HttpServletResponse response) {
		Cookie cookie = cookieUtility.removeCookie();
		response.addCookie(cookie);
	}

	/**
	 * 添加用户信息进session
	 * 
	 * @param userInfoValue
	 * @param request
	 */
	protected void addSessionUser(UserValue userInfoValue, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute(Constants.SESSION_USER_VALUE, userInfoValue);
	}

	/**
	 * 从session中删除用户信息
	 * 
	 */
	protected void removeSessionUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute(Constants.SESSION_USER_VALUE, null);
	}

	/**
	 * 取得session用户信息
	 * 
	 * @param request
	 */
	protected UserValue getSessionUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		// 取得SESSION用户Value
		UserValue userValue = (UserValue) session.getAttribute(Constants.SESSION_USER_VALUE);
		if (userValue == null) {
			userValue = new UserValue();
		}
		return userValue;
	}

	/**
	 * 
	 * @param fieldName
	 * @param anErrorMessage
	 * @param messageDiv {MESSAGE_DIV_ERROR, MESSAGE_DIV_INFO}
	 * @param modelMap
	 */
	protected void addActionError(String fieldName, String anErrorMessage, String messageDiv, ModelMap modelMap) {
		String errorMessage = "{";
		errorMessage += "\"fieldName\":\"" + fieldName + "\"";
		errorMessage += ",";
		errorMessage += "\"message\":\"" + anErrorMessage + "\"";
		errorMessage += ",";
		errorMessage += "\"messageDiv\":\"" + messageDiv + "\"";
		errorMessage += "}";
		modelMap.put("actionError", errorMessage);
	}


}

