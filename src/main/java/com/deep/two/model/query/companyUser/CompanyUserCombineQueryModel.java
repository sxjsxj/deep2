/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:com.deep.two.model.query
 * File Name:CompanyQueryVO.java
 * Date:2016-5-11 下午2:48:08
 * 
 */
package com.deep.two.model.query.companyUser;

import com.deep.two.model.query.QueryModel;
import com.deep.two.model.query.authority.UserQueryModel;

/**
 * ClassName: CompanyQueryVO <br/>
 * Description: TODO <br/>
 * Date: 2016-5-11 下午2:48:08 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

public class CompanyUserCombineQueryModel extends QueryModel {
    private UserQueryModel userQueryModel = new UserQueryModel();
	private CompanyUserQueryModel companyUserQueryModel = new CompanyUserQueryModel();
	
	public CompanyUserCombineQueryModel() {
		super();
	}

	public CompanyUserCombineQueryModel(UserQueryModel userQueryModel, CompanyUserQueryModel companyUserQueryModel) {
		super();
		this.userQueryModel = userQueryModel;
		this.companyUserQueryModel = companyUserQueryModel;
	}

    public UserQueryModel getUserQueryModel() {
        return userQueryModel;
    }

    public void setUserQueryModel(UserQueryModel userQueryModel) {
        this.userQueryModel = userQueryModel;
    }

    public CompanyUserQueryModel getCompanyUserQueryModel() {
        return companyUserQueryModel;
    }

    public void setCompanyUserQueryModel(CompanyUserQueryModel companyUserQueryModel) {
        this.companyUserQueryModel = companyUserQueryModel;
    }

}
