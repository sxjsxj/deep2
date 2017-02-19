/**
 * Copyright (c) 2015,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:FareUtil_v1.3.0
 * Package Name:com.travelsky.fare.fareutil.commontools
 * File Name:CompareUtil.java
 * Date:2015-3-25 下午3:35:07
 * 
 */
package com.deep.two.util;

import java.util.Comparator;

 /**
 * ClassName: CompareUtil <br/>
 * Description: TODO <br/>
 * Date: 2015-3-25 下午3:35:07 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

public class CompareUtil {
    
    public static Comparator<Long> getLongComparator() {
        return new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                if (o1 > o2) {
                    return 1;
                } else if (o1 < o1) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
    }
}
