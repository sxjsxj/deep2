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
package com.deep.two.model.query.researchUser;

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

public class AchievementFollowerCombineQueryModel extends QueryModel {
    private UserQueryModel userQueryModel = new UserQueryModel();
    private UniversityUserQueryModel universityUserQueryModel = new UniversityUserQueryModel();
    private OrganizationUserQueryModel organizationUserQueryModel = new OrganizationUserQueryModel();
    private ResearchGroupQueryModel researchGroupQueryModel = new ResearchGroupQueryModel();
    private AchievementQueryModel achievementQueryModel = new AchievementQueryModel();
    private AchievementFollowerQueryModel achievementFollowerQueryModel = new AchievementFollowerQueryModel();

    public UserQueryModel getUserQueryModel() {
        return userQueryModel;
    }

    public void setUserQueryModel(UserQueryModel userQueryModel) {
        this.userQueryModel = userQueryModel;
    }

    public AchievementQueryModel getAchievementQueryModel() {
        return achievementQueryModel;
    }

    public void setAchievementQueryModel(AchievementQueryModel achievementQueryModel) {
        this.achievementQueryModel = achievementQueryModel;
    }

    public AchievementFollowerQueryModel getAchievementFollowerQueryModel() {
        return achievementFollowerQueryModel;
    }

    public void setAchievementFollowerQueryModel(AchievementFollowerQueryModel achievementFollowerQueryModel) {
        this.achievementFollowerQueryModel = achievementFollowerQueryModel;
    }

	public UniversityUserQueryModel getUniversityUserQueryModel() {
		return this.universityUserQueryModel;
	}

	public void setUniversityUserQueryModel(
			UniversityUserQueryModel universityUserQueryModel) {
		this.universityUserQueryModel = universityUserQueryModel;
	}

	public OrganizationUserQueryModel getOrganizationUserQueryModel() {
		return this.organizationUserQueryModel;
	}

	public void setOrganizationUserQueryModel(
			OrganizationUserQueryModel organizationUserQueryModel) {
		this.organizationUserQueryModel = organizationUserQueryModel;
	}

	public ResearchGroupQueryModel getResearchGroupQueryModel() {
		return this.researchGroupQueryModel;
	}

	public void setResearchGroupQueryModel(
			ResearchGroupQueryModel researchGroupQueryModel) {
		this.researchGroupQueryModel = researchGroupQueryModel;
	}

}
