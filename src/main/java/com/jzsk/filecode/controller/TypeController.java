package com.jzsk.filecode.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.alibaba.fastjson.JSONObject;
import com.jzsk.filecode.constants.UrlConstants;
import com.jzsk.filecode.controller.common.CommonController;
import com.jzsk.filecode.model.entity.TrType;
import com.jzsk.filecode.model.form.TypeForm;
import com.jzsk.filecode.service.TypeService;
import com.jzsk.filecode.utility.ResponseUtility;
import com.jzsk.filecode.utility.TypeIdUtility;

@Controller
public class TypeController extends CommonController{
	
	@Autowired
	private TypeService typeService;
	
	/**
     * @param response
     * @param request
     * @param modelMap
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = UrlConstants.ADMIN_TYPE_LIST)
    public String functionList(HttpServletResponse response, HttpServletRequest request, ModelMap modelMap) throws Exception {
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
    	List<TrType> types = typeService.selectAllType();
    	int count = typeService.countAll();
    	modelMap.put("count", count);
    	modelMap.put("types", types);
         
    	return "typelist";
    	
    }
    
    /**
     * 跳转到新增用户界面
     * @param response
     * @param request
     * @param modelMap
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = UrlConstants.ADMIN_TYPE_ADD)
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
        return "addtype";
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
	@RequestMapping(value = UrlConstants.ADMIN_TYPE_SAVE, method = RequestMethod.POST)
	public String saveUser(HttpServletResponse response, HttpServletRequest request,ModelMap  modelMap, TypeForm typeForm) throws Exception {
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
		TrType type = new TrType();
		type.setTypeId(TypeIdUtility.generateTypeId());
		type.setTypeName(typeForm.getTypeName());
		type.setTypeCode(typeForm.getTypeCode());
		
		
		int resultTotal = typeService.insertSelective(type);
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
