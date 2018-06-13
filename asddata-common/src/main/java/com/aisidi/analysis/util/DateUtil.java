package com.aisidi.analysis.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	
	public static Integer addMonths(String yyyyMM, int num) throws ParseException {
		if (yyyyMM == null) {
			return null;
		}
		Date date = new SimpleDateFormat("yyyyMM").parse(yyyyMM);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, num);
		return Integer.valueOf(getDate(c.getTime()));
	}
	

	private DateUtil() {
	};

	/**
	 * 获取当前日期字符串，格式为yyyyMMdd
	 * 
	 * @return String
	 */
	public static String getCurrentDate() {
		return new SimpleDateFormat("yyyyMMdd").format(new Date());
	}
	
	public static Date parseDate(String date) throws ParseException {
		return new SimpleDateFormat("yyyyMMddHHmmss").parse(date);
	}

	/**
	 * 获取当前时间字符串，格式为HHmmss
	 * 
	 * @return String
	 */
	public static String getCurrentTime() {
		return new SimpleDateFormat("HHmmss").format(new Date());
	}

	public static String getCurrentTime1() {
		return new SimpleDateFormat("HH:mm:ss").format(new Date());
	}

	public static String getCurrentDateTime() {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}

	/**
	 * 获取对应Date的日期字符串，格式为yyyyMMddHHmmss
	 * 
	 * @param date
	 * @return
	 */

	public static String getDateTime(Date date) {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(date);
	}

	public static Date getFormatDate(String strDate) throws ParseException{
		return new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
	}
	
	public static Date getShortDate(String strDate) throws ParseException{
		return new SimpleDateFormat("yyyyMMdd").parse(strDate);
	}

	/**
	 * @Description:获取当前日期和时间（yyyyMMddhhmmss）
	 * @return String
	 * @author
	 * @date
	 */
	public static String getCurrDateTimeStr() {
		return new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	}

	
	/**
	 * 获取当前的毫秒时间，为long值
	 * 
	 * @return long
	 */
	public static long getCurrentLongTime() {
		return new Date().getTime();
	}

	/**
	 * 获取当前时间的字符串，格式为yyyy-MM-dd HH:mm:ss
	 * 
	 * @return String
	 */
	public static String getCurrentPrettyDateTime() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 获取对应Date的日期字符串，格式为yyyyMM
	 * 
	 * @param date
	 *            源Date
	 * @return
	 */
	public static String getDate(Date date) {
		return new SimpleDateFormat("yyyyMM").format(date);
	}

	/**
	 * 获取对应Date的时间字符串，格式为HHmmss
	 * 
	 * @param date
	 *            源Date
	 * @return String
	 */
	public static String getTime(Date date) {
		return new SimpleDateFormat("HHmmss").format(date);
	}

	/**
	 * 获取对应Date的时间字符串，格式为HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String getTime1(Date date) {
		return new SimpleDateFormat("HH:mm:ss").format(date);
	}

	/**
	 * 获取对应Date的日期字符串，格式为yyyy-MM-dd
	 * 
	 * @param date
	 *            源Date
	 * @return String
	 */
	public static String getPrettyDate(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

	/**
	 * 获取对应Date的字符串，格式为yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 *            源Date
	 * @return String
	 */
	public static String getPrettyDateTime(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}

	/**
	 * 获取Sybase的日期转换函数表达式，用于SQL中，格式是yyyy/MM/dd HH:mm:ss，没办法，Sybase不支持yyyy-MM-dd
	 * HH:mm:ss
	 * 
	 * @param field
	 *            要转换成yyyy/MM/dd HH:mm:ss格式字符串的日期类型字段名
	 * @return String
	 */
	public static String getSybaseConvertSQL(String field) {
		return "(CONVERT(varchar(12), " + field
				+ ", 111) + ' ' + CONVERT(varchar(12), " + field + ", 108))";
	}

	/**
	 * 获取Sybase的日期转换函数表达式，用于SQL中，格式是yyyy/MM/dd HH:mm:ss，没办法，Sybase不支持yyyy-MM-dd
	 * HH:mm:ss
	 * 
	 * @param field
	 *            要转换成yyyy/MM/dd HH:mm:ss格式字符串的日期类型字段名
	 * @return String
	 */
	public static String getSybaseYYYYMMDD(String field) {
		return "(CONVERT(varchar(12), " + field + ", 112))";
	}

	/*
	 * 获取当前日期，格式为XXXX年XX月XX日
	 */
	public static String getCurrentChnDate() {
		String strDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
		strDate = strDate.substring(0, 4) + "年" + strDate.substring(4, 6) + "月"
				+ strDate.substring(6) + "日";
		return strDate;
	}

	/*
	 * 将日期转换为格式XXXX年XX月XX日
	 */
	public static String getChnDate(Date date) {
		String strDate = new SimpleDateFormat("yyyyMMdd").format(date);
		strDate = strDate.substring(0, 4) + "年" + strDate.substring(4, 6) + "月"
				+ strDate.substring(6) + "日";
		return strDate;
	}

	/*
	 * 将日期转换为格式XXXX年XX月XX日
	 */
	public static String getChnTime(Date date) {
		String strDate = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒")
				.format(new Date());
		return strDate;
	}

	/*
	 * 将字符串'yyyyMMdd'日期转换为格式XXXX年XX月XX日
	 */
	public static String getChnDate(String strDate) {
		return strDate.substring(0, 4) + "年" + strDate.substring(4, 6) + "月"
				+ strDate.substring(6) + "日";
	}

	/**
	 * 检查日期字符串是否合法
	 * 
	 * @param dateStr
	 *            日期字符串
	 * @param pattern
	 *            日期格式
	 * @return 布尔
	 */
	// 'yyyyMMdd' 'HHmmss' 所以年月日不是yyyymmdd
	// public static boolean isValidDate(String dateStr, String pattern)
	// {
	// java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(pattern);
	//
	// df.setLenient(false);//来强调严格遵守该格式
	// //df.setLenient(true);
	// Date date = null;
	// try
	// {
	// date = df.parse(dateStr);
	// return true;
	// }
	// catch (ParseException e)
	// {
	// return false;
	// }
	//
	// //String result=df.format(date);//判断转换前后两个字符串是否相等即可知道合不合法
	// //return result.equals(dateStr);
	// }
	// 'yyyyMMdd' 'HHmmss' 所以年月日不是yyyymmdd
	// public static void checkValidDate(String dateStr, String pattern) throws
	// ChannelException
	// {
	// java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(pattern);
	//
	// df.setLenient(false);//来强调严格遵守该格式
	// //df.setLenient(true);
	// try
	// {
	// df.parse(dateStr);
	// }
	// catch (ParseException e)
	// {
	// throw new ChannelException("9303["+dateStr+"]日期格式非法");
	//
	// }
	// }

	public static int getMaxdayInAMonth(int year, int month) {
		Calendar time = Calendar.getInstance();
		time.clear();
		time.set(Calendar.YEAR, year); // year 为 int
		time.set(Calendar.MONTH, month - 1);// 注意,Calendar对象默认一月为0
		int day = time.getActualMaximum(Calendar.DAY_OF_MONTH);// 本月份的天数
		// 注：在使用set方法之前，必须先clear一下，否则很多信息会继承自系统当前时间
		return day;

	}

	// Calendar转化为Date
	public static Date CalendarToDate() {
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		return date;
	}

	// Date转化为Calendar
	public static Calendar DateToCalendar() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}


	/**
	 * 按年加减日期
	 * 
	 * @param date
	 *            ：日期
	 * @param num
	 *            ：要加减的年数
	 * @return：成功，则返回加减后的日期；失败，则返回null
	 */
	public static Date addYears(Date date, int num) {
		if (date == null) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR, num);
		return c.getTime();
	}

	/**
	 * 按秒 加减日期
	 * 
	 * @param date
	 *            ：日期
	 * @param num
	 *            ：要加减的秒
	 * @return：成功，则返回加减后的日期；失败，则返回null
	 */
	public static Date addSeconds(Date date, int num) {
		if (date == null) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.SECOND, num);
		return c.getTime();
	}

	public static Date getDate(String dateStr, String dateFormat)
			throws Exception {
		SimpleDateFormat df = new SimpleDateFormat(dateFormat);
		java.util.Date cDate = df.parse(dateStr);

		return cDate;
	}

	public static Date getDate(String dateStr) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		java.util.Date cDate = df.parse(dateStr);
		return cDate;
	}

	public static Date convertTimerToDate(Timestamp time) throws Exception {
		Date dd = new Date(time.getTime());
		return dd;
	}

	public static long DateDiff(Date date1, Date date2) throws Exception {
		return date1.getTime() - date2.getTime();
	}

	/**
	 * 获取当前日期上一个月的第一天，格式为yyyy-MM-dd hh:ms:ss
	 * 
	 * @return String
	 */
	public static String getLastMonthFirstDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return getPrettyDateTime(calendar.getTime());
	}

	/**
	 * 获取当前日期上一个月的第一天，格式为yyyy-MM-dd hh:ms:ss
	 * 
	 * @return String
	 */
	public static String getLastMonthEndDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return getPrettyDateTime(calendar.getTime());
	}
	
	public static Date strToDate(String str){
		DateFormat df=new SimpleDateFormat("yyyyMMdd");
		try {
		return df.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static Date strToDateByFormat(String dateStr, String formatStr) {
		SimpleDateFormat dd = new SimpleDateFormat(formatStr);
		Date date = null;
		try {
			date = dd.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
		return date;
	}
	
	
/*	public static Date strToDateByFormat(Date date, String formatStr) {
		SimpleDateFormat dd = new SimpleDateFormat(formatStr);
		Date date = null;
		try {
			date = dd.parse(date);
		} catch (ParseException e) {
			return null;
		}
		return date;
	}*/
}