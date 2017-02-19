/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:com.deep.two.service
 * File Name:BusinessCheck.java
 * Date:2016-5-16 下午6:39:48
 * 
 */
package com.deep.two.business;

import com.deep.two.util.ViewException;

 /**
 * ClassName: BusinessCheck <br/>
 * Description: TODO <br/>
 * Date: 2016-5-16 下午6:39:48 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

public interface BusinessCheck {

    public void check() throws ViewException;
}
