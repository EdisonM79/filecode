/**
 * IntegerUtility.java
 * 
 * zhnf 2016
 * 
 * LiuYangtao
 */
package com.jzsk.filecode.utility;

/**
 * @author LiuYangtao
 *
 */
public class IntegerUtility {

	/**
	 * String转Integer
	 * 
	 * @param str
	 * @return
	 */
	public static Integer toInteger(String str) {
		if (str == null) {
			return null;
		} else {
			Integer integer = Integer.valueOf(str);
			return integer;
		}

	}

	/**
	 * String转Integer
	 * 
	 * @param str
	 * @return
	 */
	public static Integer toIntegerNullToZero(String str) {
		if (str == null || str.trim().length() == 0) {
			return 0;
		} else {
			Integer integer = Float.valueOf(str).intValue();
			return integer;
		}

	}

}
