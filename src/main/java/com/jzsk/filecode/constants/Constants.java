package com.jzsk.filecode.constants;

/** * @author LiuYangTao * */
public class Constants {

	/* * session */
	/** 用户信息 */
	public static final String SESSION_USER_VALUE = "userValue";

	/*
	 * 请求方式
	 */
	/** 请求方式-POST */
	public static final String REQUEST_METHOD_POST = "post";
	/** 请求方式-GET */
	public static final String REQUEST_METHOD_GET = "get";

	/*
	 * 页面显示数量
	 */
	/** 最大页码数 */
	public static final int PAGE_LIST_MAX_COUNT = 3;
	
	/*
	 * 项目是否锁定
	 */
	/** 锁定项目，不允许删除 */
	public static final String PROJECT_STATE_LOCK = "1";
	/** 不锁定项目，允许删除 */
	public static final String PROJECT_STATE_UNLOCK = "0";


}
