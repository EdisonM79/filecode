/**
 * 
 */
package com.jzsk.filecode.utility;

import java.util.ArrayList;
import java.util.List;

import com.jzsk.filecode.constants.Constants;
import com.jzsk.filecode.model.serialization.ResultList;
import com.jzsk.filecode.model.value.ResultListValue;

/**
 * @author sher
 *
 */
public class PageUtility {

	/**
	 * 设置翻页数据到Value
	 * 
	 * @param resultList
	 * @param resultListValue
	 */
	@SuppressWarnings("rawtypes")
	public static void setToValueForPaging(ResultList resultList, ResultListValue resultListValue) {
		if (resultList == null || resultListValue == null) {
			throw new IllegalArgumentException();
		}
		Integer totalPage = resultList.getTotalPage() == null ? 0 : Integer.valueOf(resultList.getTotalPage());
		Integer pageNum = resultList.getPageNum() == null ? 0 : Integer.valueOf(resultList.getPageNum());
		// 总页数
		resultListValue.setTotalPage(totalPage.toString());
		// 总数
		resultListValue.setTotalRecord(resultList.getTotalRecord() == null ? "0" : resultList.getTotalRecord());
		//
		resultListValue.setTotalCount(resultList.getTotalCount() == null ? "0" : resultList.getTotalCount());
		//
		resultListValue.setOnLineCount(resultList.getOnLineCount() == null ? "0" : resultList.getOnLineCount());
		// 当前页
		resultListValue.setPageNum(pageNum.toString());
		// 分页列表
		resultListValue.setPageList(createPageList(pageNum, totalPage));
		// 是否有上页
		resultListValue.setPrevious(hasPrevious(pageNum));
		// 是否有下页
		resultListValue.setNext(hasNext(pageNum, totalPage));
	}

	/**
	 * 创建分页列表
	 * 
	 * @param page
	 * @param pageMaxCount
	 * @param totalPages
	 * @return
	 */
	public static List<String> createPageList(Integer page, Integer totalPages) {
		return createPageList(page, Constants.PAGE_LIST_MAX_COUNT, totalPages);
	}

	/**
	 * 创建分页列表
	 * 
	 * @param page
	 * @param pageMaxCount
	 * @param totalPages
	 * @return
	 */
	public static List<String> createPageList(Integer page, Integer pageMaxCount, Integer totalPages) {
		List<String> pageList = new ArrayList<String>();

		if (pageMaxCount % 2 == 0) {
			if (page <= pageMaxCount / 2 || totalPages <= pageMaxCount - 1) {
				int maxPage = totalPages <= pageMaxCount - 1 ? totalPages : pageMaxCount - 1;
				for (int i = 1; i <= maxPage; i++) {
					pageList.add(String.valueOf(i));
				}
			} else if (page > pageMaxCount / 2 && totalPages > pageMaxCount - 1) {
				if (page <= totalPages - pageMaxCount / 2) {
					for (int i = page - (pageMaxCount - 1 - 1) / 2; i <= page + (pageMaxCount - 1 - 1) / 2; i++) {
						pageList.add(String.valueOf(i));
					}
				} else if (page > totalPages - pageMaxCount / 2) {
					for (int i = totalPages - (pageMaxCount - 1 - 1); i <= totalPages; i++) {
						pageList.add(String.valueOf(i));
					}
				}
			}
		} else {
			if (page < (pageMaxCount + 1) / 2 || totalPages <= pageMaxCount - 1) {
				int maxPage = totalPages <= pageMaxCount ? totalPages : pageMaxCount;
				for (int i = 1; i <= maxPage; i++) {
					pageList.add(String.valueOf(i));
				}
			} else if (page >= (pageMaxCount + 1) / 2 && totalPages > pageMaxCount - 1) {
				if (page <= totalPages - ((pageMaxCount + 1) / 2)) {
					for (int i = page - (pageMaxCount - 1) / 2; i <= page + (pageMaxCount - 1) / 2; i++) {
						pageList.add(String.valueOf(i));
					}
				} else if (page > totalPages - ((pageMaxCount + 1) / 2)) {
					for (int i = totalPages - (pageMaxCount - 1); i <= totalPages; i++) {
						pageList.add(String.valueOf(i));
					}
				}
			}
		}
		return pageList;
	}

	/**
	 * 是否有上页
	 * 
	 * @param page
	 * @param totalPages
	 * @return
	 */
	public static boolean hasPrevious(Integer page) {
		if (page > 1) {
			return true;
		}
		return false;
	}

	/**
	 * 是否有下页
	 * 
	 * @param page
	 * @param pageMaxCount
	 * @param totalPages
	 * @return
	 */
	public static boolean hasNext(Integer page, Integer totalPages) {
		if (page < totalPages) {
			return true;
		}
		return false;
	}

}
