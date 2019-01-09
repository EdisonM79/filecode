package com.jzsk.filecode.controller.common;


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
import com.jzsk.filecode.constants.Constants;
import com.jzsk.filecode.constants.MsgConstants;
import com.jzsk.filecode.model.value.common.CookieValue;
import com.jzsk.filecode.model.value.common.UserLoginValue;
import com.jzsk.filecode.model.value.common.UserValue;
import com.jzsk.filecode.utility.CookieUtility;
import com.jzsk.filecode.utility.StringUtility;

public class CommonController {
	/** ��Ϣ����.���� */
	protected static final String MESSAGE_DIV_ERROR = "01";
	/** ��Ϣ����.��Ϣ */
	protected static final String MESSAGE_DIV_INFO = "02";
	/** cookieUtility */
	private CookieUtility cookieUtility = new CookieUtility();

	/**
	 * �Զ���¼
	 * 
	 * @param request
	 * @param response
	 * @param modelMap
	 */
	protected void autoLogin(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
		
		UserValue userValue = null;
		
		try {
			// ȡ��SESSION�û�Value
			UserValue sessionUserValue = getSessionUser(request);
			// ȡ��cookie
			CookieValue cookieValue = getCookie(request);
			if (cookieValue != null) {
				if (sessionUserValue == null || !cookieValue.getUserId().equals(sessionUserValue.getUserId()) || !cookieValue.getPassword().equals(sessionUserValue.getCookiePassword())) {
					// �Զ���¼
					UserLoginValue userLoginValue = new UserLoginValue();
					userLoginValue.setUserId(cookieValue.getUserId());
					userLoginValue.setCookiePassword(cookieValue.getPassword());
					//userValue = webLoginService.login(userLoginValue);
					
					if (!StringUtility.isEmptyAfterTrim(userValue.getUserId())) {
						
						try {
							// ����cookie
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
							// ��¼��Ϣ����SESSION
							addSessionUser(userValue, request);
						} catch (AuthenticationException e) {
							// ʲô������
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
	 * ����json��response
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
	 * ����json���ݣ���¼ʧЧ��
	 * 
	 * @param jsonResult
	 * @param response
	 * @throws IOException
	 */
	protected void postJsonResultForLoginInvalid(HttpServletResponse response) throws IOException {
		postJsonResult(null, "login", true, "", response);
	}

	/**
	 * ����json���ݣ�����
	 * 
	 * @param jsonResult
	 * @param response
	 * @throws IOException
	 */
	protected void postJsonResultForError(String message, HttpServletResponse response) throws IOException {
		postJsonResultForErrorField(null, message, response);
	}

	/**
	 * ����json���ݣ������ֶΣ�
	 * 
	 * @param jsonResult
	 * @param response
	 * @throws IOException
	 */
	protected void postJsonResultForErrorField(String field, String message, HttpServletResponse response) throws IOException {
		postJsonResult(null, field, true, message, response);
	}

	/**
	 * ����json���ݣ��ɹ���
	 * 
	 * @param jsonResult
	 * @param response
	 * @throws IOException
	 */
	protected void postJsonResultForSuccess(Map<String, Object> data, String message, HttpServletResponse response) throws IOException {
		postJsonResult(data, null, false, message, response);
	}

	/**
	 * ����json���ݣ��ɹ���
	 * 
	 * @param jsonResult
	 * @param response
	 * @throws IOException
	 */
	protected void postJsonResultForeignSuccess(Map<String, Object> data, String message, HttpServletResponse response) throws IOException {
		postJsonResultForeign(data, "00", message, response);
	}

	/**
	 * ����json���ݣ�ʧ�ܣ�
	 * 
	 * @param jsonResult
	 * @param response
	 * @throws IOException
	 */
	protected void postJsonResultForeignError(String message, HttpServletResponse response) throws IOException {
		postJsonResultForeign(new HashMap<>(), "01", message, response);
	}

	/**
	 * ���ض���json����
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
	 * ����json����
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
	 * ����json����
	 * 
	 * @param jsonResult
	 * @param response
	 * @throws IOException
	 */
	protected void postJsonResult(String jsonResult, HttpServletResponse response) throws IOException {
		response.getWriter().write(jsonResult);
	}

	/**
	 * ȡ��cookie
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
	 * ���cookie
	 * 
	 * @param response
	 */
	protected void removeCookie(HttpServletResponse response) {
		Cookie cookie = cookieUtility.removeCookie();
		response.addCookie(cookie);
	}

	/**
	 * ����û���Ϣ��session
	 * 
	 * @param userInfoValue
	 * @param request
	 */
	protected void addSessionUser(UserValue userInfoValue, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute(Constants.SESSION_USER_VALUE, userInfoValue);
	}

	/**
	 * ��session��ɾ���û���Ϣ
	 * 
	 */
	protected void removeSessionUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute(Constants.SESSION_USER_VALUE, null);
	}

	/**
	 * ȡ��session�û���Ϣ
	 * 
	 * @param request
	 */
	protected UserValue getSessionUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		// ȡ��SESSION�û�Value
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

