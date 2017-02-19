/**
 * Copyright (c) 2015,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:TrafficWebAuthorityService
 * Package Name:com.travelsky.fare.service.authority.impl
 * File Name:SessionHelper.java
 * Date:2015-7-20 下午11:08:23
 * 
 */
package com.deep.two.authority.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;

/**
 * ClassName: SessionHelper <br/>
 * Description: TODO <br/>
 * Date: 2015-7-20 下午11:08:23 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

public class SessionHelper {
    public static Map<String, HttpSession> sessionMap = new HashMap<String, HttpSession>();
    public static Map<String, Authentication> authencationMap = new HashMap<String, Authentication>();
    // private static HttpSession session = null;
    // private static Authentication authencation = null;
    //
    // public static HttpSession getSession() {
    // return session;
    // }
    //
    // public static void setSession(HttpSession session) {
    // SessionHelper.session = session;
    // }
    //
    // public static Authentication getAuthencation() {
    // return authencation;
    // }
    //
    // public static void setAuthencation(Authentication authencation) {
    // SessionHelper.authencation = authencation;
    // }

}
