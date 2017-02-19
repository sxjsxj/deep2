package com.deep.two.model;

import com.deep.two.authority.model.UserModel;
import com.deep.two.orm.CompanyUser;

public class CompanyUserModel {
	private UserModel userModel;
	private CompanyUser companyUser = new CompanyUser();

	public UserModel getUserModel() {
		return this.userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public CompanyUser getCompanyUser() {
		return this.companyUser;
	}

	public void setCompanyUser(CompanyUser companyUser) {
		this.companyUser = companyUser;
	}

}
