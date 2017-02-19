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
import com.deep.two.model.query.companyUser.TechRequirementFollowerCombineQueryModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.model.result.companyUser.CompanyUserResultModel;
import com.deep.two.model.result.companyUser.TechRequirementFollowerResultModel;
import com.deep.two.model.result.companyUser.TechRequirementResultModel;
import com.deep.two.orm.TechRequirement;
import com.deep.two.orm.TechRequirementFollower;
import com.deep.two.orm.TechRequirementFollowerId;
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
@Repository("TechRequirementFollowerDAO")
public class TechRequirementFollowerDAO extends AbstractDAO<TechRequirementFollower> {
	
	public Map<String, TechRequirementFollower> queryFollowerListByUser(CurrentUser currentUser) throws ViewException {
		Map<String, TechRequirementFollower> map = new HashMap<String, TechRequirementFollower>();
		if(currentUser == null) return map;
		List<CriterionUnit> criteriaUnitList = new ArrayList<CriterionUnit>();
		criteriaUnitList.add(new CriterionUnit("id.userId", currentUser.getId()));
		QueryListReturnVo<TechRequirementFollower> tmp = this.queryList(criteriaUnitList, null, currentUser);
		if(!CollectionUtil.isEmpty(tmp.getQueryReturnList())) {
			for(TechRequirementFollower ff : tmp.getQueryReturnList()) {
				map.put(ff.getId().getUserId()+"_"+ff.getId().getRequirementId()+"_"+ff.getId().getRelationType(), ff);
			}
			return map;
		}
		return map;
    }
	
	@Override
    public void add(TechRequirementFollower t, CurrentUser user) throws ViewException {
		if (exists(t.getId())) {
			if (t.getId().getRelationType().equals("0")) {
				throw new ViewException("您已经提交寻求合作申请。");
			} else {
				throw new ViewException("您已经收藏此信息。");
			}
		}
		TechRequirement rg = this.daoUtil.queryById(TechRequirement.class, t.getId().getRequirementId());
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
    		TechRequirementFollowerId dd = (TechRequirementFollowerId)id;
    		TechRequirementFollower af = this.daoUtil.queryById(getCurrentClass(), dd);
    		TechRequirement rg = this.daoUtil.queryById(TechRequirement.class, dd.getRequirementId());
	        if (rg != null && af.getId().getRelationType().equals("0")) {
	            rg.setConcernNumber(rg.getConcernNumber()-1);
	        }
	        this.daoUtil.deleteById(id, getCurrentClass());
    	}
    }
    
	@Override
    public QueryListReturnVo<TechRequirementFollowerResultModel> combineQueryList(QueryModel model2, Pagination pageInfo, CurrentUser user) throws ViewException {
		if(model2 == null) {
			model2 = new TechRequirementFollowerCombineQueryModel();
		}
		TechRequirementFollowerCombineQueryModel model = (TechRequirementFollowerCombineQueryModel)model2;
		Criteria criteria = getCriteria(model );
        List<OrderUnit> orderList = new ArrayList<OrderUnit>();
        
        List<TechRequirementFollower> records = this.daoUtil.queryList(criteria, orderList, pageInfo);
        List<TechRequirementFollowerResultModel> list = new ArrayList<TechRequirementFollowerResultModel>();
   	 	Map<String, TechRequirementFollower> map = this.queryFollowerListByUser(user);
        for(TechRequirementFollower rg : records) {
        	TechRequirementFollowerResultModel frfrm = CopyUtil.copyProperty(rg, TechRequirementFollowerResultModel.class);
        	UserModel um = CopyUtil.copyProperty(rg.getUser(), UserModel.class);
        	frfrm.setUserModel(um);
        	TechRequirementResultModel frrm = CopyUtil.copyProperty(rg.getTechRequirement(), TechRequirementResultModel.class);
        	frfrm.setTechRequirementResultModel(frrm);
        	CompanyUserResultModel curm = CopyUtil.copyProperty(rg.getTechRequirement().getCompanyUser(), CompanyUserResultModel.class);
        	frrm.setCompanyUserResultModel(curm);
      	    this.setFlag(map, frrm, frrm.getId(), user);
        	list.add(frfrm);
        }
        // 调用方法查询sum Record
        if (pageInfo != null) {
            pageInfo.setSumRecord(this.daoUtil.queryCount(criteria));
        }
        return new QueryListReturnVo<TechRequirementFollowerResultModel>(list, pageInfo);
    }
    
    private Criteria getCriteria(TechRequirementFollowerCombineQueryModel model) throws ViewException {
        Criteria criteria = daoUtil.getCurrentSession().createCriteria(TechRequirementFollower.class);
        Criterion followerCriterion = getRequirementFollowerCriterion(model);
        Criterion requirementCriterion = getRequirementCriterion(model);
        Criterion companyUserCriterion = getCompanyUserCriterion(model);
        Criterion userCriterion = getUserCriterion(model);
        
        if (followerCriterion != null) {
            criteria.add(followerCriterion);
        }
        
        if (requirementCriterion != null) {
            criteria.createCriteria("techRequirement").add(requirementCriterion);
            if (companyUserCriterion != null) {
            	criteria.createCriteria("techRequirement.companyUser").add(companyUserCriterion);
            }
        }
        
        if (userCriterion != null) {
            criteria.createCriteria("user").add(userCriterion);
        }
        return criteria;
    }
    
    private Criterion getRequirementFollowerCriterion(TechRequirementFollowerCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getTechRequirementFollowerQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getTechRequirementFollowerQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }
    
    private Criterion getRequirementCriterion(TechRequirementFollowerCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getTechRequirementQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getTechRequirementQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }
    
    private Criterion getCompanyUserCriterion(TechRequirementFollowerCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getCompanyUserQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getCompanyUserQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }
    
    private Criterion getUserCriterion(TechRequirementFollowerCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getUserQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getUserQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }

	@Override
	public Class<TechRequirementFollower> getCurrentClass() {
		return TechRequirementFollower.class;
	}
}