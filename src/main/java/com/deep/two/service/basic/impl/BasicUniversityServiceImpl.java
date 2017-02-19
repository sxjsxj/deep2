/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:com.deep.two.dao
 * File Name:UniversityDAO.java
 * Date:2016-4-21 上午10:58:48
 * 
 */
package com.deep.two.service.basic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.deep.two.dao.basic.BasicUniversityDAO;
import com.deep.two.orm.BasicUniversity;
import com.deep.two.service.AbstractService;
import com.deep.two.service.basic.BasicUniversityService;

 /**
 * ClassName: UniversityDAO <br/>
 * Description: TODO <br/>
 * Date: 2016-4-21 上午10:58:48 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
public class BasicUniversityServiceImpl extends AbstractService<BasicUniversityDAO, BasicUniversity> implements BasicUniversityService{
    @Autowired
    private BasicUniversityDAO basicAreaDAO;

    @Override
    public BasicUniversityDAO getT() {
        return this.basicAreaDAO;
    }

	@Override
	public String getPath() {
		return null;
	}
}