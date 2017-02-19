/**
 * Copyright (c) 2015,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:TrafficWebUserService
 * Package Name:com.travelsky.fare.service.authority.checker
 * File Name:UserNameUniqueChecker.java
 * Date:2015-7-10 下午2:59:48
 * 
 */
package com.deep.two.authority.checker;

import java.util.ArrayList;
import java.util.List;

import com.deep.two.authority.model.UserModel;
import com.deep.two.business.BusinessCheck;
import com.deep.two.dao.util.CriterionUnit;
import com.deep.two.dao.util.DaoUtil;
import com.deep.two.dao.util.Operator;
import com.deep.two.orm.User;
import com.deep.two.util.StringUtil;
import com.deep.two.util.ViewException;

 /**
 * ClassName: UserNameUniqueChecker <br/>
 * Description: TODO <br/>
 * Date: 2015-7-10 下午2:59:48 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

public class UserUniqueChecker implements BusinessCheck {
    private DaoUtil daoUtil;
    private UserModel model;
    
    public UserUniqueChecker(UserModel model, DaoUtil daoUtil) {
        this.model = model;
        this.daoUtil = daoUtil;
    }

    @Override
    public void check() throws ViewException {
    	String id = model.getId();
        List<CriterionUnit> cuList1 = new ArrayList<CriterionUnit>();
        List<CriterionUnit> cuList2 = new ArrayList<CriterionUnit>();
        if (!StringUtil.isEmpty(id)) {
        	cuList1.add(new CriterionUnit("id", Operator.NE, model.getId()));
        	cuList2.add(new CriterionUnit("id", Operator.NE, model.getId()));
        }
        cuList1.add(new CriterionUnit("email", model.getEmail()));
        int count = daoUtil.queryCount(cuList1, User.class);
        if (count > 0) {
        	ViewException ve = new ViewException("该邮箱已被使用，请更换其它邮箱.");
            throw ve;
        }
        
        cuList2.add(new CriterionUnit("telno", model.getTelno()));
        int telcount = daoUtil.queryCount(cuList2, User.class);
        if (telcount > 0) {
        	ViewException ve = new ViewException("该手机号已被使用，请更换其它手机号.");
            throw ve;
        }
    }
}
