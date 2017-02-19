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
import com.deep.two.model.query.researchUser.AchievementFollowerCombineQueryModel;
import com.deep.two.model.query.researchUser.ResearchGroupCombineQueryModel;
import com.deep.two.model.query.researchUser.ResearchGroupFollowerCombineQueryModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.model.result.researchUser.AchievementFollowerResultModel;
import com.deep.two.model.result.researchUser.AchievementResultModel;
import com.deep.two.model.result.researchUser.ResearchGroupResultModel;
import com.deep.two.model.result.researchUser.ResearchUserResultModel;
import com.deep.two.orm.Achievement;
import com.deep.two.orm.AchievementFollower;
import com.deep.two.orm.AchievementFollowerId;
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
@Repository("achievementFollowerDAO")
public class AchievementFollowerDAO extends AbstractDAO<AchievementFollower> {
	public Map<String, AchievementFollower> queryFollowerListByUser(CurrentUser currentUser) throws ViewException {
		Map<String, AchievementFollower> map = new HashMap<String, AchievementFollower>();
		if(currentUser == null) return map;
		List<CriterionUnit> criteriaUnitList = new ArrayList<CriterionUnit>();
		criteriaUnitList.add(new CriterionUnit("id.userId", currentUser.getId()));
		QueryListReturnVo<AchievementFollower> tmp = this.queryList(criteriaUnitList , null, currentUser);
		if(!CollectionUtil.isEmpty(tmp.getQueryReturnList())) {
			for(AchievementFollower ff : tmp.getQueryReturnList()) {
				map.put(ff.getId().getUserId()+"_"+ff.getId().getAchievementId()+"_"+ff.getId().getRelationType(), ff);
			}
			return map;
		}
		return map;
    }
	@Override
    public void add(AchievementFollower t, CurrentUser user) throws ViewException {
		if (exists(t.getId())) {
			if (t.getId().getRelationType().equals("0")) {
				throw new ViewException("您已经提交寻求合作申请。");
			} else {
				throw new ViewException("您已经收藏此信息。");
			}
		}
		Achievement rg = this.daoUtil.queryById(Achievement.class, t.getId().getAchievementId());
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
    		AchievementFollowerId dd = (AchievementFollowerId)id;
    		AchievementFollower af = this.daoUtil.queryById(getCurrentClass(), dd);
    		Achievement rg = this.daoUtil.queryById(Achievement.class, dd.getAchievementId());
	        if (rg != null && af.getId().getRelationType().equals("1")) {
	            rg.setConcernNumber(rg.getConcernNumber()-1);
	        }
	        this.daoUtil.deleteById(id, getCurrentClass());
    	}
    }
  
	@Override
    public QueryListReturnVo<AchievementFollowerResultModel> combineQueryList(QueryModel model2, Pagination pageInfo, CurrentUser user) throws ViewException {
		if(model2 == null) {
			model2 = new AchievementFollowerCombineQueryModel();
		}
		AchievementFollowerCombineQueryModel model = (AchievementFollowerCombineQueryModel)model2;
		Criteria criteria = getCriteria(model);
        List<OrderUnit> orderList = new ArrayList<OrderUnit>();
        
        List<AchievementFollower> records = this.daoUtil.queryList(criteria, orderList, pageInfo);
        List<AchievementFollowerResultModel> list = new ArrayList<AchievementFollowerResultModel>();
   	 	Map<String, AchievementFollower> map = this.queryFollowerListByUser(user);
        for(AchievementFollower rg : records) {
        	AchievementFollowerResultModel frfrm = CopyUtil.copyProperty(rg, AchievementFollowerResultModel.class);
        	UserModel um = CopyUtil.copyProperty(rg.getUser(), UserModel.class);
        	frfrm.setUserModel(um);
        	AchievementResultModel frrm = CopyUtil.copyProperty(rg.getAchievement(), AchievementResultModel.class);
        	frfrm.setAchievementResultModel(frrm);
        	ResearchGroupResultModel rgrm = CopyUtil.copyProperty(rg.getAchievement().getResearchGroup(), ResearchGroupResultModel.class);
        	ResearchUserResultModel rurm = CopyUtil.copyProperty(rg.getAchievement().getResearchGroup().getResearchUser(), ResearchUserResultModel.class);
        	rgrm.setResearchUserResultModel(rurm);
        	frrm.setResearchGroupResultModel(rgrm);
      	    this.setFlag(map, frrm, frrm.getId(), user);
        	list.add(frfrm);
        }
        // 调用方法查询sum Record
        if (pageInfo != null) {
            pageInfo.setSumRecord(this.daoUtil.queryCount(criteria));
        }
        return new QueryListReturnVo<AchievementFollowerResultModel>(list, pageInfo);
    }
    
    private Criteria getCriteria(AchievementFollowerCombineQueryModel model) throws ViewException {
        Criteria criteria = daoUtil.getCurrentSession().createCriteria(AchievementFollower.class);
        Criterion followerCriterion = getAchievementFollowerCriterion(model);
        Criterion AchievementGroupCriterion = getAchievementCriterion(model);
        Criterion researchGroupCriterion = getResearchGroupCriterion(model);
        Criterion researchUserCriterion = getResearchUserCriterion(model);
        Criterion userCriterion = getUserCriterion(model);
        
        if (followerCriterion != null) {
            criteria.add(followerCriterion);
        }
        
        if (AchievementGroupCriterion != null) {
            criteria.createCriteria("achievement").add(AchievementGroupCriterion);
            if (researchGroupCriterion != null) {
                criteria.createCriteria("achievement.researchGroup").add(researchGroupCriterion);
                if (researchUserCriterion != null) {
                    criteria.createCriteria("achievement.researchGroup.researchUser").add(researchUserCriterion);
                }
            }
        }
        
        if (userCriterion != null) {
            criteria.createCriteria("user").add(userCriterion);
        }
        return criteria;
    }
    
    private Criterion getResearchGroupCriterion(AchievementFollowerCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getResearchGroupQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getResearchGroupQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }
    
    private Criterion getResearchUserCriterion(AchievementFollowerCombineQueryModel model) throws ViewException {
    	Criterion uniUserCriterion = getUniUserCriterion(model);
        Criterion orgUserCriterion = getOrgUserCriterion(model);
        if (uniUserCriterion != null || orgUserCriterion != null) {
           return DaoUtil.mergeCtrUseOr(uniUserCriterion, orgUserCriterion);
        }
        return null;
    }
    
    private Criterion getUniUserCriterion(AchievementFollowerCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getUniversityUserQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getUniversityUserQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }
    
    private Criterion getOrgUserCriterion(AchievementFollowerCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getOrganizationUserQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getOrganizationUserQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }
    
    private Criterion getAchievementFollowerCriterion(AchievementFollowerCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getAchievementFollowerQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getAchievementFollowerQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }
    
    private Criterion getAchievementCriterion(AchievementFollowerCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getAchievementQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getAchievementQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }

    private Criterion getUserCriterion(AchievementFollowerCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getUserQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getUserQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }

	@Override
	public Class<AchievementFollower> getCurrentClass() {
		return AchievementFollower.class;
	}
}