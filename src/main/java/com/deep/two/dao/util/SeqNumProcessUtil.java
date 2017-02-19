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

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

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

public class SeqNumProcessUtil {

    public static <T> void setSeqNum(T t, String seqNum) throws ViewException {
        try {
            Method m = t.getClass().getMethod("setSeqNum", String.class);
            if (m != null) {
                m.invoke(t, seqNum);
            }
        } catch (Exception e) {
            ViewException tmp = new ViewException();
            tmp.initCause(e);
            throw tmp;
        }
    }
}
