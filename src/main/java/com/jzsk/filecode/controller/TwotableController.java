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
import com.jzsk.filecode.constants.UrlConstants;
import com.jzsk.filecode.controller.common.CommonController;
import com.jzsk.filecode.model.entity.TrTwotable;
import com.jzsk.filecode.model.form.TwotableForm;
import com.jzsk.filecode.model.value.TwotableValue;
import com.jzsk.filecode.model.value.UserInfo;
import com.jzsk.filecode.service.TwotableService;
import com.jzsk.filecode.service.UserService;
import com.jzsk.filecode.utility.DateUtility;
import com.jzsk.filecode.utility.ResponseUtility;
import com.jzsk.filecode.utility.StringUtility;
import com.jzsk.filecode.utility.TwoIdUtility;

@Controller
public class TwotableController extends CommonController{
	
	@Autowired
	private UserService userService;
	@Autowired
	private TwotableService twotableService;
	
	
	/**
     * @param response
     * @param request
     * @param modelMap
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = UrlConstants.ADMIN_TWOTABLE_LIST)
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
    	List<TrTwotable> trtwotables = twotableService.selectAllTwotable();
    	List<TwotableValue> twotableValues = new ArrayList<>();
    	for (TrTwotable trTwotable : trtwotables) {
    		
    		TwotableValue twotableValue = new TwotableValue();
    		
    		twotableValue.setCreateTime(DateUtility.toStringDate("yyyy-MM-dd HH:mm:ss", trTwotable.getCreateTime()));
    		twotableValue.setDepartment(trTwotable.getDepartment());
    		twotableValue.setTableName(trTwotable.getTableName());
    		int num = trTwotable.getTableNum();
    		String numString =""; 
    		if (num < 10 ) {
    			numString = "00"+ String.valueOf(num);
			} else if (num > 10 && num<100 ) {
    			numString = "0"+ String.valueOf(num);
			}else {
				numString = String.valueOf(num);
			}
    		
    		twotableValue.setTableNum(numString);
    		twotableValue.setTableVersion(trTwotable.getTableVersion());
    		twotableValue.setTwoName(trTwotable.getTwoId());
    		twotableValue.setTwotableId(trTwotable.getTwotableId());
    		twotableValue.setUsername(userService.selectByPrimaryKey(trTwotable.getUserId()).getUserName());
    		twotableValue.setTableCode(trTwotable.getTableCode());
    		twotableValues.add(twotableValue);
		} 	
    	int count = twotableService.countAll();
    	modelMap.put("count", count);
    	modelMap.put("twotableValues", twotableValues);       
    	return "twotablelist";
    	
    }
    
    /**
     * 跳转到新增二级表单编号界面
     * @param response
     * @param request
     * @param modelMap
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = UrlConstants.ADMIN_TWOTABLE_ADD)
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
        return "addtwotable";
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
	@RequestMapping(value = UrlConstants.ADMIN_TWOTABLE_SAVE, method = RequestMethod.POST)
	public String saveUser(HttpServletResponse response, HttpServletRequest request,ModelMap  modelMap, TwotableForm twotableForm) throws Exception {
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
		TrTwotable trTwotable = new TrTwotable();
		
		trTwotable.setCreateTime(DateUtility.getCurrentTimestamp());
		trTwotable.setDepartment(twotableForm.getDepartment());
		trTwotable.setTableName(twotableForm.getTableName());
		trTwotable.setTableVersion(twotableForm.getTableVersion());
		trTwotable.setTwoId(twotableForm.getTwoName());
		trTwotable.setTwotableId(TwoIdUtility.generateTwoId());
		Integer tableNum = twotableService.selectMaxByTwoId(twotableForm.getTwoName());
		tableNum++;
		trTwotable.setTableNum(tableNum);
		
		int num = tableNum;
		String numString =""; 
		if (num < 10 ) {
			numString = "00"+ String.valueOf(num);
		} else if (num > 10 && num<100 ) {
			numString = "0"+ String.valueOf(num);
		}else {
			numString = String.valueOf(num);
		}
		
		String tableCode = "JZ.2."+twotableForm.getDepartment()+twotableForm.getTwoName()+"-"+numString+twotableForm.getTableVersion();
		trTwotable.setTableCode(tableCode);
		String createUserId = "";
		if (StringUtility.isEmptyAfterTrim(twotableForm.getCreateUser())) {
			HttpSession session = request.getSession();
			UserInfo currentUser = (UserInfo)session.getAttribute("currentUser");
			createUserId = currentUser.getUserId();
		} else {
			createUserId = twotableForm.getCreateUser();
		}
		trTwotable.setUserId(createUserId);
		
		int resultTotal = twotableService.insert(trTwotable);
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
