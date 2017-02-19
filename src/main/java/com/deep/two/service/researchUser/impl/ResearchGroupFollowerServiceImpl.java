/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:com.deep.two.service.impl
 * File Name:ResearchGroupFollowerServiceImpl.java
 * Date:2016-4-28 下午8:18:43
 * 
 */
package com.deep.two.service.researchUser.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.deep.two.dao.researchUser.ResearchGroupFollowerDAO;
import com.deep.two.orm.ResearchGroupFollower;
import com.deep.two.service.AbstractService;
import com.deep.two.service.researchUser.ResearchGroupFollowerService;

 /**
 * ClassName: ResearchGroupFollowerServiceImpl <br/>
 * Description: TODO <br/>
 * Date: 2016-4-28 下午8:18:43 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

@Service("researchGroupFollowerService")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
public class ResearchGroupFollowerServiceImpl extends AbstractService<ResearchGroupFollowerDAO, ResearchGroupFollower> implements ResearchGroupFollowerService{
    @Autowired
    private ResearchGroupFollowerDAO researchGroupFollowerDAO;

    @Override
    public ResearchGroupFollowerDAO getT() {
        return this.researchGroupFollowerDAO;
    }

	@Override
	public String getPath() {
		// TODO Auto-generated method stub
		return null;
	}
}
