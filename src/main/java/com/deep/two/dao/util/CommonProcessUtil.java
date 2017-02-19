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
import java.util.Date;

import org.apache.log4j.Logger;

import com.deep.two.authority.model.CurrentUser;
import com.deep.two.util.ViewException;

public class CommonProcessUtil {
	private static Logger logger = Logger.getLogger(CommonProcessUtil.class);
    public static <T> void setCommon(T t, CurrentUser cu) throws ViewException {
    	Method m = null;
    	try {
        	m = t.getClass().getMethod("setStatus", String.class);
            if (m != null) {
                m.invoke(t, "0");
            }
        }catch (Exception e) {
        	logger.error(e.getMessage(), e);
        }
        try {
            m = t.getClass().getMethod("setCommunicateStatus", String.class);
            if (m != null) {
                m.invoke(t, "0");
            }
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
        }
        try {
            m = t.getClass().getMethod("setRecommendFlag", String.class);
            if (m != null) {
                m.invoke(t, "0");
            }
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
        }
        try {
            m = t.getClass().getMethod("setRemoveFlag", String.class);
            if (m != null) {
                m.invoke(t, "0");
            }
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
        }
        try {
            m = t.getClass().getMethod("setScanNumber", Integer.class);
            if (m != null) {
                m.invoke(t, 0);
            }
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
        }
        try {
            m = t.getClass().getMethod("setConcernNumber", Integer.class);
            if (m != null) {
                m.invoke(t, 0);
            }
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
        }
        try {
            m = t.getClass().getMethod("setWhenCreate", Date.class);
            if (m != null) {
                m.invoke(t, new Date());
            }
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
        }
        try {
            m = t.getClass().getMethod("setWhoCreate", String.class);
            if (m != null) {
                m.invoke(t, cu.getUsername());
            }
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
        }
        try {
            m = t.getClass().getMethod("setWhenLastUpdate", Date.class);
            if (m != null) {
                m.invoke(t, new Date());
            }
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
        }
        try {
            m = t.getClass().getMethod("setWhoLastUpdate", String.class);
            if (m != null) {
                m.invoke(t, cu.getUsername());
            }
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
        }
    }
    
    public static <T> void updateCommon(T t, CurrentUser cu) throws ViewException {
    	Method m = null;
    	try {
        	m = t.getClass().getMethod("setWhenLastUpdate", Date.class);
            if (m != null) {
                m.invoke(t, new Date());
            }
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
        }
        try {
            m = t.getClass().getMethod("setWhoLastUpdate", String.class);
            if (m != null) {
                m.invoke(t, cu.getUsername());
            }
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
        }
    }
    
    public static <T> void setScanNum(T t) throws ViewException {
        try {
            Method m = t.getClass().getMethod("getScanNumber");
            if (m != null) {
                Integer value = (Integer) m.invoke(t);
                Method m1 = t.getClass().getMethod("setScanNumber", Integer.class);
                if (m1 != null) {
                	if(value == null){
                		m1.invoke(t, 1);
                	} else {
                		m1.invoke(t, value+1);
                	}
                }
            }
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
        }
    }
}
