/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:com.deep.two.dao
 * File Name:ResearchUserDAO.java
 * Date:2016-4-21 上午11:05:24
 * 
 */
package com.deep.two.dao.researchUser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;

import com.deep.two.authority.model.CurrentUser;
import com.deep.two.authority.model.UserModel;
import com.deep.two.dao.AbstractDAO;
import com.deep.two.dao.util.CriteriaUtil;
import com.deep.two.dao.util.CriterionUnit;
import com.deep.two.dao.util.CriterionUtil;
import com.deep.two.dao.util.DaoUtil;
import com.deep.two.dao.util.OrderUnit;
import com.deep.two.dao.util.Pagination;
import com.deep.two.dao.util.StatusProcessUtil;
import com.deep.two.model.ApproveModel;
import com.deep.two.model.query.QueryModel;
import com.deep.two.model.query.researchUser.ResearchGroupFollowerCombineQueryModel;
import com.deep.two.model.query.researchUser.ResearchUserQueryModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.model.result.ResultModel;
import com.deep.two.model.result.companyUser.CompanyUserResultModel;
import com.deep.two.model.result.researchUser.ResearchUserResultModel;
import com.deep.two.orm.CompanyUser;
import com.deep.two.orm.ResearchUser;
import com.deep.two.util.CopyUtil;
import com.deep.two.util.ViewException;

 /**
 * ClassName: ResearchUserDAO <br/>
 * Description: TODO <br/>
 * Date: 2016-4-21 上午11:05:24 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

@Repository("ResearchUserDAO")
public class ResearchUserDAO extends AbstractDAO<ResearchUser> {
	@Override
    public ResultModel getDDetail(String id, CurrentUser user) throws ViewException {
	   ResearchUser model = this.getDetail(id, user);
	   ResearchUserResultModel crm = CopyUtil.copyProperty(model, ResearchUserResultModel.class);
	   UserModel um = CopyUtil.copyProperty(model.getUser(), UserModel.class);
	   crm.setUserModel(um);
	   return crm;
    }
	
	@Override
    public QueryListReturnVo<ResearchUserResultModel> combineQueryList(QueryModel model2, Pagination pageInfo, CurrentUser user) throws ViewException {
		if(model2 == null) {
    		model2 = new ResearchUserQueryModel();
    	}
		ResearchUserQueryModel model = (ResearchUserQueryModel)model2;
    	Criteria criteria = getCriteria(model);
        
        List<OrderUnit> orderList = new ArrayList<OrderUnit>();
        List<ResearchUser> records = this.daoUtil.queryList(criteria, orderList, pageInfo);
        List<ResearchUserResultModel> list = new ArrayList<ResearchUserResultModel>();
        for(ResearchUser ru : records) {
        	ResearchUserResultModel curm = CopyUtil.copyProperty(ru, ResearchUserResultModel.class);
        	UserModel um = CopyUtil.copyProperty(ru.getUser(), UserModel.class);
        	curm.setUserModel(um);
        	list.add(curm);
        }
        // 调用方法查询sum Record
        if (pageInfo != null) {
            pageInfo.setSumRecord(this.daoUtil.queryCount(criteria));
        }
        return new QueryListReturnVo<ResearchUserResultModel>(list, pageInfo);
    }
    
    private Criteria getCriteria(ResearchUserQueryModel model) throws ViewException {
        Criteria criteria = daoUtil.getCurrentSession().createCriteria(ResearchUser.class);
       
        Criterion uniUserCriterion = getUniUserCriterion(model);
        Criterion orgUserCriterion = getOrgUserCriterion(model);

        Criterion userCriterion = getUserCriterion(model);
        
        if (uniUserCriterion != null) {
            criteria.add(DaoUtil.mergeCtrUseOr(uniUserCriterion, orgUserCriterion));
        }
        if (userCriterion != null) {
            criteria.createCriteria("user").add(userCriterion);
        }
        return criteria;
    }
    
    private Criterion getUniUserCriterion(ResearchUserQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getUniversityUserQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getUniversityUserQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }
    
    private Criterion getOrgUserCriterion(ResearchUserQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getOrganizationUserQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getOrganizationUserQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }

    private Criterion getUserCriterion(ResearchUserQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getUserQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getUserQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }

	@Override
	public Class<ResearchUser> getCurrentClass() {
		return ResearchUser.class;
	}
	
	@Override
	public void approve(ApproveModel am, CurrentUser user) throws ViewException {
		for (Serializable id : am.getIdList()) {
			ResearchUser t = daoUtil.queryById(getCurrentClass(), id);
			StatusProcessUtil.setStatus(t.getUser(), am.getStatus());
			StatusProcessUtil.setCommunicateStatus(t.getUser(), am.getCommunicateStatus());
			StatusProcessUtil.setRemark(t.getUser(), am.getRemark());
			StatusProcessUtil.setStatus(t, am.getStatus());
			StatusProcessUtil.setCommunicateStatus(t, am.getCommunicateStatus());
			StatusProcessUtil.setRemark(t, am.getRemark());
			daoUtil.update(t);
		}
	}
}
