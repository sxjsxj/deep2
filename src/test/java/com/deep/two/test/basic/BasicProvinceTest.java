package com.deep.two.test.basic;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.deep.two.controller.basic.BasicProvinceAreaController;
import com.deep.two.controller.basic.BasicProvinceController;

//指定测试用例的运行器 这里是指定了Junit4
@RunWith(SpringJUnit4ClassRunner.class)
//指定Spring的配置文件
@ContextConfiguration({ "/deep2-context.xml","/deep2-servlet.xml" })
//对所有的测试方法都使用事务，并在测试完成后回滚事务
@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional
public class BasicProvinceTest {
	
	@Autowired
	private BasicProvinceController cl;
	
	@Test
	public void test() throws Exception {
		System.out.println(cl.queryProvinceCity());
		System.out.println(cl.queryCityCounty());
	}

}
