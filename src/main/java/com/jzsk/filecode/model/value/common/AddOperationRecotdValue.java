/**
 * AddOperationRecotdValue.java
 * 
 * zhnf 2017
 * 
 * LiuYangTao
 */
package com.jzsk.filecode.model.value.common;

import java.util.Date;

/**
 * @author LiuYangTao
 *
 */
public class AddOperationRecotdValue {

	/** 操作ID */
	private String operationId;
	/** 操作时间戳 */
	private Date operationTimestamp;
	/** 操作用户ID */
	private String operationUserId;
	/** 操作ID区分 */
	private String operationIdDiv;
	/** 操作区分 */
	private String operationDiv;
	/** 状态区分 */
	private String statusDiv;
	/** 平台区分 */
	private String platDiv;
	/** 创建人ID */
	private String createUserId;
	/** 创建时间戳 */
	private Date createTimestamp;
	/** 更新用户ID */
	private String updateUserId;
	/** 更新时间戳 */
	private Date updateTimestamp;

	/**
	 * @return operationId
	 */
	public String getOperationId() {
		return operationId;
	}

	/**
	 * @param operationId 要设置的 operationId
	 */
	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	/**
	 * @return operationTimestamp
	 */
	public Date getOperationTimestamp() {
		return operationTimestamp;
	}

	/**
	 * @param operationTimestamp 要设置的 operationTimestamp
	 */
	public void setOperationTimestamp(Date operationTimestamp) {
		this.operationTimestamp = operationTimestamp;
	}

	/**
	 * @return operationUserId
	 */
	public String getOperationUserId() {
		return operationUserId;
	}

	/**
	 * @param operationUserId 要设置的 operationUserId
	 */
	public void setOperationUserId(String operationUserId) {
		this.operationUserId = operationUserId;
	}

	/**
	 * @return operationIdDiv
	 */
	public String getOperationIdDiv() {
		return operationIdDiv;
	}

	/**
	 * @param operationIdDiv 要设置的 operationIdDiv
	 */
	public void setOperationIdDiv(String operationIdDiv) {
		this.operationIdDiv = operationIdDiv;
	}

	/**
	 * @return operationDiv
	 */
	public String getOperationDiv() {
		return operationDiv;
	}

	/**
	 * @param operationDiv 要设置的 operationDiv
	 */
	public void setOperationDiv(String operationDiv) {
		this.operationDiv = operationDiv;
	}

	/**
	 * @return statusDiv
	 */
	public String getStatusDiv() {
		return statusDiv;
	}

	/**
	 * @param statusDiv 要设置的 statusDiv
	 */
	public void setStatusDiv(String statusDiv) {
		this.statusDiv = statusDiv;
	}

	/**
	 * @return platDiv
	 */
	public String getPlatDiv() {
		return platDiv;
	}

	/**
	 * @param platDiv 要设置的 platDiv
	 */
	public void setPlatDiv(String platDiv) {
		this.platDiv = platDiv;
	}

	/**
	 * @return createUserId
	 */
	public String getCreateUserId() {
		return createUserId;
	}

	/**
	 * @param createUserId 要设置的 createUserId
	 */
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * @return createTimestamp
	 */
	public Date getCreateTimestamp() {
		return createTimestamp;
	}

	/**
	 * @param createTimestamp 要设置的 createTimestamp
	 */
	public void setCreateTimestamp(Date createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	/**
	 * @return updateUserId
	 */
	public String getUpdateUserId() {
		return updateUserId;
	}

	/**
	 * @param updateUserId 要设置的 updateUserId
	 */
	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	/**
	 * @return updateTimestamp
	 */
	public Date getUpdateTimestamp() {
		return updateTimestamp;
	}

	/**
	 * @param updateTimestamp 要设置的 updateTimestamp
	 */
	public void setUpdateTimestamp(Date updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AddOperationRecotdValue [operationId=" + operationId + ", operationTimestamp=" + operationTimestamp + ", operationUserId=" + operationUserId + ", operationIdDiv=" + operationIdDiv + ", operationDiv=" + operationDiv + ", statusDiv=" + statusDiv + ", platDiv=" + platDiv + ", createUserId=" + createUserId + ", createTimestamp=" + createTimestamp + ", updateUserId=" + updateUserId + ", updateTimestamp=" + updateTimestamp + "]";
	}

}
