package com.jzsk.filecode.controller;

import java.util.ArrayList;
import java.util.List;
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

import com.alibaba.fastjson.JSONObject;
import com.jzsk.filecode.constants.Constants;
import com.jzsk.filecode.constants.UrlConstants;
import com.jzsk.filecode.controller.common.CommonController;
import com.jzsk.filecode.model.entity.TrProject;
import com.jzsk.filecode.model.entity.TrTwo;
import com.jzsk.filecode.model.form.ProjectForm;
import com.jzsk.filecode.model.form.TwoForm;
import com.jzsk.filecode.model.value.ProjectValue;
import com.jzsk.filecode.model.value.TwoValue;
import com.jzsk.filecode.model.value.UserInfo;
import com.jzsk.filecode.service.ProjectService;
import com.jzsk.filecode.service.TwoService;
import com.jzsk.filecode.service.UserService;
import com.jzsk.filecode.utility.DateUtility;
import com.jzsk.filecode.utility.ProjectIdUtility;
import com.jzsk.filecode.utility.ResponseUtility;
import com.jzsk.filecode.utility.StringUtility;
import com.jzsk.filecode.utility.TwoIdUtility;

@Controller
public class TwoController extends CommonController{
	
	@Autowired
	private ProjectService projectService;
	@Autowired
	private UserService userService;
	@Autowired
	private TwoService twoService;
	
	
	/**
     * @param response
     * @param request
     * @param modelMap
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = UrlConstants.ADMIN_TWO_LIST)
    public String twoList(HttpServletResponse response, HttpServletRequest request, ModelMap modelMap) throws Exception {
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
    	List<TrTwo> trtwos = twoService.selectAllTwo();
    	List<TwoValue> twoValues = new ArrayList<>();
    	for (TrTwo trTwo : trtwos) {
    		
    		TwoValue twoValue = new TwoValue();
    		twoValue.setDepartment(trTwo.getDepartment());
    		twoValue.setCreateTime(DateUtility.toStringDate("yyyy-MM-dd HH:mm:ss", trTwo.getCreateTime()));
    		twoValue.setFileName(trTwo.getFileName());
    		twoValue.setTwoId(trTwo.getTwoId());
    		twoValue.setTwoName(trTwo.getTwoName());
    		twoValue.setUserId(trTwo.getUserId());
    		twoValue.setVersion(trTwo.getVersion());
    		twoValue.setYear(trTwo.getYear());
    		twoValue.setUsername(userService.selectByPrimaryKey(trTwo.getUserId()).getUserName());
    		twoValues.add(twoValue);
		} 	
    	int count = twoService.countAll();
    	modelMap.put("count", count);
    	modelMap.put("twoValues", twoValues);       
    	return "twolist";
    	
    }
    
    /**
     * 跳转到新增二级编号界面
     * @param response
     * @param request
     * @param modelMap
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = UrlConstants.ADMIN_TWO_ADD)
    public String addFilecode(HttpServletResponse response, HttpServletRequest request, ModelMap modelMap) throws Exception {
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
        return "addtwo";
    }
    
	/**
	 * 
	 * @param response
	 * @param request
	 * @param modelMap
	 * @param UserInfoForm
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = UrlConstants.ADMIN_TWO_SAVE, method = RequestMethod.POST)
	public String saveUser(HttpServletResponse response, HttpServletRequest request,ModelMap  modelMap, TwoForm twoForm) throws Exception {
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
		TrTwo trTwo = new TrTwo();
		
		trTwo.setTwoId(TwoIdUtility.generateTwoId());
		trTwo.setCreateTime(DateUtility.getCurrentTimestamp());
		trTwo.setDepartment(twoForm.getDepartment());
		trTwo.setFileName(twoForm.getFileName());
		//trTwo.setUserId(twoForm.getCreateUser());
		trTwo.setVersion(twoForm.getVersion());
		trTwo.setYear(twoForm.getYear());
		String twoName = "JZ.2." + twoForm.getDepartment() + "-" + twoForm.getFileName() + twoForm.getVersion() + "-" + twoForm.getYear();
		trTwo.setTwoName(twoName);
		String createUserId = "";
		if (StringUtility.isEmptyAfterTrim(twoForm.getCreateUser())) {
			HttpSession session = request.getSession();
			UserInfo currentUser = (UserInfo)session.getAttribute("currentUser");
			createUserId = currentUser.getUserId();
		} else {
			createUserId = twoForm.getCreateUser();
		}
		trTwo.setUserId(createUserId);
		
		int resultTotal = twoService.insert(trTwo);
        //检查ip地址
		JSONObject result = new JSONObject();
		if (resultTotal > 0)														// 操作成功
        {
            result.put("success", true);
        } else {																	// 操作失败
            result.put("success", false);
            result.put("message", "操作失败！");
        }
        ResponseUtility.write(response, result);
        return null;
	}
}
