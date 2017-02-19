package com.deep.two.model.query.investorUser;

import com.deep.two.model.query.QueryModel;
import com.deep.two.model.query.authority.UserQueryModel;

public class InvestorUserFollowerCombineQueryModel extends QueryModel {
	private UserQueryModel userQueryModel = new UserQueryModel();
	private InvestorUserQueryModel investorUserQueryModel = new InvestorUserQueryModel();
	private InvestorUserFollowerQueryModel investorUserFollowerQueryModel = new InvestorUserFollowerQueryModel();
	public UserQueryModel getUserQueryModel() {
		return userQueryModel;
	}
	public void setUserQueryModel(UserQueryModel userQueryModel) {
		this.userQueryModel = userQueryModel;
	}
	public InvestorUserQueryModel getInvestorUserQueryModel() {
		return investorUserQueryModel;
	}
	public void setInvestorUserQueryModel(InvestorUserQueryModel investorUserQueryModel) {
		this.investorUserQueryModel = investorUserQueryModel;
	}
	public InvestorUserFollowerQueryModel getInvestorUserFollowerQueryModel() {
		return investorUserFollowerQueryModel;
	}
	public void setInvestorUserFollowerQueryModel(InvestorUserFollowerQueryModel investorUserFollowerQueryModel) {
		this.investorUserFollowerQueryModel = investorUserFollowerQueryModel;
	}

}
