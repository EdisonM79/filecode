/**
 * DateUtility.java
 * 
 * zhnf 2016
 * 
 * LiuYangtao
 */
package com.jzsk.filecode.utility;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author LiuYangtao
 *
 */
public class DateUtility {

	/** 小于(less than) */
	public static final String LT = "LT";
	/** 大于(great than) */
	public static final String GT = "GT";
	/** 等于(equal) */
	public static final String EQ = "EQ";
	/** 小于等于(less than or equal) */
	public static final String LE = "LE";
	/** 大于等于(great than or equal) */
	public static final String GE = "GE";

	/**
	 * 
	 * @param utilDate {@link java.util.Date}
	 * @return {@link java.sql.Date}
	 */
	public static java.sql.Date toSqlDate(java.util.Date utilDate) {
		return new java.sql.Date(utilDate.getTime());
	}

	/**
	 * <pre>
	 * eg:("2015", "05", "13"). return 2014-05-15 
	 * eg:("2015", "3", "4"). return 2014-03-04
	 * </pre>
	 * 
	 * @param year String
	 * @param month String
	 * @param day String
	 * @return {@link java.sql.Date}
	 */
	public static java.sql.Date toSqlDate(String year, String month, String day) {
		return toSqlDate(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day));
	}

	/**
	 * <pre>
	 * eg:(2015, 11, 13). return 2014-11-13
	 * eg:(2015, 3, 4). return 2014-03-04
	 * </pre>
	 * 
	 * @param year int
	 * @param month int
	 * @param day int
	 * @return {@link java.sql.Date}
	 */
	public static java.sql.Date toSqlDate(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, day, 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return toSqlDate(calendar.getTime());
	}

	/**
	 * 
	 * @return {@link java.sql.Date}
	 */
	public static java.sql.Date getToday() {
		return new java.sql.Date(System.currentTimeMillis());
	}

	/**
	 * 
	 * @return {@link java.sql.Timestamp}
	 */
	public static java.sql.Timestamp getCurrentTimestamp() {
		return new java.sql.Timestamp(System.currentTimeMillis());
	}

	/**
	 * 
	 * @param date
	 * @param minute
	 * @return {@link java.sql.Timestamp}
	 */
	public static java.sql.Date addMonth(java.sql.Date date, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date.getTime());
		calendar.add(Calendar.MONTH, month);
		return new java.sql.Date(calendar.getTimeInMillis());
	}

	/**
	 * 
	 * @param date
	 * @param minute
	 * @return {@link java.sql.Timestamp}
	 */
	public static java.sql.Date addDay(java.sql.Date date, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date.getTime());
		calendar.add(Calendar.DAY_OF_MONTH, day);
		return new java.sql.Date(calendar.getTimeInMillis());
	}

	/**
	 * 
	 * @param timestamp
	 * @param second
	 * @return {@link java.sql.Timestamp}
	 */
	public static java.sql.Timestamp addSecond(java.sql.Timestamp timestamp, int second) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(timestamp.getTime());
		calendar.add(Calendar.SECOND, second);
		return new java.sql.Timestamp(calendar.getTimeInMillis());
	}

	/**
	 * 
	 * @param timestamp
	 * @param minute
	 * @return {@link java.sql.Timestamp}
	 */
	public static java.sql.Timestamp addMinute(java.sql.Timestamp timestamp, int minute) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(timestamp.getTime());
		calendar.add(Calendar.MINUTE, minute);
		return new java.sql.Timestamp(calendar.getTimeInMillis());
	}

	/**
	 * 
	 * @param timestamp
	 * @param day
	 * @return {@link java.sql.Timestamp}
	 */
	public static java.sql.Timestamp addDay(java.sql.Timestamp timestamp, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(timestamp.getTime());
		calendar.add(Calendar.DAY_OF_MONTH, day);
		return new java.sql.Timestamp(calendar.getTimeInMillis());
	}

	/**
	 * 
	 * @param year int
	 * @param month int
	 * @return int
	 */
	public static int getMaxDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, 1);
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 
	 * @param date
	 * @return yyyy
	 */
	public static String getYear(java.util.Date date) {
		DateFormat format = new SimpleDateFormat("yyyy");
		return format.format(date);
	}

	/**
	 * 
	 * @param date
	 * @return MM
	 */
	public static String getMonth(java.util.Date date) {
		DateFormat format = new SimpleDateFormat("MM");
		return format.format(date);
	}

	/**
	 * 
	 * @param date
	 * @return dd
	 */
	public static String getDay(java.util.Date date) {
		DateFormat format = new SimpleDateFormat("dd");
		return format.format(date);
	}

	/**
	 * 日期格式化
	 * 
	 * @param dateFormat(日期格式，例如：yyyy-MM-dd HH:mm:ss)
	 * @param timestamp
	 * @return
	 */
	public static String toStringDate(String format, java.util.Date timestamp) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(timestamp);
	}

	/**
	 * 日期格式化
	 * 
	 * @param dateFormat(日期格式，例如：yyyy-MM-dd HH:mm:ss)
	 * @param timestamp(long型)
	 * @return
	 */
	public static String toStringDate(String format, Long timestamp) {
		try {
			Timestamp timestampT = new Timestamp(timestamp);
			return toStringDate(format, timestampT);
		} catch (Exception e) {
			return String.valueOf(timestamp);
		}
	}

	/**
	 * 日期格式化
	 * 
	 * @param dateFormat(日期格式，例如：yyyy-MM-dd HH:mm:ss)
	 * @param timestamp(String型)
	 * @return
	 */
	public static String toStringDate(String format, String timestamp) {
		try {
			Timestamp timestampT = Timestamp.valueOf(timestamp);
			return toStringDate(format, timestampT);
		} catch (Exception e) {
			return timestamp;
		}
	}

	/**
	 * 比较日期
	 * 
	 * @param date1 {@link java.util.Date}
	 * @param date2 {@link java.util.Date}
	 * @param compareDiv {@link DateUtility}
	 * @return
	 */
	public static boolean compareDate(java.util.Date date1, java.util.Date date2, String compareDiv) {
		if (date1 == null || date2 == null) {
			throw new IllegalArgumentException();
		}
		int result = date1.compareTo(date2);
		if (LT.equals(compareDiv)) {
			if (result == -1) {
				return true;
			}
		}
		if (GT.equals(compareDiv)) {
			if (result == 1) {
				return true;
			}
		}
		if (EQ.equals(compareDiv)) {
			if (result == 0) {
				return true;
			}
		}
		if (LE.equals(compareDiv)) {
			if (result < 1) {
				return true;
			}
		}
		if (GE.equals(compareDiv)) {
			if (result > -1) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 比较日期
	 * 
	 * @param date1 {@link java.lang.String}(yyyy/mm/dd HH:mm, yyyy-mm-dd HH:mm)
	 * @param date2 {@link java.lang.String}(yyyy/mm/dd HH:mm, yyyy-mm-dd HH:mm)
	 * @param compareDiv {@link DateUtility}
	 * @return
	 */
	public static boolean compareDate(String date1, String date2, String compareDiv) {
		if (StringUtility.isEmptyAfterTrim(date1) || StringUtility.isEmptyAfterTrim(date2)) {
			throw new IllegalArgumentException();
		}
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		java.util.Date date1T = null;
		java.util.Date date2T = null;
		try {
			if (date1.indexOf("-") != -1) {
				date1T = sdf1.parse(date1);
			}
			if (date1.indexOf("/") != -1) {
				date1T = sdf2.parse(date1);
			}
			if (date2.indexOf("-") != -1) {
				date2T = sdf1.parse(date2);
			}
			if (date2.indexOf("/") != -1) {
				date2T = sdf2.parse(date2);
			}
		} catch (ParseException e) {
			throw new IllegalArgumentException();
		}
		return compareDate(date1T, date2T, compareDiv);
	}

	/**
	 * 比较日期
	 * 
	 * @param date1 {@link java.lang.Long}
	 * @param date2 {@link java.lang.Long}
	 * @param compareDiv {@link DateUtility}
	 * @return
	 */
	public static boolean compareDate(Long date1, Long date2, String compareDiv) {
		if (date1 == null || date2 == null) {
			throw new IllegalArgumentException();
		}
		return compareDate(new Timestamp(date1), new Timestamp(date2), compareDiv);
	}

}
