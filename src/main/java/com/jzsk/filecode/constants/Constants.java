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
	 * 图片分类
	 */
	/** 首页轮播大图 */
	public static final String IMAGE_DIV_BANNER = "0";
	/** 产品图片 */
	public static final String IMAGE_DIV_PRODUCT = "1";
	/** 解决方案图片 */
	public static final String IMAGE_DIV_SOLUTION = "2";

	/*
	 * 图片状态分类
	 */
	/** 图片状态-未删除 */
	public static final String IMAGE_STATE_ON = "1";
	/** 图片状态-删除 */
	public static final String IMAGE_STATE_OFF = "0";

	/*
	 * 产品状态分类
	 */
	/** 图片状态-显示 */
	public static final String PRODUCT_DISPLAY_ON = "1";
	/** 图片状态-不显示 */
	public static final String PRODUCT_DISPLAY_OFF = "0";

	/** 图片分类-简略图 */
	public static final String PRODUCT_DIV_BRIEF = "0";
	/** 图片分类-详细图 */
	public static final String PRODUCT_DIV_CONTENT = "1";
}
