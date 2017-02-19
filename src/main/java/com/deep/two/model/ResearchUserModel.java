package com.deep.two.model;

import com.deep.two.authority.model.UserModel;
import com.deep.two.orm.ResearchUser;

public class ResearchUserModel {
	private UserModel userModel;
	private ResearchUser researchUser;

	public UserModel getUserModel() {
		return this.userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public ResearchUser getResearchUser() {
		return this.researchUser;
	}

	public void setResearchUser(ResearchUser researchUser) {
		this.researchUser = researchUser;
	}

}
