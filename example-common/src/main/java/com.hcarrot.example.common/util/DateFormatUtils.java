package com.hcarrot.example.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangxiaochuan
 *
 */
public class DateFormatUtils {
	/**
	 * @param time
	 * @return
	 */
	public static String getDateString(long time){
		return getDateString(time,"yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * @param time
	 * @param format
	 * @return
	 */
	public static String getDateString(long time,String format){
		SimpleDateFormat s= new SimpleDateFormat(format);
		return s.format(time);
	}
	/**
	 * @param date
	 * @return
	 */
	public static String getDateString(Date date){
		return getDateString(date.getTime(),"yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getDateString(Date date,String format){
		
		return getDateString(date.getTime(),format);
	}
	
	/**
	 * @param date
	 * @param format
	 * @return
	 */
	public static long getDateLong(String date,String format) {
		SimpleDateFormat s = new SimpleDateFormat(format);
		Date d;
		try {
			d = s.parse(date);
		} catch (ParseException e) {
			return 0;
		}
		return d.getTime();
	}

}
