/**
 * Copyright (c) 2015,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:FareUtil_v1.3.0
 * Package Name:com.travelsky.fare.fareutil.commontools
 * File Name:CollectionUtil.java
 * Date:2015-3-26 下午1:39:02
 * 
 */
package com.deep.two.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;


/**
 * ClassName: CollectionUtil <br/>
 * Description: 集合工具 <br/>
 * Date: 2015-3-26 下午1:39:02 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 *          2015-11-10 yangcheng(yangcheng@) 修改注释
 * 
 */

public class CollectionUtil {

	/**
	 * isEmpty: 判断一个list是否为空<br/>
	 * 当一个list是null或者为空时，则返回true<br/>
	 * 
	 * @param list
	 *            list
	 * @return true/false<br/>
	 */
	public static <T> boolean isEmpty(Collection<T> c) {
		if (c == null || c.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * hasOne:是否包含
	 * 
	 * @param c
	 *            集合
	 * @param t
	 *            元素
	 * @return
	 * @throws ViewException
	 *
	 */
	public static <T> boolean hasOne(Collection<T> c, T t) throws ViewException {
		if (c == null) {
			//throw new FareUtilException("集合不能为null");
		    return false;
		}
		if (c.contains(t)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * hasSame:充分利用set集合元素不允许重复性 来断定list里的值是否都一样
	 * 
	 * @param list
	 *            参数外界传入集合
	 * @return boolean 返回布尔类型 都有一样返回true否则返回false<br/>
	 * @throws ViewException
	 *             工具异常
	 */
	public static boolean hasSame(List<? extends String> list) throws ViewException {
		if (list == null || list.isEmpty()) {
			//throw new FareUtilException("断定list里的值是否都一样时list不能为null和list.size()不能为0");
		    return false;
		}
		return 1 == new HashSet<String>(list).size();
	}

	/**
	 * isExistSpace:判断list里面的值是否包含空格<br/>
	 * 
	 * @param list
	 *            传入参数
	 * @return boolean 如果list中包含空格返回true，否则返回false<br/>
	 * @throws ViewException
	 *             工具异常
	 */
	public static boolean isExistSpace(List<String> list) throws ViewException {
		if (list == null || list.isEmpty()) {
			//throw new FareUtilException("判断list里面的值是否包含空格时list不能为null和list.size()不能为0");
		    return false;
		}
		StringBuffer strbuf = new StringBuffer();
		boolean spaceFlag = false;
		for (String str : list) {
			if (str.trim().isEmpty()) {
				strbuf.append(str);
			} else {
				strbuf.append(str.trim());
			}
		}
		if (strbuf.toString().contains(" ")) {
			spaceFlag = true;
		}
		return spaceFlag;
	}

	/**
	 * removeListSpace:把list中空字符和null过滤掉同时把字符前后的空格去掉 如把"A " " B "<br/>
	 * 
	 * @param list
	 *            旧的list
	 * @return List<String> 返回去掉空格后的list<br/>
	 * @throws ViewException
	 *             工具类异常
	 */
	public static List<String> removeListSpace(List<String> list) throws ViewException {
	      List<String> newList = new ArrayList<String>();
	    if (list == null || list.isEmpty()) {
		    return newList; 
			//throw new FareUtilException("list不能为null和list.size()不能为0");
		}
		for (String str : list) {
			if (str != null && !str.equals("")) {
				newList.add(str.trim());
			}
		}
		return newList;
	}

	/**
	 * strToArrayList:把逗号分隔字符串转list<br/>
	 * 
	 * @param str
	 *            逗号分隔字符串 如A,B,C
	 * @return List<String> 返回list <br/>
	 */
	public static List<String> strToArrayList(String str) {
		return strToArrayList(str, ",");
	}

	/**
	 * strToArrayList:把带有分隔符的字符串转list<br/>
	 * 
	 * @param str
	 *            待分隔字符串
	 * @param split
	 *            分隔符
	 * @return List<String> 返回list <br/>
	 */
	public static List<String> strToArrayList(String str, String split) {
		String[] strs = str.split(split);
		List<String> list = new ArrayList<String>();
		for (String tmp : strs) {
			if (!StringUtil.isEmpty(tmp)) {
				list.add(tmp);
			}
		}
		return list;
	}

	/**
	 * removeListSame:把list中重复元素去掉<br/>
	 * 
	 * @param list
	 *            返回去掉重复后的list
	 * @return List<String> list返回<br/>
	 */
	public static List<String> removeListSame(List<String> list) {
		List<String> newList = new ArrayList<String>();
		for (String str : list) {
			if (!newList.contains(str)) {
				newList.add(str);
			}
		}
		return newList;
	}

	/**
	 * listToString:把airportList转换为一个用逗号分隔的字符串 <br/>
	 * 
	 * @param list
	 *            前台传入航线站点值
	 * @return String 把list里面的值转成逗号分隔字符串<br/>
	 * 
	 */
	public static String listToString(List<String> list) {
		return listToString(list, ",");
	}

	/**
	 * listToString:把airportList转换为一个用逗号分隔的字符串 <br/>
	 * 
	 * @param list
	 *            前台传入航线站点值
	 * @return String 把list里面的值转成逗号分隔字符串<br/>
	 * 
	 */
	public static String listToString(List<String> list, String split) {
		StringBuilder sb = new StringBuilder();
		if (!isEmpty(list)) {
			for (int i = 0; i < list.size(); i++) {
				if (i < list.size() - 1) {
					sb.append(list.get(i) + split);
				} else {
					sb.append(list.get(i));
				}
			}
		}
		return sb.toString();
	}

	/**
	 * toBinaryString:将二进制的0101字符串进行逻辑或运算 返回最后二进制结果<br/>
	 * 
	 * @param listBinary
	 *            参数
	 * @return String 返回二进制字符串<br/>
	 */
	public static String toBinaryString(List<String> listBinary) {

		int m1 = 0;
		for (String str : listBinary) {
			// 将str 转换成 2进制 数值
			m1 |= Integer.parseInt(str, 2);
		}
		String toBinary = Integer.toBinaryString(m1);
		while (toBinary.length() < 8) {
			// 在不足的位数前都加“0”
			toBinary = "0" + toBinary;
		}
		return toBinary;
	}

	/**
	 * contains: 第一个collection是否包含第二个collection<br/>
	 * 
	 * @param c1
	 *            第一个collection
	 * @param c2
	 *            第二个collection
	 * @return true/false <br/>
	 */
	public static <T> boolean contains(Collection<T> c1, Collection<T> c2) {
		boolean flag = true;
		for (T t : c2) {
			if (!c1.contains(t)) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	/**
	 * hasIntersection: 有没有交集
	 * 
	 * @param c1
	 *            第一个集合
	 * @param c2
	 *            第二个集合
	 * @return
	 */
	public static <T> boolean hasIntersection(Collection<T> c1, Collection<T> c2) {
		boolean flag = false;
		for (T t : c2) {
			if (c1.contains(t)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
}
