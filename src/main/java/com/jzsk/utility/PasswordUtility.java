/**
 * PasswordUtility.java
 * 
 * zhnf 2016
 * 
 * LiuYangtao
 */
package com.jzsk.utility;

import java.security.MessageDigest;
import java.util.Random;

/**
 * @author LiuYangtao
 *
 */
public class PasswordUtility {

	/** 基本字符 */
	private static final String BASE_WORD = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	/** 附加字符 */
	private static final String ADD_WORD = "wisfarm";

	/**
	 * 
	 * @param password 原密码(用户输入的密码)
	 * @return
	 */
	public static String encrypt(String password) {
		// 取得MD5
		String md5 = getMd5(password + ADD_WORD);
		// 取得中间16位
		String md516 = md5.substring(8, 24);
		// 取得四位密码附加字符
		String suffx = getSuffx();
		return suffx.substring(0, 1) + md516.substring(0, 4) + suffx.substring(1, 2) + md516.substring(4, 8) + suffx.substring(2, 3) + md516.substring(8, 12) + suffx.substring(3) + md516.substring(12);
	}

	/**
	 * 
	 * @param password 原密码(用户输入的密码)
	 * @param md5Password 加密后密码(数据库中密码)
	 * @return 相同:true; 其它:false
	 */
	public static boolean checkPassword(String password, String md5Password) {
		// 取得MD5
		String md5 = getMd5(password + ADD_WORD);
		// 取得中间16位
		String md516 = md5.substring(8, 24);
		// 数据库中密码16位
		String md5Password16 = md5Password.substring(1, 5) + md5Password.substring(6, 10) + md5Password.substring(11, 15) + md5Password.substring(16);
		return md516.equals(md5Password16);
	}

	/**
	 * 
	 * @param password
	 * @return
	 */
	private static String getMd5(String password) {
		String md5 = null;
		byte[] source = password.getBytes();
		// 用来将字节转换成 16 进制表示的字符
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(source);
			byte tmp[] = md.digest(); // MD5 的计算结果是一个 128 位的长整数，
			// 用字节表示就是 16 个字节
			char[] str = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符，
			// 所以表示成 16 进制需要 32 个字符
			int k = 0; // 表示转换结果中对应的字符位置
			for (int i = 0; i < 16; i++) { // 从第一个字节开始，对 MD5 的每一个字节
				// 转换成 16 进制字符的转换
				byte byte0 = tmp[i]; // 取第 i 个字节
				str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换,
				// >>> 为逻辑右移，将符号位一起右移
				str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
			}
			md5 = new String(str).toUpperCase();// 换后的结果转换为字符串
		} catch (Exception e) {
			// 什么也不做
		}
		return md5;
	}

	/**
	 * 
	 * @return
	 */
	private static String getSuffx() {
		StringBuilder sb = new StringBuilder();

		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			int number = random.nextInt(BASE_WORD.length());
			sb.append(BASE_WORD.charAt(number));
		}

		return sb.toString();
	}
}
