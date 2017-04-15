/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:com.deep.two.dao
 * File Name:AchievementDAO.java
 * Date:2016-4-21 上午11:04:01
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.deep.two.authority.model.CurrentUser;
import com.deep.two.dao.AbstractDAO;
import com.deep.two.dao.util.CriteriaUtil;
import com.deep.two.dao.util.CriterionUnit;
import com.deep.two.dao.util.CriterionUtil;
import com.deep.two.dao.util.DaoUtil;
import com.deep.two.dao.util.OrderUnit;
import com.deep.two.dao.util.Pagination;
import com.deep.two.model.query.QueryModel;
import com.deep.two.model.query.researchUser.AchievementCombineQueryModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.model.result.ResultModel;
import com.deep.two.model.result.researchUser.AchievementResultModel;
import com.deep.two.model.result.researchUser.ResearchGroupResultModel;
import com.deep.two.model.result.researchUser.ResearchUserResultModel;
import com.deep.two.orm.Achievement;
import com.deep.two.orm.AchievementFollower;
import com.deep.two.util.CollectionUtil;
import com.deep.two.util.CopyUtil;
import com.deep.two.util.ViewException;

/**
 * ClassName: AchievementDAO <br/>
 * Description: TODO <br/>
 * Date: 2016-4-21 上午11:04:01 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */
@Repository("achievementDAO")
public class AchievementDAO extends AbstractDAO<Achievement> {
	@Autowired
	private AchievementFollowerDAO achievementFollowerDAO;
	
	public Map<String, AchievementFollower> queryFollowerListByUser(CurrentUser currentUser) throws ViewException {
		Map<String, AchievementFollower> map = new HashMap<String, AchievementFollower>();
		if(currentUser == null) return map;
		List<CriterionUnit> criteriaUnitList = new ArrayList<CriterionUnit>();
		criteriaUnitList.add(new CriterionUnit("id.userId", currentUser.getId()));
		QueryListReturnVo<AchievementFollower> tmp = this.achievementFollowerDAO.queryList(criteriaUnitList , null, currentUser);
		if(!CollectionUtil.isEmpty(tmp.getQueryReturnList())) {
			for(AchievementFollower ff : tmp.getQueryReturnList()) {
				map.put(ff.getId().getUserId()+"_"+ff.getId().getAchievementId()+"_"+ff.getId().getRelationType(), ff);
			}
			return map;
		}
		return map;
    }

	@Override
    public void delete(Serializable id, CurrentUser user) throws ViewException {
		Achievement fr = this.daoUtil.queryById(this.getCurrentClass(), id);
		if ("0".equals(fr.getStatus()) || "5".equals(fr.getStatus())) {
			fr.setRemoveFlag("1");
		}
		if ("1".equals(fr.getStatus()) || "2".equals(fr.getStatus()) || "3".equals(fr.getStatus()) || "4".equals(fr.getStatus())) {
			throw new ViewException("审核通过，不能删除！");
		}
		/*if (am.getAchievementFollowers() != null && !am.getAchievementFollowers().isEmpty()) {
			throw new ViewException("存在关联数据，无法删除！");
		}
		daoUtil.deleteById(id, getCurrentClass());*/
    }
	
	@Override
    public ResultModel getDDetail(String id, CurrentUser user) throws ViewException {
       Achievement model = this.getDetail(id, user);
       AchievementResultModel arm = CopyUtil.copyProperty(model, AchievementResultModel.class);
	   ResearchGroupResultModel rgrm = CopyUtil.copyProperty(model.getResearchGroup(), ResearchGroupResultModel.class);
	   ResearchUserResultModel rurm = CopyUtil.copyProperty(model.getResearchGroup().getResearchUser(), ResearchUserResultModel.class);
	   rgrm.setResearchUserResultModel(rurm);
	   arm.setResearchGroupResultModel(rgrm);
	   Map<String, AchievementFollower> map = this.queryFollowerListByUser(user);
	   this.setFlag(map, arm, id, user);
	   return arm;
    }
	
	@Override
    public QueryListReturnVo<AchievementResultModel> combineQueryList(QueryModel queryModel, Pagination pageInfo, CurrentUser user) throws ViewException {
		if(queryModel == null) {
			queryModel = new AchievementCombineQueryModel();
		}
		AchievementCombineQueryModel model = (AchievementCombineQueryModel)queryModel;
    	Criteria criteria = getCriteria(model);
        Criteria criteriaCount = getCriteria(model);
        List<OrderUnit> orderList = new ArrayList<OrderUnit>();
        orderList.add(new OrderUnit("seqNum", OrderUnit.DESC));
        orderList.add(new OrderUnit("concernNumber", OrderUnit.DESC));
        orderList.add(new OrderUnit("whenLastUpdate", OrderUnit.DESC));

        List<Achievement> records = this.daoUtil.queryList(criteria, orderList, pageInfo);
        List<AchievementResultModel> list = new ArrayList<AchievementResultModel>();
   	 	Map<String, AchievementFollower> map = this.queryFollowerListByUser(user);
        for(Achievement rg : records) {
        	AchievementResultModel arm = CopyUtil.copyProperty(rg, AchievementResultModel.class);
        	ResearchGroupResultModel rgrm = CopyUtil.copyProperty(rg.getResearchGroup(), ResearchGroupResultModel.class);
        	ResearchUserResultModel rurm = CopyUtil.copyProperty(rg.getResearchGroup().getResearchUser(), ResearchUserResultModel.class);
        	rgrm.setResearchUserResultModel(rurm);
        	arm.setResearchGroupResultModel(rgrm);
      	    this.setFlag(map, arm, rg.getId(), user);
        	list.add(arm);
        }
        // 调用方法查询sum Record
        if (pageInfo != null) {
            pageInfo.setSumRecord(this.daoUtil.queryCount(criteriaCount));
        }
        return new QueryListReturnVo<AchievementResultModel>(list, pageInfo);
    }

    private Criteria getCriteria(AchievementCombineQueryModel model) throws ViewException {
        Criteria criteria = daoUtil.getCurrentSession().createCriteria(Achievement.class);
        Criterion achievementCriterion = getAchievementCriterion(model);
        Criterion researchGroupCriterion = getResearchGroupCriterion(model);
        
        if (achievementCriterion != null) {
            criteria.add(achievementCriterion);
        }
        if (researchGroupCriterion != null) {
            criteria.createCriteria("researchGroup").add(researchGroupCriterion);
            Criterion uniUserCriterion = getUniUserCriterion(model);
            Criterion orgUserCriterion = getOrgUserCriterion(model);
            if(uniUserCriterion != null || orgUserCriterion != null) {   
                criteria.createCriteria("researchGroup.researchUser").add(DaoUtil.mergeCtrUseOr(uniUserCriterion, orgUserCriterion));
                Criterion userCriterion = getUserCriterion(model);
                if (userCriterion != null){
                    criteria.createCriteria("researchGroup.researchUser.user").add(userCriterion);
                }
            }
        } 
        return criteria;
    }
    
    private Criterion getAchievementCriterion(AchievementCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getAchievementQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getAchievementQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }
    
    private Criterion getResearchGroupCriterion(AchievementCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getResearchGroupQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getResearchGroupQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }

    private Criterion getUniUserCriterion(AchievementCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getUniversityUserQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getUniversityUserQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }
    
    private Criterion getOrgUserCriterion(AchievementCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getOrganizationUserQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getOrganizationUserQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }

    private Criterion getUserCriterion(AchievementCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getUserQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getUserQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }

    @Override
    public Class<Achievement> getCurrentClass() {
        return Achievement.class;
    }
}
