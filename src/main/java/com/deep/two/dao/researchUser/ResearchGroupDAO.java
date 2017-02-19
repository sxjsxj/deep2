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
import com.deep.two.model.query.researchUser.ResearchGroupCombineQueryModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.model.result.ResultModel;
import com.deep.two.model.result.researchUser.ResearchGroupResultModel;
import com.deep.two.model.result.researchUser.ResearchUserResultModel;
import com.deep.two.orm.ResearchGroup;
import com.deep.two.orm.ResearchGroupFollower;
import com.deep.two.orm.ResearchUser;
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
@Repository("researchDAO")
public class ResearchGroupDAO extends AbstractDAO<ResearchGroup> {
	@Autowired
	private ResearchGroupFollowerDAO ResearchGroupFollowerDAO;
	
	public Map<String, ResearchGroupFollower> queryFollowerListByUser(CurrentUser currentUser) throws ViewException {
		Map<String, ResearchGroupFollower> map = new HashMap<String, ResearchGroupFollower>();
		if(currentUser == null) return map;
		List<CriterionUnit> criteriaUnitList = new ArrayList<CriterionUnit>();
		criteriaUnitList.add(new CriterionUnit("id.userId", currentUser.getId()));
		QueryListReturnVo<ResearchGroupFollower> tmp = this.ResearchGroupFollowerDAO.queryList(criteriaUnitList , null, currentUser);
		if(!CollectionUtil.isEmpty(tmp.getQueryReturnList())) {
			for(ResearchGroupFollower ff : tmp.getQueryReturnList()) {
				map.put(ff.getId().getUserId()+"_"+ff.getId().getResearchId()+"_"+ff.getId().getRelationType(), ff);
			}
			return map;
		}
		return map;
    }
	
	@Override
    public ResultModel getDDetail(String id, CurrentUser user) throws ViewException {
		ResearchGroup rg = this.getDetail(id, user);
		ResearchGroupResultModel rgrm = CopyUtil.copyProperty(rg, ResearchGroupResultModel.class);
    	ResearchUser researchUser = rg.getResearchUser();
    	ResearchUserResultModel rurm =  CopyUtil.copyProperty(researchUser, ResearchUserResultModel.class);
    	rgrm.setResearchUserResultModel(rurm);
    	Map<String, ResearchGroupFollower> map = this.queryFollowerListByUser(user);
  	    this.setFlag(map, rgrm, id, user);
	    return rgrm;
    }
	
	@Override
    public void delete(Serializable id, CurrentUser user) throws ViewException {
		ResearchGroup fr = this.daoUtil.queryById(this.getCurrentClass(), id);
		if ("0".equals(fr.getStatus()) || "1".equals(fr.getStatus()) || "2".equals(fr.getStatus())) {
			fr.setRemoveFlag("1");
		}
		if ("3".equals(fr.getStatus()) || "4".equals(fr.getStatus())) {
			throw new ViewException("洽谈中，不能删除！");
		}
		/*if ((rg.getAchievements() != null && !rg.getAchievements().isEmpty())
			|| (rg.getResearchGroupFollowers() != null && !rg.getResearchGroupFollowers().isEmpty())) {
			throw new ViewException("存在关联数据，无法删除！");
		}
		daoUtil.deleteById(id, getCurrentClass());*/
    }
	
	@Override
    public QueryListReturnVo<ResearchGroupResultModel> combineQueryList(QueryModel queryModel, Pagination pageInfo, CurrentUser user) throws ViewException {
    	if(queryModel == null) {
    		queryModel = new ResearchGroupCombineQueryModel();
    	}
		ResearchGroupCombineQueryModel model = (ResearchGroupCombineQueryModel)queryModel;
    	Criteria criteria = getCriteria(model);
        List<OrderUnit> orderList = new ArrayList<OrderUnit>();
        orderList.add(new OrderUnit("seqNum", OrderUnit.DESC));
        orderList.add(new OrderUnit("concernNumber", OrderUnit.DESC));
        orderList.add(new OrderUnit("whenLastUpdate", OrderUnit.DESC));
        
        List<ResearchGroup> records = this.daoUtil.queryList(criteria, orderList, pageInfo);
        List<ResearchGroupResultModel> list = new ArrayList<ResearchGroupResultModel>();
    	Map<String, ResearchGroupFollower> map = this.queryFollowerListByUser(user);
        for(ResearchGroup rg : records) {
        	ResearchGroupResultModel rgrm = CopyUtil.copyProperty(rg, ResearchGroupResultModel.class);
        	ResearchUser researchUser = rg.getResearchUser();
        	ResearchUserResultModel rurm =  CopyUtil.copyProperty(researchUser, ResearchUserResultModel.class);
        	rgrm.setResearchUserResultModel(rurm);
      	    this.setFlag(map, rgrm, rg.getId(), user);
        	list.add(rgrm);
        }
        // 调用方法查询sum Record
        if (pageInfo != null) {
            pageInfo.setSumRecord(this.daoUtil.queryCount(criteria));
        }
        return new QueryListReturnVo<ResearchGroupResultModel>(list, pageInfo);
    }
    
    private Criteria getCriteria(ResearchGroupCombineQueryModel model) throws ViewException {
        Criteria criteria = daoUtil.getCurrentSession().createCriteria(ResearchGroup.class);
        Criterion researchGroupCriterion = getResearchGroupCriterion(model);
        Criterion researchUserCriterion = getResearchUserCriterion(model);
        Criterion userCriterion = getUserCriterion(model);
        
        if (researchGroupCriterion != null) {
            criteria.add(researchGroupCriterion);
            if (researchUserCriterion != null) {
                criteria.createCriteria("researchUser").add(researchUserCriterion);
                if (userCriterion != null) {
                    criteria.createCriteria("researchUser.user").add(userCriterion);
                }
            }
        }
        return criteria;
    }
    
    private Criterion getResearchGroupCriterion(ResearchGroupCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getResearchGroupQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getResearchGroupQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }
    
    private Criterion getResearchUserCriterion(ResearchGroupCombineQueryModel model) throws ViewException {
    	Criterion uniUserCriterion = getUniUserCriterion(model);
        Criterion orgUserCriterion = getOrgUserCriterion(model);
        if (uniUserCriterion != null || orgUserCriterion != null) {
           return DaoUtil.mergeCtrUseOr(uniUserCriterion, orgUserCriterion);
        }
        return null;
    }

    private Criterion getUniUserCriterion(ResearchGroupCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getUniversityUserQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getUniversityUserQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }
    
    private Criterion getOrgUserCriterion(ResearchGroupCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getOrganizationUserQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getOrganizationUserQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }

    private Criterion getUserCriterion(ResearchGroupCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getUserQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getUserQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }

	@Override
	public Class<ResearchGroup> getCurrentClass() {
		return ResearchGroup.class;
	}
}