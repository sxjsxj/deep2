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
import com.deep.two.util.ViewException;

public class RecommendFlagUtil {

    /**
     * 设置推荐标识
     * @param t
     * @param recommendFlag
     * @throws ViewException
     */
    public static <T> void setRecommendFlag(T t, String recommendFlag) throws ViewException {
        try {
            Method m = t.getClass().getMethod("setRecommendFlag", String.class);
            if (m != null) {
                m.invoke(t, recommendFlag);
            }
        } catch (Exception e) {
            ViewException tmp = new ViewException();
            tmp.initCause(e);
            throw tmp;
        }
    }
}
