package com.deep.two.model;

import com.deep.two.authority.model.UserModel;
import com.deep.two.orm.InvestorUser;

public class InvestorUserModel {
	private UserModel userModel;
	private InvestorUser investorUser;

	public UserModel getUserModel() {
		return this.userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public InvestorUser getInvestorUser() {
		return this.investorUser;
	}

	public void setInvestorUser(InvestorUser investorUser) {
		this.investorUser = investorUser;
	}

}
