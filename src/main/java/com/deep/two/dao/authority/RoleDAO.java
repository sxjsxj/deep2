/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:com.deep.two.dao
 * File Name:RoleDAO.java
 * Date:2016-4-21 上午11:09:03
 * 
 */
package com.deep.two.dao.authority;

import org.springframework.stereotype.Repository;
import com.deep.two.dao.AbstractDAO;
import com.deep.two.orm.Role;

 /**
 * ClassName: RoleDAO <br/>
 * Description: TODO <br/>
 * Date: 2016-4-21 上午11:09:03 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

@Repository("roleDAO")
public class RoleDAO extends AbstractDAO<Role> {

	@Override
	public Class<Role> getCurrentClass() {
		return Role.class;
	}
}