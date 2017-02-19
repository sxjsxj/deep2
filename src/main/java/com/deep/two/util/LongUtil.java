/**
 * Copyright (c) 2015,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:FareUtil_v1.3.0
 * Package Name:com.travelsky.fare.fareutil.commontools
 * File Name:LongUtil.java
 * Date:2015-8-10 下午5:30:26
 * 
 */
package com.deep.two.util;

 /**
 * ClassName: LongUtil <br/>
 * Description: TODO <br/>
 * Date: 2015-8-10 下午5:30:26 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

public final class LongUtil {
    
    public static long parseLong(Object obj) {
        if (obj == null || obj.toString().equals("")) {
            return 0l;
        }
        return Long.parseLong(obj.toString());
    }

}
