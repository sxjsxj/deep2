/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:com.deep.two.dao
 * File Name:ResearchDAO.java
 * Date:2016-4-21 上午11:05:24
 * 
 */
package com.deep.two.service.researchUser.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.deep.two.dao.researchUser.ResearchUserDAO;
import com.deep.two.orm.ResearchUser;
import com.deep.two.service.AbstractService;
import com.deep.two.service.researchUser.ResearchUserService;

 /**
 * ClassName: ResearchDAO <br/>
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
@Service("researchUserService")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
public class ResearchUserServiceImpl extends AbstractService<ResearchUserDAO, ResearchUser> implements ResearchUserService {
    @Autowired
    private ResearchUserDAO ResearchUserDAO;
    
    @Value("${researchUserFilePath}")
    private String researchUserFilePath;

    @Override
    public ResearchUserDAO getT() {
        return this.ResearchUserDAO;
    }

	@Override
	public String getPath() {
		return researchUserFilePath;
	}
}
