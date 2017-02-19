/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:com.deep.two.model.query
 * File Name:UserAchievementQueryModel.java
 * Date:2016-5-11 下午4:31:34
 * 
 */
package com.deep.two.model.query.researchUser;

import com.deep.two.model.query.QueryModel;
import com.deep.two.model.query.authority.UserQueryModel;

/**
 * ClassName: UserAchievementQueryModel <br/>
 * Description: TODO <br/>
 * Date: 2016-5-11 下午4:31:34 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

public class AchievementCombineQueryModel extends QueryModel {
    private UserQueryModel userQueryModel = new UserQueryModel();
    private UniversityUserQueryModel universityUserQueryModel = new UniversityUserQueryModel();
    private OrganizationUserQueryModel organizationUserQueryModel = new OrganizationUserQueryModel();
    private ResearchGroupQueryModel researchGroupQueryModel = new ResearchGroupQueryModel();
    private AchievementQueryModel achievementQueryModel = new AchievementQueryModel();

    public ResearchGroupQueryModel getResearchGroupQueryModel() {
        return researchGroupQueryModel;
    }

    public void setResearchGroupQueryModel(ResearchGroupQueryModel researchGroupQueryModel) {
        this.researchGroupQueryModel = researchGroupQueryModel;
    }

    public AchievementQueryModel getAchievementQueryModel() {
        return achievementQueryModel;
    }

    public void setAchievementQueryModel(AchievementQueryModel achievementQueryModel) {
        this.achievementQueryModel = achievementQueryModel;
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
