/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:com.deep.two.dao
 * File Name:UserDAO.java
 * Date:2016-4-21 上午11:08:53
 * 
 */
package com.deep.two.dao.authority;

import org.springframework.stereotype.Repository;
import com.deep.two.dao.AbstractDAO;
import com.deep.two.orm.User;

 /**
 * ClassName: UserDAO <br/>
 * Description: TODO <br/>
 * Date: 2016-4-21 上午11:08:53 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

@Repository("userDAO")
public class UserDAO extends AbstractDAO<User> {
	
	@Override
	public Class<User> getCurrentClass() {
		return User.class;
	}
}
