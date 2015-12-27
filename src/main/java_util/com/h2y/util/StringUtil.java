package com.h2y.util;


/**
 * 项目名称：h2ygdsos  
 * 类名称：StringUtil  
 * 类描述：  字符串操作类
 * 创建人：侯飞龙  
 * 创建时间：2015年4月13日 上午10:34:20  
 * 修改人：侯飞龙
 * 修改时间：2015年4月13日 上午10:34:20  
 * 修改备注：  
 * @version
 */
public class StringUtil{
	
	/**
	 * 字符类对象转字符串（避免null字符串的出现）
	 * @param obj
	 * @return
	 */
	public static String objectToString(Object obj){
		
		return obj==null ? null : obj+"";
	}
}
