/**
 * Copyright (c) 2014,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:AirtisWebAuthorityService
 * Package Name:com.travelsky.fare.airtisweb.service.authority
 * File Name:MD5Md5Singleton.java
 * Date:2014-9-10 上午10:26:43
 * 
 */
package com.deep.two.authority.helper;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

 /**
 * ClassName: MD5Md5Singleton <br/>
 * Description: TODO <br/>
 * Date: 2014-9-10 上午10:26:43 <br/>
 * <br/>
 * 
 * @author Administrator(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

public final class Md5Singleton extends Md5PasswordEncoder {

	private static Md5Singleton instance = new Md5Singleton();

	private Md5Singleton() {
	}

	/**
	 * getInstance:获取 MD5单例<br/>
	 * @return 获取 MD5单例
	 */
	public static Md5Singleton getInstance() {
		return instance;
	}

}
