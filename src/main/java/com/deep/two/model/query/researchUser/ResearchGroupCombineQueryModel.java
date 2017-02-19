/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:com.deep.two.model.query
 * File Name:ResearchResearchGroupQueryModel.java
 * Date:2016-5-11 下午4:26:32
 * 
 */
package com.deep.two.model.query.researchUser;

import com.deep.two.model.query.QueryModel;
import com.deep.two.model.query.authority.UserQueryModel;

/**
 * ClassName: ResearchResearchGroupQueryModel <br/>
 * Description: TODO <br/>
 * Date: 2016-5-11 下午4:26:32 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

public class ResearchGroupCombineQueryModel extends QueryModel{
    private UserQueryModel userQueryModel = new UserQueryModel();
    private UniversityUserQueryModel universityUserQueryModel = new UniversityUserQueryModel();
    private OrganizationUserQueryModel organizationUserQueryModel = new OrganizationUserQueryModel();
    private ResearchGroupQueryModel researchGroupQueryModel = new ResearchGroupQueryModel();

    public ResearchGroupQueryModel getResearchGroupQueryModel() {
        return researchGroupQueryModel;
    }

    public void setResearchGroupQueryModel(ResearchGroupQueryModel researchGroupQueryModel) {
        this.researchGroupQueryModel = researchGroupQueryModel;
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
