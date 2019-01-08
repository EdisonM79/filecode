/**
 * ResultList.java
 * 
 * ZhaBin
 * 
 * 2017
 */
package com.jzsk.model.serialization;

import java.util.List;

/**
 * @author ZhaBin
 *
 */
public class ResultList<T> {

	/** 记录列表 */
	List<T> records;
	/** 总页数 */
	private String totalPage;
	/** 总记录数 */
	private String totalRecord;
	/** 总数 */
	private String totalCount;
	/** 在线数 */
	private String onLineCount;
	/** 当前页码 */
	private String pageNum;

	/**
	 * @return records
	 */
	public List<T> getRecords() {
		return records;
	}

	/**
	 * @param records 要设置的 records
	 */
	public void setRecords(List<T> records) {
		this.records = records;
	}

	/**
	 * @return totalPage
	 */
	public String getTotalPage() {
		return totalPage;
	}

	/**
	 * @param totalPage 要设置的 totalPage
	 */
	public void setTotalPage(String totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * @return totalRecord
	 */
	public String getTotalRecord() {
		return totalRecord;
	}

	/**
	 * @param totalRecord 要设置的 totalRecord
	 */
	public void setTotalRecord(String totalRecord) {
		this.totalRecord = totalRecord;
	}

	/**
	 * @return totalCount
	 */
	public String getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount 要设置的 totalCount
	 */
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * @return onLineCount
	 */
	public String getOnLineCount() {
		return onLineCount;
	}

	/**
	 * @param onLineCount 要设置的 onLineCount
	 */
	public void setOnLineCount(String onLineCount) {
		this.onLineCount = onLineCount;
	}

	/**
	 * @return pageNum
	 */
	public String getPageNum() {
		return pageNum;
	}

	/**
	 * @param pageNum 要设置的 pageNum
	 */
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

}
