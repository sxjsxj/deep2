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
package com.deep.two.model.query.investorUser;

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

public class InvestorUserCombineQueryModel extends QueryModel {
	private UserQueryModel userQueryModel = new UserQueryModel();
	private InvestorUserQueryModel investorUserQueryModel = new InvestorUserQueryModel();

	public InvestorUserCombineQueryModel(UserQueryModel userQueryModel, InvestorUserQueryModel investorUserQueryModel) {
		super();
		this.userQueryModel = userQueryModel;
		this.investorUserQueryModel = investorUserQueryModel;
	}

	public InvestorUserCombineQueryModel() {
		super();
	}

	public UserQueryModel getUserQueryModel() {
		return this.userQueryModel;
	}

	public void setUserQueryModel(UserQueryModel userQueryModel) {
		this.userQueryModel = userQueryModel;
	}

	public InvestorUserQueryModel getInvestorUserQueryModel() {
		return this.investorUserQueryModel;
	}

	public void setInvestorUserQueryModel(InvestorUserQueryModel investorUserQueryModel) {
		this.investorUserQueryModel = investorUserQueryModel;
	}

}
