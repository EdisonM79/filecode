package com.jzsk.filecode.model.entity;

import java.util.Date;

public class TrFilename {
	private String filenameId;

	private String filename;

	private String userId;

	private Date creteTime;

	private String filecode;

	private String projectId;

	public String getFilenameId() {
		return filenameId;
	}

	public void setFilenameId(String filenameId) {
		this.filenameId = filenameId;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getCreteTime() {
		return creteTime;
	}

	public void setCreteTime(Date creteTime) {
		this.creteTime = creteTime;
	}

	public String getFilecode() {
		return filecode;
	}

	public void setFilecode(String filecode) {
		this.filecode = filecode;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

}