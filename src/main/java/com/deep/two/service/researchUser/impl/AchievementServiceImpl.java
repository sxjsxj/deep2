/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:com.deep.two.dao
 * File Name:AchievementDAO.java
 * Date:2016-4-21 上午11:04:01
 * 
 */
package com.deep.two.service.researchUser.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.deep.two.dao.researchUser.AchievementDAO;
import com.deep.two.orm.Achievement;
import com.deep.two.service.AbstractService;
import com.deep.two.service.researchUser.AchievementService;

 /**
 * ClassName: AchievementDAO <br/>
 * Description: TODO <br/>
 * Date: 2016-4-21 上午11:04:01 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */
@Service("achievementService")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
public class AchievementServiceImpl extends AbstractService<AchievementDAO, Achievement> implements AchievementService{
    @Autowired
    private AchievementDAO achievementDAO;
    
    @Value("${achievementFilePath}")
    private String achievementFilePath;

    @Override
    public AchievementDAO getT() {
        return this.achievementDAO;
    }

	@Override
	public String getPath() {
		return achievementFilePath;
	}
}
