/**
 * CookiePasswordUtility.java
 * 
 * zhnf 2016
 * 
 * LiuYangtao
 */
package com.jzsk.filecode.utility;

import java.util.Random;

/**
 * @author LiuYangtao
 *
 */
public class CookiePasswordUtility {

	private static final String BASE_WORD = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	public static String generateCookiePassword() {

		StringBuilder sb = new StringBuilder();

		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			int number = random.nextInt(BASE_WORD.length());
			sb.append(BASE_WORD.charAt(number));
		}

		return sb.toString();
	}
}
