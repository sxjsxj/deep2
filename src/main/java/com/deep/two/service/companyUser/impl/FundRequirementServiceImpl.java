/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:com.deep.two.dao
 * File Name:FundRequirementDAO.java
 * Date:2016-4-21 上午11:06:04
 * 
 */
package com.deep.two.service.companyUser.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.deep.two.orm.FundRequirement;
import com.deep.two.service.AbstractService;
import com.deep.two.service.companyUser.FundRequirementService;
import com.deep.two.dao.companyUser.FundRequirementDAO;
 /**
 * ClassName: FundRequirementDAO <br/>
 * Description: TODO <br/>
 * Date: 2016-4-21 上午11:06:04 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

@Service("fundRequirementService")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
public class FundRequirementServiceImpl extends AbstractService<FundRequirementDAO, FundRequirement> implements FundRequirementService{
    
	@Autowired
    private FundRequirementDAO FundRequirementDAO;
	
	@Value("${fundRequirementFilePath}")
    private String fundRequirementFilePath;

    @Override
    public FundRequirementDAO getT() {
        return this.FundRequirementDAO;
    }

	@Override
	public String getPath() {
		return fundRequirementFilePath;
	}

}
