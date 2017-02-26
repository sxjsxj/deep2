/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:com.deep.two.dao
 * File Name:CompanyUserDAO.java
 * Date:2016-4-21 上午11:05:24
 * 
 */
package com.deep.two.dao.companyUser;

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
import com.deep.two.dao.util.OrderUnit;
import com.deep.two.dao.util.Pagination;
import com.deep.two.dao.util.StatusProcessUtil;
import com.deep.two.model.ApproveModel;
import com.deep.two.model.query.QueryModel;
import com.deep.two.model.query.companyUser.CompanyUserCombineQueryModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.model.result.ResultModel;
import com.deep.two.model.result.companyUser.CompanyUserResultModel;
import com.deep.two.orm.CompanyUser;
import com.deep.two.util.CopyUtil;
import com.deep.two.util.ViewException;

/**
 * ClassName: CompanyUserDAO <br/>
 * Description: TODO <br/>
 * Date: 2016-4-21 上午11:05:24 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

@Repository("CompanyUserDAO")
public class CompanyUserDAO extends AbstractDAO<CompanyUser> {
	
	@Override
    public ResultModel getDDetail(String id, CurrentUser user) throws ViewException {
	   CompanyUser model = this.getDetail(id, user);
	   CompanyUserResultModel crm = CopyUtil.copyProperty(model, CompanyUserResultModel.class);
	   UserModel um = CopyUtil.copyProperty(model.getUser(), UserModel.class);
	   crm.setUserModel(um);
	   return crm;
    }

	@Override
	public QueryListReturnVo<CompanyUserResultModel> combineQueryList(
			QueryModel model2, Pagination pageInfo, CurrentUser user)
			throws ViewException {
		if(model2 == null) {
			model2 = new CompanyUserCombineQueryModel();
		}
		CompanyUserCombineQueryModel model = (CompanyUserCombineQueryModel) model2;
		Criteria criteria = getCriteria(model);
		Criteria criteriaCount = getCriteria(model);
		List<OrderUnit> orderList = new ArrayList<OrderUnit>();

		List<CompanyUser> records = this.daoUtil.queryList(criteria, orderList,
				pageInfo);
		List<CompanyUserResultModel> list = new ArrayList<CompanyUserResultModel>();
		for (CompanyUser rg : records) {
			CompanyUserResultModel curm = CopyUtil.copyProperty(rg,
					CompanyUserResultModel.class);
			UserModel um = CopyUtil.copyProperty(rg.getUser(), UserModel.class);
			curm.setUserModel(um);
			list.add(curm);
		}
		// 调用方法查询sum Record
		if (pageInfo != null) {
			pageInfo.setSumRecord(this.daoUtil.queryCount(criteriaCount));
		}
		return new QueryListReturnVo<CompanyUserResultModel>(list, pageInfo);
	}

	private Criteria getCriteria(CompanyUserCombineQueryModel model)
			throws ViewException {
		Criteria criteria = daoUtil.getCurrentSession().createCriteria(
				CompanyUser.class);
		Criterion companyUserCriterion = getCompanyUserCriterion(model);
		Criterion userCriterion = getUserCriterion(model);

		if (companyUserCriterion != null) {
			criteria.add(companyUserCriterion);
		}
		if (userCriterion != null) {
			criteria.createCriteria("user").add(userCriterion);
		}
		return criteria;
	}

	private Criterion getCompanyUserCriterion(CompanyUserCombineQueryModel model)
			throws ViewException {
		List<CriterionUnit> criteriaUnitList = null;
		if (model.getCompanyUserQueryModel() != null) {
			criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model
					.getCompanyUserQueryModel());
		}
		return CriterionUtil.createCriterion(criteriaUnitList);
	}

	private Criterion getUserCriterion(CompanyUserCombineQueryModel model)
			throws ViewException {
		List<CriterionUnit> criteriaUnitList = null;
		if (model.getUserQueryModel() != null) {
			criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model
					.getUserQueryModel());
		}
		return CriterionUtil.createCriterion(criteriaUnitList);
	}

	@Override
	public Class<CompanyUser> getCurrentClass() {
		return CompanyUser.class;
	}

	@Override
	public void approve(ApproveModel am, CurrentUser user) throws ViewException {
		for (Serializable id : am.getIdList()) {
			CompanyUser t = daoUtil.queryById(getCurrentClass(), id);
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
