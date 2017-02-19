/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:com.deep.two.dao
 * File Name:ResourceDAO.java
 * Date:2016-4-21 上午11:09:14
 * 
 */
package com.deep.two.dao.authority;

import org.springframework.stereotype.Repository;
import com.deep.two.dao.AbstractDAO;
import com.deep.two.orm.Resource;

 /**
 * ClassName: ResourceDAO <br/>
 * Description: TODO <br/>
 * Date: 2016-4-21 上午11:09:14 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

@Repository("resourceDAO")
public class ResourceDAO extends AbstractDAO<Resource> {
	@Override
	public Class<Resource> getCurrentClass() {
		return Resource.class;
	}
}