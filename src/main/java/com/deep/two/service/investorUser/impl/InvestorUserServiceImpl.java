/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:com.deep.two.dao
 * File Name:InvestorDAO.java
 * Date:2016-4-21 上午11:05:46
 * 
 */
package com.deep.two.service.investorUser.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.deep.two.dao.investorUser.InvestorUserDAO;
import com.deep.two.orm.InvestorUser;
import com.deep.two.service.AbstractService;
import com.deep.two.service.investorUser.InvestorUserService;

 /**
 * ClassName: InvestorDAO <br/>
 * Description: TODO <br/>
 * Date: 2016-4-21 上午11:05:46 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

@Service("investorUserService")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
public class InvestorUserServiceImpl extends AbstractService<InvestorUserDAO, InvestorUser> implements InvestorUserService{
    @Autowired
    private InvestorUserDAO investorUserDAO;
    
    @Value("${investorUserFilePath}")
    private String investorUserFilePath;
    

    @Override
    public InvestorUserDAO getT() {
        return this.investorUserDAO;
    }

	@Override
	public String getPath() {
		return investorUserFilePath;
	}
}
