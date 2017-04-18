/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:com.deep.two.dao
 * File Name:TechRequirementDAO.java
 * Date:2016-4-21 上午11:06:04
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
import com.deep.two.dao.AbstractDAO;
import com.deep.two.dao.util.CriteriaUtil;
import com.deep.two.dao.util.CriterionUnit;
import com.deep.two.dao.util.CriterionUtil;
import com.deep.two.dao.util.OrderUnit;
import com.deep.two.dao.util.Pagination;
import com.deep.two.model.query.QueryModel;
import com.deep.two.model.query.companyUser.TechRequirementCombineQueryModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.model.result.ResultModel;
import com.deep.two.model.result.companyUser.CompanyUserResultModel;
import com.deep.two.model.result.companyUser.TechRequirementResultModel;
import com.deep.two.orm.TechRequirement;
import com.deep.two.orm.TechRequirementFollower;
import com.deep.two.util.CollectionUtil;
import com.deep.two.util.CopyUtil;
import com.deep.two.util.ViewException;

 /**
 * ClassName: TechRequirementDAO <br/>
 * Description: TODO <br/>
 * Date: 2016-4-21 上午11:06:04 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

@Repository("TechRequirementDAO")
public class TechRequirementDAO extends AbstractDAO<TechRequirement> {
	@Autowired
	private TechRequirementFollowerDAO techRequirementFollowerDAO;
	
	public Map<String, TechRequirementFollower> queryFollowerListByUser(CurrentUser currentUser) throws ViewException {
		Map<String, TechRequirementFollower> map = new HashMap<String, TechRequirementFollower>();
		if(currentUser == null) return map;
		List<CriterionUnit> criteriaUnitList = new ArrayList<CriterionUnit>();
		criteriaUnitList.add(new CriterionUnit("id.userId", currentUser.getId()));
		QueryListReturnVo<TechRequirementFollower> tmp = this.techRequirementFollowerDAO.queryList(criteriaUnitList, null, currentUser);
		if(!CollectionUtil.isEmpty(tmp.getQueryReturnList())) {
			for(TechRequirementFollower ff : tmp.getQueryReturnList()) {
				map.put(ff.getId().getUserId()+"_"+ff.getId().getRequirementId()+"_"+ff.getId().getRelationType(), ff);
			}
			return map;
		}
		return map;
    }
	
	@Override
    public void delete(Serializable id, CurrentUser user) throws ViewException {
		TechRequirement fr = this.daoUtil.queryById(this.getCurrentClass(), id);
		if ("0".equals(fr.getStatus()) || "5".equals(fr.getStatus())) {
			fr.setRemoveFlag("1");
		}
		if ("1".equals(fr.getStatus()) || "2".equals(fr.getStatus()) || "3".equals(fr.getStatus()) || "4".equals(fr.getStatus())) {
			throw new ViewException("审核通过，不能删除！");
		}
		/*if (fr.getTechRequirementFollowers() != null && !fr.getTechRequirementFollowers().isEmpty()) {
			throw new ViewException("存在关联数据，无法删除！");
		}
		daoUtil.deleteById(id, getCurrentClass());*/
    }
	
	@Override
    public ResultModel getDDetail(String id, CurrentUser user) throws ViewException {
	   TechRequirement rg = this.getDetail(id, user);
	   TechRequirementResultModel trrm = CopyUtil.copyProperty(rg, TechRequirementResultModel.class);
       CompanyUserResultModel curm = CopyUtil.copyProperty(rg.getCompanyUser(), CompanyUserResultModel.class);
       trrm.setCompanyUserResultModel(curm);
	   Map<String, TechRequirementFollower> map = this.queryFollowerListByUser(user);
	   this.setFlag(map, trrm, id, user);
	   return trrm;
    }
	
	@Override
    public QueryListReturnVo<TechRequirementResultModel> combineQueryList(QueryModel model2, Pagination pageInfo, CurrentUser user) throws ViewException {
		if(model2 == null) {
			model2 = new TechRequirementCombineQueryModel();
		}
		TechRequirementCombineQueryModel model = (TechRequirementCombineQueryModel)model2;
    	Criteria criteria = getCriteria(model);
        Criteria criteriaCount = getCriteria(model);
        List<OrderUnit> orderList = new ArrayList<OrderUnit>();
        orderList.add(new OrderUnit("seqNum", OrderUnit.DESC));
        orderList.add(new OrderUnit("concernNumber", OrderUnit.DESC));
        orderList.add(new OrderUnit("whenLastUpdate", OrderUnit.DESC));
        
        List<TechRequirement> records = this.daoUtil.queryList(criteria, orderList, pageInfo);
        List<TechRequirementResultModel> list = new ArrayList<TechRequirementResultModel>();
   	 	Map<String, TechRequirementFollower> map = this.queryFollowerListByUser(user);
        for(TechRequirement rg : records) {
        	TechRequirementResultModel trrm = CopyUtil.copyProperty(rg, TechRequirementResultModel.class);
        	CompanyUserResultModel curm = CopyUtil.copyProperty(rg.getCompanyUser(), CompanyUserResultModel.class);
        	trrm.setCompanyUserResultModel(curm);
      	    this.setFlag(map, trrm, rg.getId(), user);
        	list.add(trrm);
        }
        // 调用方法查询sum Record
        if (pageInfo != null) {
            pageInfo.setSumRecord(this.daoUtil.queryCount(criteriaCount));
        }
        return new QueryListReturnVo<TechRequirementResultModel>(list, pageInfo);
    }
    
    private Criteria getCriteria(TechRequirementCombineQueryModel model) throws ViewException {
        Criteria criteria = daoUtil.getCurrentSession().createCriteria(TechRequirement.class);
        Criterion TechRequirementCriterion = getTechRequirementCriterion(model);
        Criterion companyUserCriterion = getCompanyUserCriterion(model);
        Criterion userCriterion = getUserCriterion(model);
        
        if (TechRequirementCriterion != null) {
            criteria.add(TechRequirementCriterion);
        }
        if (companyUserCriterion != null) {
            criteria.createCriteria("companyUser").add(companyUserCriterion);
            if(userCriterion != null) {
            	criteria.createCriteria("companyUser.user").add(userCriterion);
            }
        }
        return criteria;
    }
    
    private Criterion getTechRequirementCriterion(TechRequirementCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getTechRequirementQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getTechRequirementQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }
    
    private Criterion getCompanyUserCriterion(TechRequirementCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getCompanyUserQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getCompanyUserQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }

    private Criterion getUserCriterion(TechRequirementCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getUserQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getUserQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }
    
	@Override
	public Class<TechRequirement> getCurrentClass() {
		return TechRequirement.class;
	}
}
