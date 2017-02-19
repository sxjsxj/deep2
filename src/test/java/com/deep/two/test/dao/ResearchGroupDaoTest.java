package com.deep.two.test.dao;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.deep.two.dao.authority.UserDAO;
import com.deep.two.dao.researchUser.ResearchGroupDAO;
import com.deep.two.dao.util.Pagination;
import com.deep.two.model.query.authority.UserQueryModel;
import com.deep.two.model.query.researchUser.OrganizationUserQueryModel;
import com.deep.two.model.query.researchUser.ResearchGroupCombineQueryModel;
import com.deep.two.model.result.QueryListReturnVo;
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
public class ResearchGroupDaoTest {
	@Autowired
	ResearchGroupDAO researchGroupDAO;

	@Test
	@Transactional
	public void addTest() throws ViewException {
		ResearchGroup researchGroup = new ResearchGroup();
		researchGroup.setResearchUser(UserTest.getResearchUser());
		researchGroupDAO.add(researchGroup, null);
	}

	@Test
	public void queryList() throws ViewException {
		ResearchGroupCombineQueryModel model = new ResearchGroupCombineQueryModel();
		UserQueryModel um = new UserQueryModel();
		um.setId("1");
		model.setUserQueryModel(um);

		OrganizationUserQueryModel oo = new OrganizationUserQueryModel();
		oo.setId("1");
		model.setOrganizationUserQueryModel(oo);
		Pagination pageInfo = new Pagination();
		QueryListReturnVo<ResearchGroup> tmp = researchGroupDAO.queryList(
				model, pageInfo, null);
		System.out.println(tmp.getQueryReturnList().get(0).getResearchUser());
	}
}
