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
import com.jzsk.filecode.model.entity.TrTwo;
import com.jzsk.filecode.model.form.TwoForm;
import com.jzsk.filecode.model.value.TwoValue;
import com.jzsk.filecode.model.value.UserInfo;
import com.jzsk.filecode.service.TwoService;
import com.jzsk.filecode.service.UserService;
import com.jzsk.filecode.utility.DateUtility;
import com.jzsk.filecode.utility.ResponseUtility;
import com.jzsk.filecode.utility.StringUtility;
import com.jzsk.filecode.utility.TwoIdUtility;

@Controller
public class TwoController extends CommonController{
	

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
    		twoValue.setTwoCode(trTwo.getTwoCode());
    		twoValue.setUserId(trTwo.getUserId());
    		twoValue.setVersion(trTwo.getVersion());
    		twoValue.setYear(trTwo.getYear());
    		twoValue.setUsername(userService.selectByPrimaryKey(trTwo.getUserId()).getUserName());
    		twoValue.setTwoNum(String.valueOf(trTwo.getTwoNum()));
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
	 * 保存二级文件编号
	 * @param response
	 * @param request
	 * @param modelMap
	 * @param UserInfoForm
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = UrlConstants.ADMIN_TWO_SAVE, method = RequestMethod.POST)
	public String saveTwo(HttpServletResponse response, HttpServletRequest request,ModelMap  modelMap, TwoForm twoForm) throws Exception {
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
		//年份，部门和时间可以确定文件编号的唯一性
		//trTwo.setTwoId(TwoIdUtility.generateTwoId());
		//trTwo.setCreateTime(DateUtility.getCurrentTimestamp());
		trTwo.setDepartment(twoForm.getDepartment());
		trTwo.setFileName(twoForm.getFileName());
		//trTwo.setUserId(twoForm.getCreateUser());
		//trTwo.setVersion(twoForm.getVersion());
		trTwo.setYear(twoForm.getYear());
		
		List<TrTwo> trTwoBySelectList = twoService.selectAllByFilenameAndDepartmentAndYear(trTwo);
		TrTwo trTwoBySelect;
		String createUserId = "";
		String twoCode = "";
		int resultTotal = 0;
		if (StringUtility.isEmptyAfterTrim(twoForm.getCreateUser())) {
			HttpSession session = request.getSession();
			UserInfo currentUser = (UserInfo)session.getAttribute("currentUser");
			createUserId = currentUser.getUserId();
		} else {
			createUserId = twoForm.getCreateUser();
		}
		if (trTwoBySelectList.isEmpty()) {
			//用文件名、部门和年份查询没有结果，表明此文件编号为新增
			trTwo.setTwoNum(twoService.selectMaxByYearAndDepartment(trTwo) + 1);
			trTwo.setVersion(twoForm.getVersion());
			trTwo.setCreateTime(DateUtility.getCurrentTimestamp());
			trTwo.setTwoId(TwoIdUtility.generateTwoId());
			String currentNum = String.valueOf(twoService.selectMaxByYearAndDepartment(trTwo) + 1);
			if (currentNum.length() != 3) {
				currentNum = "0" + currentNum;
			}
			if (currentNum.length() != 3) {
				currentNum = "0" + currentNum;
			}
			twoCode = "JZ.2." + twoForm.getDepartment() + "-" + currentNum + twoForm.getVersion() + "-" + twoForm.getYear();
			trTwo.setTwoCode(twoCode);
			trTwo.setUserId(createUserId);			
			resultTotal = twoService.insert(trTwo);
		} else {
			//查询有结果，表明此文件编号为版本号的更新
			for (TrTwo trTwo2 : trTwoBySelectList) {
				if (trTwo2.getVersion() == twoForm.getVersion()) {
					resultTotal = -1; //直接报操作失败
				} 
			}
			//版本号为新版
			if (resultTotal != -1) {
				trTwoBySelect = trTwoBySelectList.get(0);
				trTwoBySelect.setTwoId(TwoIdUtility.generateTwoId());
				trTwoBySelect.setCreateTime(DateUtility.getCurrentTimestamp());
				trTwoBySelect.setUserId(createUserId);
				String currentNum = String.valueOf(trTwoBySelect.getTwoNum());
				if (currentNum.length() != 3) {
					currentNum = "0" + currentNum;
				}
				if (currentNum.length() != 3) {
					currentNum = "0" + currentNum;
				}
				twoCode = "JZ.2." + twoForm.getDepartment() + "-" + currentNum + twoForm.getVersion() + "-" + twoForm.getYear();
				trTwoBySelect.setTwoCode(twoCode);
				trTwoBySelect.setVersion(twoForm.getVersion());
				resultTotal = twoService.insert(trTwoBySelect);
			}
		}		
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
