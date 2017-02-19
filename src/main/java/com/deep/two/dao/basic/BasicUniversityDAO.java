/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:com.deep.two.dao
 * File Name:UniversityDAO.java
 * Date:2016-4-21 上午10:58:48
 * 
 */
package com.deep.two.dao.basic;

import org.springframework.stereotype.Repository;
import com.deep.two.dao.AbstractDAO;
import com.deep.two.orm.BasicUniversity;

 /**
 * ClassName: UniversityDAO <br/>
 * Description: TODO <br/>
 * Date: 2016-4-21 上午10:58:48 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

@Repository("UniversityDetailDAO")
public class BasicUniversityDAO extends AbstractDAO<BasicUniversity> {

	@Override
	public Class<BasicUniversity> getCurrentClass() {
		return BasicUniversity.class;
	}
}