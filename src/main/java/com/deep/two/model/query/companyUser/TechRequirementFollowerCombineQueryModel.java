/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:com.deep.two.model.query
 * File Name:FollowerResearchGroupQueryModel.java
 * Date:2016-5-11 下午4:48:55
 * 
 */
package com.deep.two.model.query.companyUser;

import com.deep.two.model.query.QueryModel;
import com.deep.two.model.query.authority.UserQueryModel;

/**
 * ClassName: FollowerResearchGroupQueryModel <br/>
 * Description: TODO <br/>
 * Date: 2016-5-11 下午4:48:55 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

public class TechRequirementFollowerCombineQueryModel extends QueryModel{
    private UserQueryModel userQueryModel = new UserQueryModel();
    private CompanyUserQueryModel companyUserQueryModel = new CompanyUserQueryModel();
    private TechRequirementQueryModel techRequirementQueryModel = new TechRequirementQueryModel();
    private TechRequirementFollowerQueryModel techRequirementFollowerQueryModel = new TechRequirementFollowerQueryModel();

    public UserQueryModel getUserQueryModel() {
        return userQueryModel;
    }

    public void setUserQueryModel(UserQueryModel userQueryModel) {
        this.userQueryModel = userQueryModel;
    }

	public TechRequirementQueryModel getTechRequirementQueryModel() {
		return techRequirementQueryModel;
	}

	public void setTechRequirementQueryModel(TechRequirementQueryModel techRequirementQueryModel) {
		this.techRequirementQueryModel = techRequirementQueryModel;
	}

	public TechRequirementFollowerQueryModel getTechRequirementFollowerQueryModel() {
		return techRequirementFollowerQueryModel;
	}

	public void setTechRequirementFollowerQueryModel(TechRequirementFollowerQueryModel techRequirementFollowerQueryModel) {
		this.techRequirementFollowerQueryModel = techRequirementFollowerQueryModel;
	}

	public CompanyUserQueryModel getCompanyUserQueryModel() {
		return companyUserQueryModel;
	}

	public void setCompanyUserQueryModel(CompanyUserQueryModel companyUserQueryModel) {
		this.companyUserQueryModel = companyUserQueryModel;
	}
}
