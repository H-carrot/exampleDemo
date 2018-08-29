package com.hcarrot.common.util;

/**
 * @author zhangxiaochuan
 *
 */
public class StringUtils {
	public static String getString(Object ...objects){
		StringBuffer sb = new StringBuffer();
		for(Object o: objects){
			sb.append(o);
		}
		return sb.toString();
	}
}
