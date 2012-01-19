package com.elace.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
/**
 * 对list的处理工具类
 * @author Adun
 * 2010-06-03
 */
public class ListUtils {
	
	private static String TEXT_SEPERATOR=",";
	/**
	 * 判断一个列表是否为空(包括null和size为0)
	 * @param list
	 * @return boolean判断结果
	 */
	public static boolean isEmpty(List list){
		return null == list || list.size() == 0;
	}

	/**
	 * 判断一个列表是否非空,即不为null且size不为0
	 * @param list
	 * @return boolean判断结果
	 */
	public static boolean notEmpty(List list) {
		return !isEmpty(list);
	}
	
	/**
	 * 将一个list中的元素以逗号拼接成字符串返回
	 * @param list
	 * @return string
	 */
	public static String toString(List list){
		String result = ""; 
		if(!isEmpty(list)){
			result = StringUtils.join(list, ",");
		}
		return result;
	}
	/**
	 * 将字符串以,分割维list,同时过滤掉空的元素和重复的元素
	 * @param src 源串
	 * @param list 返回list
	 */
	public static List<String> stringToList(String src){
		List<String> list=new ArrayList<String>();
		if(StringUtils.isNotBlank(src)){
			String[] all=src.split(TEXT_SEPERATOR); 
			for(String tmp:all){
				if(StringUtils.isNotBlank(tmp)&&
						!list.contains(tmp.trim()) ){
					list.add(tmp.trim());
				}
			}
		}
		return list;
	}
}
