/**
 * Copyright (c) 2015,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:TrafficWebAuthorityService
 * Package Name:com.travelsky.fare.service.authority.model
 * File Name:UserQueryVO.java
 * Date:2015-7-3 下午4:32:28
 * 
 */
package com.deep.two.authority.model;

import com.deep.two.dao.util.Operator;


/**
 * ClassName: UserQueryVO <br/>
 * Description: TODO <br/>
 * Date: 2015-7-3 下午4:32:28 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

public class ResourceQueryVO {
    private String resourceName;
    private String resourceNameOperator = Operator.LK;
    private String resourceDesc;
    private String resourceDescOperator = Operator.LK;

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceDesc() {
        return resourceDesc;
    }

    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc;
    }

    public String getResourceDescOperator() {
        return resourceDescOperator;
    }

    public void setResourceDescOperator(String resourceDescOperator) {
        this.resourceDescOperator = resourceDescOperator;
    }

    public String getResourceNameOperator() {
        return resourceNameOperator;
    }

    public void setResourceNameOperator(String resourceNameOperator) {
        this.resourceNameOperator = resourceNameOperator;
    }

}
