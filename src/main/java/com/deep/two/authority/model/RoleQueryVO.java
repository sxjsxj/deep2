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

public class RoleQueryVO {
    private String roleName;
    private String roleNameOperator = Operator.LK;
    private String roleDesc;
    private String roleDescOperator = Operator.LK;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public String getRoleDescOperator() {
        return roleDescOperator;
    }

    public void setRoleDescOperator(String roleDescOperator) {
        this.roleDescOperator = roleDescOperator;
    }

    public String getRoleNameOperator() {
        return roleNameOperator;
    }

    public void setRoleNameOperator(String roleNameOperator) {
        this.roleNameOperator = roleNameOperator;
    }

}
