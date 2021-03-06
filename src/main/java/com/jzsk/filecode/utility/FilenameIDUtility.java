
package com.jzsk.filecode.utility;

import java.util.Random;

/**
 * @author mopx
 *
 */
public class FilenameIDUtility {
	/** 标识符 */
	private static final String ID = "F";

	/** 字符源 */
	private static final String BASE_WORD = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	/**
	 * 生成图片名称
	 * 
	 * @return
	 */
	public static String generateFilenameID() {

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
