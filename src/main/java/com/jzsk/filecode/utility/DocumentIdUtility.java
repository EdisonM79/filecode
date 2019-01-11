/**
 * BannerIdUtility.java
 * 
 * jzsk 2018
 * 
 * mopengxi@163.com
 */
package com.jzsk.filecode.utility;

import java.util.Random;

/**
 * @author mopengxi@163.com
 *
 */
public class DocumentIdUtility {
	
	/** 标识符 */
	private static final String ID = "D";

	/** 字符源 */
	private static final String BASE_WORD = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	/**
	 * 生成bannerID
	 * 
	 * @return
	 */
	public static String generateBatchId() {

		String hexTime = Long.toHexString(DateUtility.getCurrentTimestamp().getTime()).toUpperCase();

		StringBuilder sb = new StringBuilder();
		sb.append(ID);
		sb.append(hexTime);

		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			int number = random.nextInt(BASE_WORD.length());
			sb.append(BASE_WORD.charAt(number));
		}
		return sb.toString();
	}
}
