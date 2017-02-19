package com.deep.two.test.dao;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.deep.two.dao.authority.UserDAO;
import com.deep.two.dao.researchUser.AchievementDAO;
import com.deep.two.dao.researchUser.AchievementFollowerDAO;
import com.deep.two.dao.researchUser.ResearchGroupDAO;
import com.deep.two.dao.util.Pagination;
import com.deep.two.model.query.QueryModel;
import com.deep.two.model.query.authority.UserQueryModel;
import com.deep.two.model.query.researchUser.AchievementFollowerCombineQueryModel;
import com.deep.two.model.query.researchUser.AchievementFollowerIdQueryModel;
import com.deep.two.model.query.researchUser.AchievementFollowerQueryModel;
import com.deep.two.model.query.researchUser.AchievementQueryModel;
import com.deep.two.model.query.researchUser.OrganizationUserQueryModel;
import com.deep.two.model.query.researchUser.AchievementCombineQueryModel;
import com.deep.two.model.query.researchUser.ResearchGroupCombineQueryModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.model.result.researchUser.AchievementFollowerResultModel;
import com.deep.two.orm.Achievement;
import com.deep.two.orm.AchievementFollower;
import com.deep.two.orm.ResearchGroup;
import com.deep.two.orm.User;
import com.deep.two.util.ViewException;

/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:
 * File Name:UserDaoTest.java
 * Date:2016-4-22 下午5:41:05
 * 
 */

/**
 * ClassName: UserDaoTest <br/>
 * Description: TODO <br/>
 * Date: 2016-4-22 下午5:41:05 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */
// 指定测试用例的运行器 这里是指定了Junit4
@RunWith(SpringJUnit4ClassRunner.class)
// 指定Spring的配置文件
@ContextConfiguration({ "/deep2-context.xml" })
// 对所有的测试方法都使用事务，并在测试完成后回滚事务
@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional
public class AchievementDaoTest {
	@Autowired
	AchievementDAO achievementDAO;
	@Autowired
	AchievementFollowerDAO achievementFollowerDAO;

	@Test
	@Transactional
	//@Rollback(false)
	public void addTest() throws ViewException {
		Achievement achievement = new Achievement();
		ResearchGroup researchGroup = new ResearchGroup();
		researchGroup.setId("1");
		achievement.setResearchGroup(researchGroup);
		achievement.setSequenceNumber("2222");
		achievementDAO.add(achievement, null);
	}

	@Test
	public void queryList() {
		AchievementFollowerQueryModel model = new AchievementFollowerQueryModel();
		AchievementFollowerIdQueryModel aa = new AchievementFollowerIdQueryModel();
		aa.setUserId("0");
		model.setAchievementFollowerIdQueryModel(aa);

		Pagination pageInfo = new Pagination();
/*		QueryListReturnVo<AchievementFollower> tmp;
		try {
			tmp = achievementFollowerDAO.queryList(model, pageInfo, null);
			System.out.println(tmp.getQueryReturnList());
		} catch (ViewException e) {
			e.printStackTrace();
		}*/
		
		AchievementFollowerCombineQueryModel model2 = new AchievementFollowerCombineQueryModel();
		model2.setAchievementFollowerQueryModel(model);
		UserQueryModel um = new UserQueryModel();
		um.setId("111");
		model2.setUserQueryModel(um);
		model2.setAchievementQueryModel(new AchievementQueryModel());
		QueryListReturnVo<AchievementFollowerResultModel> tmp2;
		try {
			tmp2 = achievementFollowerDAO.combineQueryList(model2, pageInfo, null);
			System.out.println(tmp2);
		} catch (ViewException e) {
			e.printStackTrace();
		}
	}
}
