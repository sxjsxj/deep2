/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:com.deep.two.dao.util
 * File Name:IdProcessUtil.java
 * Date:2016-5-6 下午4:33:18
 * 
 */
package com.deep.two.dao.util;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import com.deep.two.util.ViewException;

/**
 * ClassName: IdProcessUtil <br/>
 * Description: TODO <br/>
 * Date: 2016-5-6 下午4:33:18 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

public class StatusProcessUtil {
	private static Logger logger = Logger.getLogger(StatusProcessUtil.class);

    public static <T> void setStatus(T t, String status) throws ViewException {
        try {
            Method m = t.getClass().getMethod("setStatus", String.class);
            if (m != null) {
                m.invoke(t, status);
            }
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
        }
    }
    
    public static <T> void setCommunicateStatus(T t, String communicateStatus) throws ViewException {
        try {
            Method m = t.getClass().getMethod("setCommunicateStatus", String.class);
            if (m != null) {
                m.invoke(t, communicateStatus);
            }
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
        }
    }
    
    
    public static <T> void setRemark(T t, String remark) throws ViewException {
        try {
            Method m = t.getClass().getMethod("setRemark", String.class);
            if (m != null) {
                m.invoke(t, remark);
            }
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
        }
    }
}
