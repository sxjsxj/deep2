/**
 * Copyright (c) 2015,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:FareUtil_v1.3.0
 * Package Name:com.travelsky.fare.fareutil.commontools
 * File Name:DoubleUtil.java
 * Date:2015-8-20 下午2:05:53
 * 
 */
package com.deep.two.util;

 /**
 * ClassName: DoubleUtil <br/>
 * Description: TODO <br/>
 * Date: 2015-8-20 下午2:05:53 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

public final class DoubleUtil {

    public static double parseDouble(Object obj) {
        if (obj == null || obj.toString().equals("")) {
            return 0d;
        }
        return Double.parseDouble(obj.toString());
    }
}
