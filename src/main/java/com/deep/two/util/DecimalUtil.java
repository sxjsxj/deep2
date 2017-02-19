/**
 * Copyright (c) 2014,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:FareUtil
 * Package Name:com.travelsky.fare.fareutil.commontools
 * File Name:DecimalUtil.java
 * Date:2014-12-23 下午2:16:33
 * 
 */
package com.deep.two.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * ClassName: DecimalUtil <br/>
 * Description: 数字处理工具类 <br/>
 * Date: 2014-12-23 下午2:16:33 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

public final class DecimalUtil {
    
    /**
     * Creates a new instance of DecimalUtil.<br/>
     * Description: 私有构造方法 <br/>
     */
    private DecimalUtil() {
        
    }

    /**
     * numToDecimal: 对一个数字进行四舍五入，保留scale位的小数<br/>
     * 
     * @param num
     *            需要四舍五入的数字
     * @param scale
     *            保留的小数位数
     * @return 四舍五入且保留scale位小数的值 <br/>
     */
    public static double numToDecimal(double num, int scale) {
        BigDecimal bd = new BigDecimal(num);
        bd = bd.setScale(scale, RoundingMode.HALF_UP);

        return bd.doubleValue();
    }
}
