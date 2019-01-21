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
import com.jzsk.filecode.model.entity.TrFilename;
import com.jzsk.filecode.model.entity.TrFunction;
import com.jzsk.filecode.model.entity.TrLog;
import com.jzsk.filecode.model.entity.TrLogKey;
import com.jzsk.filecode.model.entity.TrProject;
import com.jzsk.filecode.model.entity.TrType;
import com.jzsk.filecode.model.form.FilecodeForm;
import com.jzsk.filecode.model.value.CodeValue;
import com.jzsk.filecode.model.value.FilenameValue;
import com.jzsk.filecode.model.value.FunctionValue;
import com.jzsk.filecode.model.value.ProjectInfoValue;
import com.jzsk.filecode.model.value.TypeValue;
import com.jzsk.filecode.model.value.UserInfo;
import com.jzsk.filecode.service.FilenameService;
import com.jzsk.filecode.service.FunctionService;
import com.jzsk.filecode.service.LogService;
import com.jzsk.filecode.service.ProjectService;
import com.jzsk.filecode.service.TypeService;
import com.jzsk.filecode.service.UserService;
import com.jzsk.filecode.utility.DateUtility;
import com.jzsk.filecode.utility.FilenameIDUtility;
import com.jzsk.filecode.utility.ResponseUtility;

@Controller
public class FilecodeController extends CommonController{
	
	@Autowired
	private FilenameService filenameService;
	@Autowired
	private LogService logService;
	@Autowired
	private UserService userService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private FunctionService functionService;
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
    @RequestMapping(value = UrlConstants.ADMIN_FILECODE_LIST)
    public String filecodeList(HttpServletResponse response, HttpServletRequest request, ModelMap modelMap) throws Exception {
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
    	List<TrFilename> codes = filenameService.selectAllFilecode();
    	int count = filenameService.countAll();
    	List<FilenameValue> filecodes = new ArrayList<>();
    	for (TrFilename trFilename : codes) {
    		FilenameValue codeValue = new FilenameValue();
    		codeValue.setCreteTime(DateUtility.toStringDate("yyyy-MM-dd HH:mm:ss", trFilename.getCreteTime()));
    		codeValue.setFilecode(trFilename.getFilecode());
    		codeValue.setFilename(trFilename.getFilename());
    		codeValue.setFilenameId(trFilename.getFilenameId());
    		String projectName = projectService.selectByPrimaryKey(trFilename.getProjectId()).getProjectName();
    		codeValue.setProjectName(projectName);
    		String user = userService.selectByPrimaryKey(trFilename.getUserId()).getUserName();
    		codeValue.setUser(user);
    		filecodes.add(codeValue);
		}
    	modelMap.put("filecodes", filecodes);
    	modelMap.put("count", count);
         
    	return "filenamelist";
    	
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
    @RequestMapping(value = UrlConstants.ADMIN_FILECODE_ADD)
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
        
        List<TrProject> projectList = projectService.selectAllProject();
        List<ProjectInfoValue> projects = new ArrayList<>();        
        for (TrProject trProject : projectList) {
        	ProjectInfoValue projectInfoValue = new ProjectInfoValue();       	
        	projectInfoValue.setProjectId(trProject.getProjectId());
        	projectInfoValue.setProjectCode(trProject.getProjectCode());
        	projectInfoValue.setProjectName(trProject.getProjectName());
        	projects.add(projectInfoValue);
		}
        
        List<TrFunction> functionList = functionService.selectAllFunction();
        List<FunctionValue> functions = new ArrayList<>();
        for (TrFunction trFunction : functionList) {
        	FunctionValue functionValue = new FunctionValue();       	
        	functionValue.setFunctionId(trFunction.getFunctionId());
        	functionValue.setFunctionCode(trFunction.getFunctionCode());
        	functionValue.setFunctionName(trFunction.getFunctionName());
        	functions.add(functionValue);
		}
        
        List<TrType> typeList = typeService.selectAllType();
        List<TypeValue> types = new ArrayList<>();
        for (TrType trType : typeList) {
        	TypeValue typeValue = new TypeValue();       	
        	typeValue.setTypeId(trType.getTypeId());
        	typeValue.setTypeCode(trType.getTypeCode());
        	typeValue.setTypeName(trType.getTypeName());
        	types.add(typeValue);
		}
        CodeValue codeValue = new CodeValue();
        codeValue.setFunctions(functions);
        codeValue.setProjects(projects);
        codeValue.setTypes(types);
        modelMap.put("codeValue", codeValue);
        
        return "addfilecode";
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
	@SuppressWarnings({ "unchecked" })
	@RequestMapping(value = UrlConstants.ADMIN_FILECODE_SAVE, method = RequestMethod.POST)
	public String saveFilecode(HttpServletResponse response, HttpServletRequest request,ModelMap  modelMap, FilecodeForm filecodeForm) throws Exception {
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
		
		String projectCode = projectService.selectByPrimaryKey(filecodeForm.getProject()).getProjectCode();
		String module = filecodeForm.getModule();
		String functionCode = functionService.selectByPrimaryKey(filecodeForm.getFunction()).getFunctionCode();
		String typeCode = typeService.selectByPrimaryKey(filecodeForm.getType()).getTypeCode();
		//获取页面传递过来的log，然后用于查询
		TrLogKey logKey = new TrLogKey();
		logKey.setFunctionId(functionCode);
		logKey.setModelNum(module);
		logKey.setProjectId(projectCode);
		logKey.setTypeId(typeCode);	
		TrLog log = new TrLog();
		log = logService.selectByPrimaryKey(logKey);
		//假如还没有生成log，则重新生成
		if (null == log) {
			TrLog log2 = new TrLog();
			log2.setFunctionId(functionCode);
			log2.setModelNum(module);
			log2.setProjectId(projectCode);
			log2.setTypeId(typeCode);
			int star = (int) (Math.random()*500);//500以内的
			String starString = String.valueOf(star);
			//用于保存生成的区间	
			
			String namelog = starString + ",-,";		
			int rd = (int) (Math.random()*50000 + 50000);//5W-10W以内的
			namelog += String.valueOf(rd);
			namelog += ";";
			
			namelog += String.valueOf(rd);			
		    rd = (int) (Math.random()*100000+100000);//20W以内的
			namelog += ",-,";
			namelog += String.valueOf(rd);
			namelog += ";";
			
			namelog += String.valueOf(rd);
		    rd = (int) (Math.random()*100000+200000);//30W
			namelog += ",-,";
			namelog += String.valueOf(rd);
			namelog += ";";
			
			namelog += String.valueOf(rd);
		    rd = (int) (Math.random()*100000+300000);//40W
			namelog += ",-,";
			namelog += String.valueOf(rd);
			namelog += ";";
			
			namelog += String.valueOf(rd);
		    rd = (int) (Math.random()*100000+400000);//50W
			namelog += ",-,";
			namelog += String.valueOf(rd);
			namelog += ";";
			
			namelog += String.valueOf(rd);
		    rd = (int) (Math.random()*100000+500000);//60W
			namelog += ",-,";
			namelog += String.valueOf(rd);
			namelog += ";";
			
			namelog += String.valueOf(rd);
		    rd = (int) (Math.random()*100000+600000);//70W
			namelog += ",-,";
			namelog += String.valueOf(rd);
			namelog += ";";
			
			namelog += String.valueOf(rd);
		    rd = (int) (Math.random()*100000+700000);//80W
			namelog += ",-,";
			namelog += String.valueOf(rd);
			namelog += ";";
			
			namelog += String.valueOf(rd);
		    rd = (int) (Math.random()*100000+800000);//90W
			namelog += ",-,";
			namelog += String.valueOf(rd);
			namelog += ";";
			
			namelog += String.valueOf(rd);
			namelog += ",-,1000000";
			log2.setNamelog(namelog);
			logService.insertSelective(log2);		
			log = log2;
		} 
		String filename = "JZ-";
		filename += log.getProjectId();
		filename += "-";
		filename += log.getModelNum();
		filename += "-";
		filename += log.getFunctionId();
		filename += "-";
		filename += log.getTypeId();
		filename += "-0";
		//用“;”把log分为10
		String logString = log.getNamelog();
		String[] loglist = logString.split(";");
		//随机10以内的整数
		int rs = (int) (Math.random()*10);//10以内的
		//获取当前随机的整数
		String currentlog = loglist[rs];
		//使用，分割字符串
		String[] current = currentlog.split(",");
		//如果还没有使用
		if ("-"==current[1]||"-".equals(current[1])) {
			//就使用左边的字符串
			current[1] = current[0];
		} else {
			//否则把中间的数+1
			int add = Integer.parseInt(current[1]);
			add++;
			current[1] = String.valueOf(add);
		}
		
		int length = current[1].length();
		String addString = "";
		for (int i = 0; i < 6 - length; i++) {
			addString += "0";
		}
		filename += addString;
		filename += current[1];	
		//重新拼接log字符串
		String editLog = current[0]+","+current[1]+","+current[2];
		loglist[rs] = editLog;
		String newLog = "";
		for (int i = 0; i < 10; i++) {
			newLog+=loglist[i];
			newLog+=";";
		}
		TrLog newFileLog = new TrLog();
		newFileLog.setFunctionId(functionCode);
		newFileLog.setModelNum(module);
		newFileLog.setProjectId(projectCode);
		newFileLog.setTypeId(typeCode);
		newFileLog.setNamelog(newLog);
		//生成新的文件标号记录
		int logResult = logService.updateByPrimaryKeySelective(newFileLog);
		
		//把新生成的文件编号记录
		TrFilename record = new TrFilename();
		record.setFilenameId(FilenameIDUtility.generateFilenameID());
		record.setCreteTime(DateUtility.getCurrentTimestamp());
		//record.setFilename(projectService.selectByPrimaryKey(filecodeForm.getProject()).getProjectName());
		record.setFilename(filecodeForm.getFilename());
		record.setProjectId(filecodeForm.getProject());
		record.setFilecode(filename);
		//获取当前使用人的ID
		HttpSession session = request.getSession();
		UserInfo currentUser = (UserInfo)session.getAttribute("currentUser");
		record.setUserId(currentUser.getUserId());		
		int resultTotal = filenameService.insertSelective(record);
        //检查ip地址
		JSONObject result = new JSONObject();
		if (resultTotal > 0 && logResult > 0)														// 操作成功
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
