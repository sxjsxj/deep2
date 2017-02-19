/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:com.deep.two.dao
 * File Name:ResearchDAO.java
 * Date:2016-4-21 上午11:03:46
 * 
 */
package com.deep.two.dao.companyUser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deep.two.authority.model.CurrentUser;
import com.deep.two.authority.model.UserModel;
import com.deep.two.dao.AbstractDAO;
import com.deep.two.dao.util.CommonProcessUtil;
import com.deep.two.dao.util.CriteriaUtil;
import com.deep.two.dao.util.CriterionUnit;
import com.deep.two.dao.util.CriterionUtil;
import com.deep.two.dao.util.OrderUnit;
import com.deep.two.dao.util.Pagination;
import com.deep.two.model.query.QueryModel;
import com.deep.two.model.query.companyUser.FundRequirementFollowerCombineQueryModel;
import com.deep.two.model.query.companyUser.TechRequirementFollowerCombineQueryModel;
import com.deep.two.model.result.FollowerModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.model.result.companyUser.CompanyUserResultModel;
import com.deep.two.model.result.companyUser.FundRequirementFollowerResultModel;
import com.deep.two.model.result.companyUser.FundRequirementResultModel;
import com.deep.two.orm.FundRequirement;
import com.deep.two.orm.FundRequirementFollower;
import com.deep.two.orm.FundRequirementFollowerId;
import com.deep.two.util.CollectionUtil;
import com.deep.two.util.CopyUtil;
import com.deep.two.util.ViewException;

 /**
 * ClassName: ResearchDAO <br/>
 * Description: TODO <br/>
 * Date: 2016-4-21 上午11:03:46 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */
@Repository("FundRequirementFollowerDAO")
public class FundRequirementFollowerDAO extends AbstractDAO<FundRequirementFollower> {
	
	public Map<String, FundRequirementFollower> queryFollowerListByUser(CurrentUser currentUser) throws ViewException {
		Map<String, FundRequirementFollower> map = new HashMap<String, FundRequirementFollower>();
		if(currentUser == null) return map;
		List<CriterionUnit> criteriaUnitList = new ArrayList<CriterionUnit>();
		criteriaUnitList.add(new CriterionUnit("id.userId", currentUser.getId()));
		QueryListReturnVo<FundRequirementFollower> tmp = this.queryList(criteriaUnitList , null, currentUser);
		if(!CollectionUtil.isEmpty(tmp.getQueryReturnList())) {
			for(FundRequirementFollower ff : tmp.getQueryReturnList()) {
				map.put(ff.getId().getUserId()+"_"+ff.getId().getRequirementId()+"_"+ff.getId().getRelationType(), ff);
			}
			return map;
		}
		return map;
    }
	
	@Override
    public void add(FundRequirementFollower t, CurrentUser user) throws ViewException {
		if (exists(t.getId())) {
			if (t.getId().getRelationType().equals("0")) {
				throw new ViewException("您已经提交寻求合作申请。");
			} else {
				throw new ViewException("您已经收藏此信息。");
			}
		}
		FundRequirement rg = this.daoUtil.queryById(FundRequirement.class, t.getId().getRequirementId());
		if (rg != null && t.getId().getRelationType().equals("1")) {
	    	if(rg.getConcernNumber() == null) {
	    		rg.setConcernNumber(1);
	    	} else {
	    		rg.setConcernNumber(rg.getConcernNumber()+1);
	    	}
        }
		CommonProcessUtil.setCommon(t, user);
        daoUtil.insert(t);
    }
	
    @Override
    public void delete(List<Serializable> list, CurrentUser user) throws ViewException {
    	for(Serializable id : list) {
    		FundRequirementFollowerId dd = (FundRequirementFollowerId)id;
    		FundRequirementFollower af = this.daoUtil.queryById(getCurrentClass(), dd);
    		FundRequirement rg = this.daoUtil.queryById(FundRequirement.class, dd.getRequirementId());
	        if (rg != null && af.getId().getRelationType().equals("0")) {
	            rg.setConcernNumber(rg.getConcernNumber()-1);
	        }
	        this.daoUtil.deleteById(id, getCurrentClass());
    	}
    }
    
	@Override
    public QueryListReturnVo<FundRequirementFollowerResultModel> combineQueryList(QueryModel model2, Pagination pageInfo, CurrentUser user) throws ViewException {
		if(model2 == null) {
			model2 = new FundRequirementFollowerCombineQueryModel();
		}
		FundRequirementFollowerCombineQueryModel model = (FundRequirementFollowerCombineQueryModel)model2;
		Criteria criteria = getCriteria(model );
        List<OrderUnit> orderList = new ArrayList<OrderUnit>();
        
        List<FundRequirementFollower> records = this.daoUtil.queryList(criteria, orderList, pageInfo);
        List<FundRequirementFollowerResultModel> list = new ArrayList<FundRequirementFollowerResultModel>();
    	Map<String, FundRequirementFollower> map = this.queryFollowerListByUser(user);
        for(FundRequirementFollower rg : records) {
        	FundRequirementFollowerResultModel frfrm = CopyUtil.copyProperty(rg, FundRequirementFollowerResultModel.class);
        	UserModel um = CopyUtil.copyProperty(rg.getUser(), UserModel.class);
        	frfrm.setUserModel(um);
        	FundRequirementResultModel frrm = CopyUtil.copyProperty(rg.getFundRequirement(), FundRequirementResultModel.class);
        	frfrm.setFundRequirementResultModel(frrm);
        	CompanyUserResultModel curm = CopyUtil.copyProperty(rg.getFundRequirement().getCompanyUser(), CompanyUserResultModel.class);
        	frrm.setCompanyUserResultModel(curm);
      	    this.setFlag(map, frrm, frrm.getId(), user);
        	list.add(frfrm);
        }
        // 调用方法查询sum Record
        if (pageInfo != null) {
            pageInfo.setSumRecord(this.daoUtil.queryCount(criteria));
        }
        return new QueryListReturnVo<FundRequirementFollowerResultModel>(list, pageInfo);
    }
    
    private Criteria getCriteria(FundRequirementFollowerCombineQueryModel model) throws ViewException {
        Criteria criteria = daoUtil.getCurrentSession().createCriteria(FundRequirementFollower.class);
        Criterion followerCriterion = getRequirementFollowerCriterion(model);
        Criterion requirementCriterion = getRequirementCriterion(model);
        Criterion companyUserCriterion = getCompanyUserCriterion(model);
        Criterion userCriterion = getUserCriterion(model);
        
        if (followerCriterion != null) {
            criteria.add(followerCriterion);
        }
        if (requirementCriterion != null) {
            criteria.createCriteria("fundRequirement").add(requirementCriterion);
            if (companyUserCriterion != null) {
            	criteria.createCriteria("fundRequirement.companyUser").add(companyUserCriterion);
            }
        }
        if (userCriterion != null) {
            criteria.createCriteria("user").add(userCriterion);
        }
        return criteria;
    }
    
    private Criterion getRequirementFollowerCriterion(FundRequirementFollowerCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getFundRequirementFollowerQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getFundRequirementFollowerQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }
    
    private Criterion getRequirementCriterion(FundRequirementFollowerCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getFundRequirementQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getFundRequirementQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }
    
    private Criterion getCompanyUserCriterion(FundRequirementFollowerCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getCompanyUserQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getCompanyUserQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }
    
    private Criterion getUserCriterion(FundRequirementFollowerCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getUserQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getUserQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }
    
	@Override
	public Class<FundRequirementFollower> getCurrentClass() {
		return FundRequirementFollower.class;
	}
}