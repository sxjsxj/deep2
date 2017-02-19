/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:com.deep.two.test.dao
 * File Name:ResearchGroupFollowerDAOTest.java
 * Date:2016-5-6 下午4:40:02
 * 
 */
package com.deep.two.test.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.deep.two.dao.companyUser.CompanyUserDAO;
import com.deep.two.dao.researchUser.ResearchGroupFollowerDAO;
import com.deep.two.dao.util.Pagination;
import com.deep.two.model.query.QueryModel;
import com.deep.two.model.query.authority.UserQueryModel;
import com.deep.two.model.query.companyUser.CompanyUserQueryModel;
import com.deep.two.model.query.researchUser.ResearchGroupFollowerQueryModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.orm.ResearchGroup;
import com.deep.two.orm.ResearchGroupFollower;
import com.deep.two.util.ViewException;

 /**
 * ClassName: ResearchGroupFollowerDAOTest <br/>
 * Description: TODO <br/>
 * Date: 2016-5-6 下午4:40:02 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */
//指定测试用例的运行器 这里是指定了Junit4
@RunWith(SpringJUnit4ClassRunner.class)
//指定Spring的配置文件
@ContextConfiguration({ "/deep2-context.xml" })
//对所有的测试方法都使用事务，并在测试完成后回滚事务
@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional
public class ResearchGroupFollowerDAOTest {
    @Autowired
    ResearchGroupFollowerDAO researchGroupFollowerDAO;

    @Test
    public void addTest() throws ViewException {
        ResearchGroupFollower t = new ResearchGroupFollower();
        researchGroupFollowerDAO.add(t, null);
    }
    
    @Test
    public void queryListTest() throws ViewException {
    	ResearchGroupFollowerQueryModel model = new ResearchGroupFollowerQueryModel();
        UserQueryModel um = new UserQueryModel();
        um.setId("1");
        model.setFollowerType("1");
        QueryListReturnVo<ResearchGroupFollower> aa = researchGroupFollowerDAO.queryList(model, null, null);
        System.out.println(aa);
    }
}
