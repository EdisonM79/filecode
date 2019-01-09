/**
 * StringUtility.java
 * 
 * zhnf 2016
 * 
 * LiuYangtao
 */
package com.jzsk.filecode.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author LiuYangtao
 *
 */
public class StringUtility {

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null || str.length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmptyAfterTrim(String str) {
		if (str == null || str.trim().length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断是否为整数 是:true
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/**
	 * 判断是否为浮点数
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isDouble(String str) {
		try {
			Double.parseDouble(str);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/**
	 * 判断字符串是否是数字
	 */
	public static boolean isNumber(String str) {
		return isInteger(str) || isDouble(str);
	}

	/**
	 * 判断身份证
	 * 
	 * @param idCardNo
	 * @return true:正确
	 */
	public static boolean checkIdCardNo(String idCardNo) {
		String rgx = "^\\d{17}([0-9]|X|x)$";
		return isCorrect(rgx, idCardNo);
	}

	/**
	 * 判断手机号
	 * 
	 * @param mobileNo
	 * @return true:正确
	 */
	public static boolean checkMobileNo(String mobileNo) {
		String rgx = "^1(3|4|5|7|8)\\d{9}$";
		return isCorrect(rgx, mobileNo);
	}

	/**
	 * 正则判断
	 * 
	 * @param rgx
	 * @param res
	 * @return
	 */
	public static boolean checkString(String rgx, String res) {
		return isCorrect(rgx, res);
	}

	/**
	 * 正则验证
	 * 
	 * @param rgx
	 * @param res
	 * @return
	 */
	private static boolean isCorrect(String rgx, String res) {
		Pattern p = Pattern.compile(rgx);
		Matcher m = p.matcher(res);
		return m.matches();
	}

	/**
	 * 判断一个字符是否是中文
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isChinese(char c) {
		return c >= 0x4E00 && c <= 0x9FA5;// 根据字节码判断
	}

	/**
	 * 判断一个字符串是否含有中文
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isChinese(String str) {
		if (str == null)
			return false;
		for (char c : str.toCharArray()) {
			if (isChinese(c))
				return true;
		}
		return false;
	}

	/**
	 * 判断是否只包含数字和字母
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumberAndLetter(String str) {
		String rgx = "^[a-zA-Z0-9]+$";
		return isCorrect(rgx, str);
	}

}
