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
import com.jzsk.filecode.model.entity.TrThreetable;
import com.jzsk.filecode.model.entity.TrTwo;
import com.jzsk.filecode.model.entity.TrTwotable;
import com.jzsk.filecode.model.form.ThreetableForm;
import com.jzsk.filecode.model.form.TwotableForm;
import com.jzsk.filecode.model.value.ThreeValue;
import com.jzsk.filecode.model.value.ThreetableValue;
import com.jzsk.filecode.model.value.TwoValue;
import com.jzsk.filecode.model.value.TwotableValue;
import com.jzsk.filecode.model.value.UserInfo;
import com.jzsk.filecode.service.ThreeService;
import com.jzsk.filecode.service.ThreetableService;
import com.jzsk.filecode.service.TwotableService;
import com.jzsk.filecode.service.UserService;
import com.jzsk.filecode.utility.DateUtility;
import com.jzsk.filecode.utility.ResponseUtility;
import com.jzsk.filecode.utility.StringUtility;
import com.jzsk.filecode.utility.TwoIdUtility;

@Controller
public class ThreetableController extends CommonController{
	
	@Autowired
	private UserService userService;
	@Autowired
	private ThreetableService threetableService;
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
    @RequestMapping(value = UrlConstants.ADMIN_THREETABLE_LIST)
    public String threeeList(HttpServletResponse response, HttpServletRequest request, ModelMap modelMap) throws Exception {
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
    	List<TrThreetable> trThreetables = threetableService.selectAllThreetable();
    	List<ThreetableValue> threetableValues = new ArrayList<>();
    	for (TrThreetable trThreetable : trThreetables) {
    		
    		ThreetableValue threetableValue = new ThreetableValue();
    		
    		threetableValue.setCreateTime(DateUtility.toStringDate("yyyy-MM-dd HH:mm:ss", trThreetable.getCreateTime()));
    		threetableValue.setThreeName(threeService.selectByPrimaryKey(trThreetable.getThreeId()).getThreeName());
    		threetableValue.setThreetableCode(trThreetable.getThreetableCode());
    		threetableValue.setThreetableId(trThreetable.getThreetableId());
    		threetableValue.setThreetableName(trThreetable.getThreetableName());
    		threetableValue.setThreetableNum(trThreetable.getThreetableNum().toString());
    		threetableValue.setThreetableVersion(trThreetable.getThreetableVersion());
    		threetableValue.setUserName(userService.selectByPrimaryKey(trThreetable.getUserId()).getUserName());
    		threetableValue.setDepartment(trThreetable.getDepartment());
    		threetableValues.add(threetableValue);
		} 	
    	int count = threetableService.countAll();
    	modelMap.put("count", count);
    	modelMap.put("threetableValues", threetableValues);       
    	return "threetablelist";
    	
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
    @RequestMapping(value = UrlConstants.ADMIN_THREETABLE_ADD)
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
        List<TrThree> threeValues = threeService.selectLatestThreeList();
        List<ThreeValue> threes = new ArrayList<>();
        for (TrThree trThree : threeValues) {
        	ThreeValue threeValue = new ThreeValue();
        	threeValue.setThreeId(trThree.getThreeId());
        	threeValue.setThreeName(trThree.getThreeName());
        	threes.add(threeValue);
		}
        modelMap.put("threes", threes);
        return "addthreetable";
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
	@RequestMapping(value = UrlConstants.ADMIN_THREETABLE_SAVE, method = RequestMethod.POST)
	public String saveThree(HttpServletResponse response, HttpServletRequest request,ModelMap  modelMap, ThreetableForm threetableForm) throws Exception {
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
		TrThreetable trThreetable = new TrThreetable();
		
		trThreetable.setCreateTime(DateUtility.getCurrentTimestamp());
		trThreetable.setDepartment(threetableForm.getDepartment());
		trThreetable.setThreetableName(threetableForm.getTableName());
		trThreetable.setThreetableVersion(threetableForm.getTableVersion());
		trThreetable.setThreeId(threetableForm.getThreeId());
		//trTwotable.setTwotableId(TwoIdUtility.generateTwoId());
		
		List<TrThreetable> trThreetableBySelectList = threetableService.selectMaxByThreeIdAndDepartmentAndTableName(trThreetable);
		TrThreetable trThreetableBySelect = null;
		
		if (trThreetableBySelectList.isEmpty()) {
			//此处是没有找到以前的，所以为新增,先找到本部门，使用的最大文件序号
			Integer tableNum = threetableService.selectMaxByDepartment(trThreetable);
			tableNum++; //最大文件序号加1
			trThreetable.setThreetableNum(tableNum);
			String numString = String.valueOf(tableNum); 
			if (numString.length() != 2 ) {
				numString = "0"+ numString;
			} 
			String three_num = String.valueOf(threeService.selectByPrimaryKey(threetableForm.getThreeId()).getThreeNum());
			if (three_num.length() != 3) {
				three_num = "0" + three_num;
			}
			if (three_num.length() != 3) {
				three_num = "0" + three_num;
			}
			//拼凑表达编号
			String tableCode = "JZ.2."+threetableForm.getDepartment()+three_num+"-"+numString+threetableForm.getTableVersion();
			trThreetable.setThreetableCode(tableCode);	
		} else {
			trThreetableBySelect = trThreetableBySelectList.get(0);
			//此处是找到了以前的，所以当前操作为更新文档version
			trThreetableBySelect.setThreetableVersion(threetableForm.getTableVersion());
			String tableCode = trThreetableBySelect.getThreetableCode();
			//去掉最后两位的版本号
			tableCode = tableCode.substring(0, tableCode.length()-2);
			//再加上最后的两位版本号
			tableCode += threetableForm.getTableVersion();
			trThreetableBySelect.setThreetableCode(tableCode);   //更新表单编号
			trThreetableBySelect.setCreateTime(DateUtility.getCurrentTimestamp());    //更新生成时间
			trThreetableBySelect.setThreetableId(TwoIdUtility.generateTwoId());			//新增表单ID
		}
		String createUserId = "";
		//使用FORM传过来的id，如果传过来为空，则使用session里面的值
		if (StringUtility.isEmptyAfterTrim(threetableForm.getCreateUser())) {
			HttpSession session = request.getSession();
			UserInfo currentUser = (UserInfo)session.getAttribute("currentUser");
			createUserId = currentUser.getUserId();
		} else {
			createUserId = threetableForm.getCreateUser();
		}
		
		int resultTotal = 0;
		if (trThreetableBySelectList.isEmpty()) {
			trThreetable.setUserId(createUserId);
			trThreetable.setThreetableId(TwoIdUtility.generateTwoId());
			resultTotal = threetableService.insert(trThreetable);
		} else {
			trThreetableBySelect.setUserId(createUserId);
			resultTotal = threetableService.insert(trThreetableBySelect);
		}
		
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
