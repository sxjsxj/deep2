/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:com.deep.two.dao
 * File Name:ResearchDAO.java
 * Date:2016-4-21 上午11:03:46
 * 
 */
package com.deep.two.service.researchUser.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.deep.two.dao.researchUser.ResearchGroupDAO;
import com.deep.two.orm.ResearchGroup;
import com.deep.two.service.AbstractService;
import com.deep.two.service.researchUser.ResearchGroupService;

 /**
 * ClassName: ResearchDAO <br/>
 * Description: TODO <br/>
 * Date: 2016-4-21 上午11:03:46 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

@Service("researchGroupService")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
public class ResearchGroupServiceImpl extends AbstractService<ResearchGroupDAO, ResearchGroup> implements ResearchGroupService{
    @Autowired
    private ResearchGroupDAO researchGroupDAO;
    
    @Value("${researchGroupFilePath}")
	private String researchGroupFilePath;

    @Override
    public ResearchGroupDAO getT() {
        return this.researchGroupDAO;
    }

	@Override
	public String getPath() {
		return researchGroupFilePath;
	}
}
