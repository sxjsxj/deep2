/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:com.deep.two.service.impl
 * File Name:AchievementFollowServiceImpl.java
 * Date:2016-4-28 下午8:14:59
 * 
 */
package com.deep.two.service.researchUser.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.deep.two.dao.researchUser.AchievementFollowerDAO;
import com.deep.two.orm.AchievementFollower;
import com.deep.two.service.AbstractService;
import com.deep.two.service.researchUser.AchievementFollowerService;

 /**
 * ClassName: AchievementFollowServiceImpl <br/>
 * Description: TODO <br/>
 * Date: 2016-4-28 下午8:14:59 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

@Service("achievementFollowerService")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
public class AchievementFollowerServiceImpl extends AbstractService<AchievementFollowerDAO, AchievementFollower> implements AchievementFollowerService{
    @Autowired
    private AchievementFollowerDAO achievementFollowerDAO;

    @Override
    public AchievementFollowerDAO getT() {
        return this.achievementFollowerDAO;
    }

	@Override
	public String getPath() {
		// TODO Auto-generated method stub
		return null;
	}

}
