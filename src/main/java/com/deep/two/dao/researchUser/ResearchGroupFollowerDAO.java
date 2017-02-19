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
package com.deep.two.dao.researchUser;

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
import com.deep.two.dao.util.DaoUtil;
import com.deep.two.dao.util.OrderUnit;
import com.deep.two.dao.util.Pagination;
import com.deep.two.model.query.QueryModel;
import com.deep.two.model.query.researchUser.ResearchGroupCombineQueryModel;
import com.deep.two.model.query.researchUser.ResearchGroupFollowerCombineQueryModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.model.result.researchUser.ResearchGroupFollowerResultModel;
import com.deep.two.model.result.researchUser.ResearchGroupResultModel;
import com.deep.two.model.result.researchUser.ResearchUserResultModel;
import com.deep.two.orm.ResearchGroup;
import com.deep.two.orm.ResearchGroupFollower;
import com.deep.two.orm.ResearchGroupFollowerId;
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
@Repository("researchGroupFollowerDAO")
public class ResearchGroupFollowerDAO extends AbstractDAO<ResearchGroupFollower> {
	public Map<String, ResearchGroupFollower> queryFollowerListByUser(CurrentUser currentUser) throws ViewException {
		Map<String, ResearchGroupFollower> map = new HashMap<String, ResearchGroupFollower>();
		if(currentUser == null) return map;
		List<CriterionUnit> criteriaUnitList = new ArrayList<CriterionUnit>();
		criteriaUnitList.add(new CriterionUnit("id.userId", currentUser.getId()));
		QueryListReturnVo<ResearchGroupFollower> tmp = this.queryList(criteriaUnitList , null, currentUser);
		if(!CollectionUtil.isEmpty(tmp.getQueryReturnList())) {
			for(ResearchGroupFollower ff : tmp.getQueryReturnList()) {
				map.put(ff.getId().getUserId()+"_"+ff.getId().getResearchId()+"_"+ff.getId().getRelationType(), ff);
			}
			return map;
		}
		return map;
    }
	
    @Override
    public void add(ResearchGroupFollower t, CurrentUser user) throws ViewException {
    	if (exists(t.getId())) {
    		if (t.getId().getRelationType().equals("0")) {
				throw new ViewException("您已经提交寻求合作申请。");
			} else {
				throw new ViewException("您已经收藏此信息。");
			}
		}
        ResearchGroup rg = this.daoUtil.queryById(ResearchGroup.class, t.getId().getResearchId());
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
    		ResearchGroupFollowerId dd = (ResearchGroupFollowerId)id;
    		ResearchGroupFollower rgf = this.daoUtil.queryById(getCurrentClass(), dd);
    		ResearchGroup rg = this.daoUtil.queryById(ResearchGroup.class, dd.getResearchId());
	        if (rg != null && rgf.getId().getRelationType().equals("1")) {
	            rg.setConcernNumber(rg.getConcernNumber()-1);
	        }
	        this.daoUtil.deleteById(id, getCurrentClass());
    	}
    }
    
    @Override
    public QueryListReturnVo<ResearchGroupFollowerResultModel> combineQueryList(QueryModel model2, Pagination pageInfo, CurrentUser user) throws ViewException {
    	if(model2 == null) {
    		model2 = new ResearchGroupFollowerCombineQueryModel();
    	}
    	ResearchGroupFollowerCombineQueryModel model = (ResearchGroupFollowerCombineQueryModel)model2;
    	Criteria criteria = getCriteria(model);
        List<OrderUnit> orderList = new ArrayList<OrderUnit>();
        
        List<ResearchGroupFollower> records = this.daoUtil.queryList(criteria, orderList, pageInfo);
        List<ResearchGroupFollowerResultModel> list = new ArrayList<ResearchGroupFollowerResultModel>();
    	Map<String, ResearchGroupFollower> map = this.queryFollowerListByUser(user);
        for(ResearchGroupFollower rg : records) {
        	ResearchGroupFollowerResultModel frfrm = CopyUtil.copyProperty(rg, ResearchGroupFollowerResultModel.class);
        	UserModel um = CopyUtil.copyProperty(rg.getUser(), UserModel.class);
        	frfrm.setUserModel(um);
        	ResearchGroupResultModel frrm = CopyUtil.copyProperty(rg.getResearchGroup(), ResearchGroupResultModel.class);
        	ResearchUserResultModel rurm = CopyUtil.copyProperty(rg.getResearchGroup().getResearchUser(), ResearchUserResultModel.class);
        	frrm.setResearchUserResultModel(rurm);
        	frfrm.setResearchGroupResultModel(frrm);
      	    this.setFlag(map, frrm, frrm.getId(), user);
        	list.add(frfrm);
        }
        // 调用方法查询sum Record
        if (pageInfo != null) {
            pageInfo.setSumRecord(this.daoUtil.queryCount(criteria));
        }
        return new QueryListReturnVo<ResearchGroupFollowerResultModel>(list, pageInfo);
    }
    
    private Criteria getCriteria(ResearchGroupFollowerCombineQueryModel model) throws ViewException {
        Criteria criteria = daoUtil.getCurrentSession().createCriteria(ResearchGroupFollower.class);
        Criterion followerCriterion = getResearchGroupFollowerCriterion(model);
        Criterion researchGroupCriterion = getResearchGroupCriterion(model);
        Criterion researchUserCriterion = getResearchUserCriterion(model);
        Criterion userCriterion = getUserCriterion(model);

        if (followerCriterion != null) {
            criteria.add(followerCriterion);
        }
        if (userCriterion != null) {
            criteria.createCriteria("user").add(userCriterion);
        }
        if (researchGroupCriterion != null) {
            criteria.createCriteria("researchGroup").add(researchGroupCriterion);
            if (researchUserCriterion != null) {
                criteria.createCriteria("researchGroup.researchUser").add(researchUserCriterion);
            }
        }
        return criteria;
    }
    
    private Criterion getResearchUserCriterion(ResearchGroupFollowerCombineQueryModel model) throws ViewException {
    	Criterion uniUserCriterion = getUniUserCriterion(model);
        Criterion orgUserCriterion = getOrgUserCriterion(model);
        if (uniUserCriterion != null || orgUserCriterion != null) {
           return DaoUtil.mergeCtrUseOr(uniUserCriterion, orgUserCriterion);
        }
        return null;
    }
    
    private Criterion getUniUserCriterion(ResearchGroupFollowerCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getUniversityUserQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getUniversityUserQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }
    
    private Criterion getOrgUserCriterion(ResearchGroupFollowerCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getOrganizationUserQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getOrganizationUserQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }
    
    private Criterion getResearchGroupFollowerCriterion(ResearchGroupFollowerCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getResearchGroupFollowerQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getResearchGroupFollowerQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }
    
    private Criterion getResearchGroupCriterion(ResearchGroupFollowerCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getResearchGroupQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getResearchGroupQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }
    
    private Criterion getUserCriterion(ResearchGroupFollowerCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getUserQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getUserQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }
    
//    private Criterion getCompanyUserCriterion(FollowerResearchGroupQueryModel model) throws ViewException {
//        List<CriterionUnit> criteriaUnitList = null;
//        if (model.getCompanyQueryModel() != null) {
//            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getCompanyQueryModel());
//        }
//        return CriterionUtil.createCriterion(criteriaUnitList);
//    }

	@Override
	public Class<ResearchGroupFollower> getCurrentClass() {
		return ResearchGroupFollower.class;
	}
}