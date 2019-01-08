package com.jzsk.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.jzsk.constants.MsgConstants;
import com.jzsk.constants.UrlConstants;
import com.jzsk.controller.common.CommonController;
import com.jzsk.model.form.UserLoginForm;
import com.jzsk.model.value.UserInfo;
import com.jzsk.service.UserService;
import com.jzsk.utility.PasswordUtility;
import com.jzsk.utility.RandomValidateCodeUtility;
import com.jzsk.utility.StringUtility;

@Controller
public class UserController extends CommonController{

	@Autowired
	private UserService  userService;
	public static final String RANDOMCODEKEY = "RANDOMVALIDATECODEKEY";
	
	/**
	 * 生成验证码
	 */
	@RequestMapping(value = UrlConstants.GETVERIFY)
	public void getVerify(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
			response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expire", 0);
			RandomValidateCodeUtility randomValidateCode = new RandomValidateCodeUtility();
			randomValidateCode.getRandcode(request, response);// 输出验证码图片方法
		} catch (Exception e) {
			// logger.error("获取验证码失败>>>> ", e);
			System.out.println("----------------------获取验证码失败>>>>>>>>" + e);
		}
	}
	/**
	 * 跳转到管理登陆页面
	 * @param response
	 * @param request
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = UrlConstants.LOGIN)
	public String login(HttpServletResponse response, HttpServletRequest request, ModelMap modelMap) throws Exception {
		// map
		Map<String, Object> attrMap = (Map<String, Object>) RequestContextUtils.getInputFlashMap(request);
		try {
			Object actionErrorObj = attrMap.get("actionError");
			if (actionErrorObj != null) {
				String[] actionError = (String[]) actionErrorObj;
				if (actionError.length == 3) {
					addActionError(actionError[0], actionError[1], actionError[2], modelMap);
				}
			}
		} catch (Exception e) {
			// 什么都不做
		}		
		
		/*AdminValue adminValue = new AdminValue();
		adminValue.setUsername("admin");
		adminValue.setPassword("cdjzsk@123");
		modelMap.put("adminValue", adminValue);*/
		
		return "login";
	}
	
	/**
	 * <p>Title: loginLogin</p>  
	 * <p>Description: </p>  
	 * @param response
	 * @param request
	 * @param modelMap
	 * @param userLoginForm
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = UrlConstants.USER_LOGIN, method = RequestMethod.POST)
	public String loginLogin(HttpServletResponse response, HttpServletRequest request,ModelMap  modelMap, UserLoginForm userLoginForm) throws Exception {
		// 设置response
		setResponseForJson(request, response);
		// map
		Map<String, Object> attrMap = (Map<String, Object>) RequestContextUtils.getInputFlashMap(request);
		try {
			Object actionErrorObj = attrMap.get("actionError");
			if (actionErrorObj != null) {
				String[] actionError = (String[]) actionErrorObj;
				if (actionError.length == 3) {
					addActionError(actionError[0], actionError[1], actionError[2], modelMap);
				}
			}
		} catch (Exception e) {
			// 什么都不做
		}
		
		UserInfo userInfo = userLoginForm.getUserInfo();
		if (userInfo == null) {
			return "redirect:" + UrlConstants.LOGIN;
		}
		//用户名为空
		if (StringUtility.isEmptyAfterTrim(userInfo.getUserName())) {
			addActionError("adminValue.username", MsgConstants.ERROR_01001_MSG, MESSAGE_DIV_ERROR, modelMap);
			modelMap.put("userInfo", userInfo);
			return "login";
		}
		//密码
		if (StringUtility.isEmptyAfterTrim(userInfo.getPassword())) {
			
			addActionError("adminValue.password", MsgConstants.ERROR_01002_MSG, MESSAGE_DIV_ERROR, modelMap);
			modelMap.put("userInfo", userInfo);
			return "login";
		}
		//验证码
		if (StringUtility.isEmptyAfterTrim(userLoginForm.getCode())) {
			
			addActionError("code", MsgConstants.ERROR_01003_MSG, MESSAGE_DIV_ERROR, modelMap);
			modelMap.put("userInfo", userInfo);
			return "login";
		}
		//填写的验证码		
		String code = userLoginForm.getCode();
		//session里面保存的验证码
		HttpSession session = request.getSession();
		String sessionCode = (String)session.getAttribute(RANDOMCODEKEY);
		if (!(sessionCode.toLowerCase().equals(code.toLowerCase()))) {
			
			addActionError("code", MsgConstants.ERROR_01006_MSG, MESSAGE_DIV_ERROR, modelMap);
			modelMap.put("userInfo", userInfo);
			return "login";
		}
		//数据库取数据
		UserInfo user = userService.selectByLoginName(userInfo.getUserName());
		if (user == null) {
			addActionError("adminValue.username", MsgConstants.ERROR_01005_MSG, MESSAGE_DIV_ERROR, modelMap);
			modelMap.put("userInfo", userInfo);
			return "login";
		}
		//检查密码
		if (!PasswordUtility.checkPassword(userInfo.getPassword(), user.getPassword())) {
			addActionError("adminValue.password", MsgConstants.ERROR_01004_MSG, MESSAGE_DIV_ERROR, modelMap);
			modelMap.put("userInfo", userInfo);
			return "login";
		}

        //检查ip地址
		return "index";
	}
	
	/**
     * 欢迎页面展示
     * @param response
     * @param request
     * @param modelMap
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = UrlConstants.USER_WELCOME)
    public String welcome(HttpServletResponse response, HttpServletRequest request, ModelMap modelMap) throws Exception {
        // map
        Map<String, Object> attrMap = (Map<String, Object>) RequestContextUtils.getInputFlashMap(request);
        try {
            Object actionErrorObj = attrMap.get("actionError");
            if (actionErrorObj != null) {
                String[] actionError = (String[]) actionErrorObj;
                if (actionError.length == 3) {
                    addActionError(actionError[0], actionError[1], actionError[2], modelMap);
                }
            }
        } catch (Exception e) {
            // 什么都不做
        }                      
        return "welcome";
    }
}
