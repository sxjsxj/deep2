/**
 * Copyright (c) 2015,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:FareUtil
 * Package Name:com.travelsky.fare.fareutil.commontools
 * File Name:DecodeUtil.java
 * Date:2015-2-2 下午7:52:16
 * 
 */
package com.deep.two.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


/**
 * ClassName: DecodeUtil <br/>
 * Description: 解码工具类 <br/>
 * Date: 2015-2-2 下午7:52:16 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

public final class DecodeUtil {
	/**
	 * Creates a new instance of DecodeUtil.<br/>
	 * Description: 私有构造器<br/>
	 */
	private DecodeUtil() {

	}

	/**
	 * decode: 解码，默认是UTF-8<br/>
	 * 
	 * @param str
	 *            待解码字符串
	 * @return 解码后字符串
	 * @throws ViewException
	 *             异常<br/>
	 */
	public static String decode(String str) throws ViewException {
		try {
			return URLDecoder.decode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			ViewException fe = new ViewException();
			fe.initCause(e);
			throw fe;
		}
	}

	/**
	 * decode: 重载方法，解码<br/>
	 * 
	 * @param str
	 *            待解码字符串
	 * @param charset
	 *            编码格式
	 * @return 解码后字符串
	 * @throws ViewException
	 *             异常<br/>
	 */
	public static String decode(String str, String charset) throws ViewException {
		try {
			return URLDecoder.decode(str, charset);
		} catch (UnsupportedEncodingException e) {
			ViewException fe = new ViewException();
			fe.initCause(e);
			throw fe;
		}
	}
}
