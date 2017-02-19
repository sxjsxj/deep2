/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:com.deep.two.test
 * File Name:UserServiceImplTest.java
 * Date:2016-4-28 下午5:27:19
 * 
 */
package com.deep.two.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import com.deep.two.authority.model.UserModel;
import com.deep.two.dao.util.Pagination;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.service.authority.UserService;
import com.deep.two.test.BaseTest;
import com.deep.two.util.ViewException;

/**
 * ClassName: UserServiceImplTest <br/>
 * Description: TODO <br/>
 * Date: 2016-4-28 下午5:27:19 <br/>
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
public class UserServiceImplTest extends BaseTest{

    @Autowired
    //@Qualifier("userServiceImpl")
    UserService userService;

    @Test
    public void addTest() throws ViewException {
        //model.setRemark("aaaaa");
        Pagination pag = new Pagination();
        pag.setCurrentPage(2);
        pag.setMaxRecordPerPage(1);
        
		QueryListReturnVo<UserModel> s = userService.query(this.getUserQueryModel(), pag );
        System.out.println(s.getQueryReturnList());
    }
}
