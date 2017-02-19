/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:com.deep.two.model.query
 * File Name:CompanyRequirementQueryModel.java
 * Date:2016-5-11 下午4:15:54
 * 
 */
package com.deep.two.model.query.companyUser;

import com.deep.two.model.query.QueryModel;
import com.deep.two.model.query.authority.UserQueryModel;

/**
 * ClassName: CompanyRequirementQueryModel <br/>
 * Description: TODO <br/>
 * Date: 2016-5-11 下午4:15:54 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

public class TechRequirementCombineQueryModel extends QueryModel {
    private UserQueryModel userQueryModel = new UserQueryModel();
    private CompanyUserQueryModel companyUserQueryModel = new CompanyUserQueryModel();
    private TechRequirementQueryModel techRequirementQueryModel = new TechRequirementQueryModel();

    public UserQueryModel getUserQueryModel() {
        return userQueryModel;
    }

    public void setUserQueryModel(UserQueryModel userQueryModel) {
        this.userQueryModel = userQueryModel;
    }

    public CompanyUserQueryModel getCompanyUserQueryModel() {
        return companyUserQueryModel;
    }

    public void setCompanyQueryModel(CompanyUserQueryModel companyQueryModel) {
        this.companyUserQueryModel = companyQueryModel;
    }

	public TechRequirementQueryModel getTechRequirementQueryModel() {
		return this.techRequirementQueryModel;
	}

	public void setTechRequirementQueryModel(
			TechRequirementQueryModel techRequirementQueryModel) {
		this.techRequirementQueryModel = techRequirementQueryModel;
	}
}
