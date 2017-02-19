/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:com.deep.two.service.impl
 * File Name:RequirementFollowerServiceImpl.java
 * Date:2016-4-28 下午8:17:58
 * 
 */
package com.deep.two.service.companyUser.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.deep.two.dao.companyUser.TechRequirementFollowerDAO;
import com.deep.two.orm.TechRequirementFollower;
import com.deep.two.service.AbstractService;
import com.deep.two.service.companyUser.TechRequirementFollowerService;

 /**
 * ClassName: RequirementFollowerServiceImpl <br/>
 * Description: TODO <br/>
 * Date: 2016-4-28 下午8:17:58 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

@Service("techRequirementFollowerService")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
public class TechRequirementFollowerServiceImpl extends AbstractService<TechRequirementFollowerDAO, TechRequirementFollower> implements TechRequirementFollowerService{
    @Autowired
    private TechRequirementFollowerDAO requirementFollowerDAO;

    @Override
    public TechRequirementFollowerDAO getT() {
        return this.requirementFollowerDAO;
    }

	@Override
	public String getPath() {
		// TODO Auto-generated method stub
		return null;
	}

}
