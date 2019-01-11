package com.jzsk.filecode.model.entity;

public class TrLog extends TrLogKey {

	private String namelog;

	private String functionId;

	private String modelNum;

	private String projectId;

	private String typeId;

	public String getNamelog() {
		return namelog;
	}

	public void setNamelog(String namelog) {
		this.namelog = namelog;
	}

	public String getFunctionId() {
		return functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	public String getModelNum() {
		return modelNum;
	}

	public void setModelNum(String modelNum) {
		this.modelNum = modelNum;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

}