package com.deep.two.model.query.researchUser;

import com.deep.two.model.query.QueryModel;
import com.deep.two.model.query.authority.UserQueryModel;

public class ResearchUserQueryModel extends QueryModel {
    private UserQueryModel userQueryModel = new UserQueryModel();
    private UniversityUserQueryModel universityUserQueryModel = new UniversityUserQueryModel();
    private OrganizationUserQueryModel organizationUserQueryModel = new OrganizationUserQueryModel();

    public ResearchUserQueryModel(UserQueryModel userQueryModel, UniversityUserQueryModel universityUserQueryModel,
			OrganizationUserQueryModel organizationUserQueryModel) {
		super();
		this.userQueryModel = userQueryModel;
		this.universityUserQueryModel = universityUserQueryModel;
		this.organizationUserQueryModel = organizationUserQueryModel;
	}

	public ResearchUserQueryModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserQueryModel getUserQueryModel() {
        return userQueryModel;
    }

    public void setUserQueryModel(UserQueryModel userQueryModel) {
        this.userQueryModel = userQueryModel;
    }

    public UniversityUserQueryModel getUniversityUserQueryModel() {
        return universityUserQueryModel;
    }

    public void setUniversityUserQueryModel(UniversityUserQueryModel universityUserQueryModel) {
        this.universityUserQueryModel = universityUserQueryModel;
    }

    public OrganizationUserQueryModel getOrganizationUserQueryModel() {
        return organizationUserQueryModel;
    }

    public void setOrganizationUserQueryModel(OrganizationUserQueryModel organizationUserQueryModel) {
        this.organizationUserQueryModel = organizationUserQueryModel;
    }
}
