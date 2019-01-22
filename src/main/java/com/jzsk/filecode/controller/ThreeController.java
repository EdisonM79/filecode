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
import com.jzsk.filecode.model.entity.TrThree;
import com.jzsk.filecode.model.entity.TrTwo;
import com.jzsk.filecode.model.form.ThreeForm;
import com.jzsk.filecode.model.form.TwoForm;
import com.jzsk.filecode.model.value.ThreeValue;
import com.jzsk.filecode.model.value.TwoValue;
import com.jzsk.filecode.model.value.UserInfo;
import com.jzsk.filecode.service.ThreeService;
import com.jzsk.filecode.service.UserService;
import com.jzsk.filecode.utility.DateUtility;
import com.jzsk.filecode.utility.ResponseUtility;
import com.jzsk.filecode.utility.StringUtility;
import com.jzsk.filecode.utility.TwoIdUtility;

@Controller
public class ThreeController extends CommonController{
	
	@Autowired
	private UserService userService;
	@Autowired
	private ThreeService threeService;
	
	
	/**
     * @param response
     * @param request
     * @param modelMap
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = UrlConstants.ADMIN_THREE_LIST)
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
    	List<TrThree> trthrees = threeService.selectAllThree();
    	List<ThreeValue> threeValues = new ArrayList<>();
    	for (TrThree trThree : trthrees) {
    		
    		ThreeValue threeValue = new ThreeValue();
    		threeValue.setCreateTime(DateUtility.toStringDate("yyyy-MM-dd HH:mm:ss", trThree.getCreateTime()));
    		threeValue.setDepartment(trThree.getDepartment());
    		threeValue.setThreeCode(trThree.getThreeCode());
    		threeValue.setThreeId(trThree.getThreeId());
    		threeValue.setThreeName(trThree.getThreeName());
    		threeValue.setThreeNum(String.valueOf(trThree.getThreeNum()));
    		threeValue.setTwoName(trThree.getTwoName());
    		threeValue.setUserName(userService.selectByPrimaryKey(trThree.getUserId()).getUserName());
    		threeValue.setThreeVersion(trThree.getThreeVersion());    		
    		threeValues.add(threeValue);
		} 	
    	int count = threeService.countAll();
    	modelMap.put("count", count);
    	modelMap.put("threeValues", threeValues);       
    	return "threelist";
    	
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
    @RequestMapping(value = UrlConstants.ADMIN_THREE_ADD)
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
        return "addthree";
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
	@RequestMapping(value = UrlConstants.ADMIN_THREE_SAVE, method = RequestMethod.POST)
	public String saveUser(HttpServletResponse response, HttpServletRequest request,ModelMap  modelMap, ThreeForm threeForm) throws Exception {
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
		TrThree trThree = new TrThree();
		
		trThree.setCreateTime(DateUtility.getCurrentTimestamp());
		trThree.setDepartment(threeForm.getDepartment());
		trThree.setThreeId(TwoIdUtility.generateTwoId());
		trThree.setThreeName(threeForm.getThreeName());
		trThree.setThreeVersion(threeForm.getThreeVersion());
		trThree.setTwoName(threeForm.getTwoName());
		int threeNum = threeService.selectMaxByTwoName(threeForm.getTwoName()) + 1;
		trThree.setThreeNum(threeNum);
		
		String numString =""; 
		if (threeNum < 10 ) {
			numString = "00"+ String.valueOf(threeNum);
		} else if (threeNum > 10 && threeNum<100 ) {
			numString = "0"+ String.valueOf(threeNum);
		}else {
			numString = String.valueOf(threeNum);
		}
		trThree.setThreeCode(numString);
		
		String threeCode = "JZ.3." + threeForm.getDepartment() + "." + numString 
				+ threeForm.getThreeVersion()  + "-" + threeForm.getTwoName() + "-" + threeForm.getYear();
		trThree.setThreeCode(threeCode);
		
		String createUserId = "";
		if (StringUtility.isEmptyAfterTrim(threeForm.getCreateUser())) {
			HttpSession session = request.getSession();
			UserInfo currentUser = (UserInfo)session.getAttribute("currentUser");
			createUserId = currentUser.getUserId();
		} else {
			createUserId = threeForm.getCreateUser();
		}
		trThree.setUserId(createUserId);
		
		int resultTotal = threeService.insert(trThree);
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