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


public class UserQueryVO {
    private String userName;
    private String userNameOperator = Operator.LK;

    private String userDesc;
    private String userDescOperator = Operator.LK;
    
    private String userDept;
    private String userDeptOperator = Operator.IN;
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNameOperator() {
        return userNameOperator;
    }

    public void setUserNameOperator(String userNameOperator) {
        this.userNameOperator = userNameOperator;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    public String getUserDescOperator() {
        return userDescOperator;
    }

    public void setUserDescOperator(String userDescOperator) {
        this.userDescOperator = userDescOperator;
    }

    public String getUserDept() {
        return userDept;
    }

    public void setUserDept(String userDept) {
        this.userDept = userDept;
    }

    public String getUserDeptOperator() {
        return userDeptOperator;
    }

    public void setUserDeptOperator(String userDeptOperator) {
        this.userDeptOperator = userDeptOperator;
    }
}
