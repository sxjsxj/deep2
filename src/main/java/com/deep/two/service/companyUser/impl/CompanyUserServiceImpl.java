/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:com.deep.two.dao
 * File Name:CompanyDAO.java
 * Date:2016-4-21 上午11:05:24
 * 
 */
package com.deep.two.service.companyUser.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.deep.two.dao.companyUser.CompanyUserDAO;
import com.deep.two.orm.CompanyUser;
import com.deep.two.service.AbstractService;
import com.deep.two.service.companyUser.CompanyUserService;

 /**
 * ClassName: CompanyDAO <br/>
 * Description: TODO <br/>
 * Date: 2016-4-21 上午11:05:24 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */
@Service("companyUserService")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
public class CompanyUserServiceImpl extends AbstractService<CompanyUserDAO, CompanyUser> implements CompanyUserService{
    @Autowired
    private CompanyUserDAO companyUserDAO;
    
    @Value("${companyUserFilePath}")
    private String companyUserFilePath;

    @Override
    public CompanyUserDAO getT() {
        return this.companyUserDAO;
    }

	@Override
	public String getPath() {
		return companyUserFilePath;
	}
}
