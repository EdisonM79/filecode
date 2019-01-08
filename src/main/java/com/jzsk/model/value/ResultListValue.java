/**
 * ResultListValue.java
 * 
 * ZhaBin
 * 
 * 2017
 */
package com.jzsk.model.value;

import java.util.List;

/**
 * @author ZhaBin
 *
 */
public class ResultListValue {

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
	/** 分页列表 */
	private List<String> pageList;
	/** 上页 */
	private boolean previous = false;
	/** 下页 */
	private boolean next = false;

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

	/**
	 * @return pageList
	 */
	public List<String> getPageList() {
		return pageList;
	}

	/**
	 * @param pageList 要设置的 pageList
	 */
	public void setPageList(List<String> pageList) {
		this.pageList = pageList;
	}

	/**
	 * @return previous
	 */
	public boolean isPrevious() {
		return previous;
	}

	/**
	 * @param previous 要设置的 previous
	 */
	public void setPrevious(boolean previous) {
		this.previous = previous;
	}

	/**
	 * @return next
	 */
	public boolean isNext() {
		return next;
	}

	/**
	 * @param next 要设置的 next
	 */
	public void setNext(boolean next) {
		this.next = next;
	}

}
