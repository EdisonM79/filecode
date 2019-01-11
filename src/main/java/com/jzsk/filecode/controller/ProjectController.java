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
import com.jzsk.filecode.dao.UserDao;
import com.jzsk.filecode.model.entity.TrProject;
import com.jzsk.filecode.model.form.ProjectForm;
import com.jzsk.filecode.model.value.ProjectValue;
import com.jzsk.filecode.model.value.UserInfo;
import com.jzsk.filecode.service.ProjectService;
import com.jzsk.filecode.service.UserService;
import com.jzsk.filecode.utility.DateUtility;
import com.jzsk.filecode.utility.ProjectIdUtility;
import com.jzsk.filecode.utility.ResponseUtility;
import com.jzsk.filecode.utility.StringUtility;

@Controller
public class ProjectController extends CommonController{
	
	@Autowired
	private ProjectService projectService;
	@Autowired
	private UserService userService;
	
	
	/**
     * @param response
     * @param request
     * @param modelMap
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = UrlConstants.ADMIN_PROJECT_LIST)
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
    	List<TrProject> trProjects = projectService.selectAllProject();
    	List<ProjectValue> projects = new ArrayList<>();
    	for (TrProject trProject : trProjects) {
    		ProjectValue pjvalue = new ProjectValue();
    		pjvalue.setCreateTime(DateUtility.toStringDate("yyyy-MM-dd HH:mm:ss", trProject.getCreateTime()));
    		UserInfo createUser = userService.selectByPrimaryKey(trProject.getCreateUser());
    		pjvalue.setCreateUser(createUser.getUserName());
    		pjvalue.setIslock(trProject.getIslock());
    		pjvalue.setProjectCode(trProject.getProjectCode());
    		pjvalue.setProjectId(trProject.getProjectId());
    		pjvalue.setProjectName(trProject.getProjectName());
    		projects.add(pjvalue);
		} 	
    	modelMap.put("projects", projects);       
    	return "projectlist";
    	
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
    @RequestMapping(value = UrlConstants.ADMIN_PROJECT_ADD)
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
        return "addproject";
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
	@RequestMapping(value = UrlConstants.ADMIN_PROJECT_SAVE, method = RequestMethod.POST)
	public String saveUser(HttpServletResponse response, HttpServletRequest request,ModelMap  modelMap, ProjectForm projectForm) throws Exception {
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
		TrProject project = new TrProject();
		
		project.setProjectId(ProjectIdUtility.generateProjectId());
		project.setProjectName(projectForm.getProjectName());
		project.setProjectCode(projectForm.getProjectCode());
		String createUserId="";
		if (StringUtility.isEmptyAfterTrim(projectForm.getCreateUser())) {
			HttpSession session = request.getSession();
			UserInfo currentUser = (UserInfo)session.getAttribute("currentUser");
			createUserId = currentUser.getUserId();
		} else {
			createUserId = projectForm.getCreateUser();
		}
		
		project.setCreateUser(createUserId);
		project.setCreateTime(DateUtility.getCurrentTimestamp());
		project.setIslock(Constants.PROJECT_STATE_UNLOCK);
		
		int resultTotal = projectService.insert(project);
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
