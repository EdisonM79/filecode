/**
 * UserOperationValue.java
 * 
 * zhnf 2017
 * 
 * LiuYangTao
 */
package com.jzsk.filecode.model.value.common;

import java.sql.Timestamp;

/**
 * @author LiuYangTao
 *
 */
public class UserOperationValue {

	/** 创建用户ID */
	private String createUserId;
	/** 创建用户时间 */
	private Timestamp createTimestamp;
	/** 更新用户ID */
	private String updateUserId;
	/** 更新用户时间 */
	private Timestamp updateTimestamp;
	/** 删除用户ID */
	private String deleteUserId;
	/** 删除用户时间 */
	private Timestamp deleteTimestamp;

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
	public Timestamp getCreateTimestamp() {
		return createTimestamp;
	}

	/**
	 * @param createTimestamp 要设置的 createTimestamp
	 */
	public void setCreateTimestamp(Timestamp createTimestamp) {
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
	public Timestamp getUpdateTimestamp() {
		return updateTimestamp;
	}

	/**
	 * @param updateTimestamp 要设置的 updateTimestamp
	 */
	public void setUpdateTimestamp(Timestamp updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}

	/**
	 * @return deleteUserId
	 */
	public String getDeleteUserId() {
		return deleteUserId;
	}

	/**
	 * @param deleteUserId 要设置的 deleteUserId
	 */
	public void setDeleteUserId(String deleteUserId) {
		this.deleteUserId = deleteUserId;
	}

	/**
	 * @return deleteTimestamp
	 */
	public Timestamp getDeleteTimestamp() {
		return deleteTimestamp;
	}

	/**
	 * @param deleteTimestamp 要设置的 deleteTimestamp
	 */
	public void setDeleteTimestamp(Timestamp deleteTimestamp) {
		this.deleteTimestamp = deleteTimestamp;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserOperationValue [createUserId=" + createUserId + ", createTimestamp=" + createTimestamp + ", updateUserId=" + updateUserId + ", updateTimestamp=" + updateTimestamp + ", deleteUserId=" + deleteUserId + ", deleteTimestamp=" + deleteTimestamp + "]";
	}

}
