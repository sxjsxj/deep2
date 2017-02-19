/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:com.deep.two.dao
 * File Name:CommonDAO.java
 * Date:2016-4-27 下午7:14:39
 * 
 */
package com.deep.two.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.deep.two.authority.model.CurrentUser;
import com.deep.two.dao.companyUser.CompanyUserDAO;
import com.deep.two.dao.investorUser.InvestorUserDAO;
import com.deep.two.dao.researchUser.ResearchUserDAO;
import com.deep.two.dao.util.CriteriaUtil;
import com.deep.two.dao.util.Pagination;
import com.deep.two.model.query.QueryModel;
import com.deep.two.model.query.authority.UserQueryModel;
import com.deep.two.model.query.companyUser.CompanyUserCombineQueryModel;
import com.deep.two.model.query.companyUser.CompanyUserQueryModel;
import com.deep.two.model.query.investorUser.InvestorUserCombineQueryModel;
import com.deep.two.model.query.investorUser.InvestorUserQueryModel;
import com.deep.two.model.query.researchUser.ResearchUserQueryModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.model.result.ResultModel;
import com.deep.two.model.result.companyUser.CompanyUserResultModel;
import com.deep.two.model.result.investorUser.InvestorUserResultModel;
import com.deep.two.model.result.researchUser.ResearchUserResultModel;
import com.deep.two.orm.CompanyUser;
import com.deep.two.orm.InvestorUser;
import com.deep.two.orm.User;
import com.deep.two.util.ViewException;

 /**
 * ClassName: CommonDAO <br/>
 * Description: TODO <br/>
 * Date: 2016-4-27 下午7:14:39 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */
@Repository("commonDAO")
public class CommonDAO extends AbstractDAO<Object>{
	@Autowired
	private CompanyUserDAO companyUserDAO;
	@Autowired
	private InvestorUserDAO investorUserDAO;
	@Autowired
	private ResearchUserDAO researchUserDAO;
    
    public List<User> queryUserList(UserQueryModel model1) throws ViewException {
        return daoUtil.queryList(CriteriaUtil.vo2CriteriaUnitList(model1), User.class);
    }
    
    public List<String> queryUserIdList(UserQueryModel model1) throws ViewException {
        return daoUtil.queryProperty(CriteriaUtil.vo2CriteriaUnitList(model1), User.class, "id", String.class);
    }
    
    public List<String> queryUserIdList(CompanyUserQueryModel model1, InvestorUserQueryModel model2) throws ViewException {
        List<String> result = new ArrayList<String>();
        List<String> userIdList1 = daoUtil.queryProperty(CriteriaUtil.vo2CriteriaUnitList(model1), CompanyUser.class, "userId", String.class);
        List<String> userIdList2 = daoUtil.queryProperty(CriteriaUtil.vo2CriteriaUnitList(model2), InvestorUser.class, "userId", String.class);
        result.addAll(userIdList1);
        result.addAll(userIdList2);
        return result;
    }
    
    public List<CompanyUserResultModel> queryCompanyUserList(CompanyUserCombineQueryModel model) throws ViewException {
    	return this.companyUserDAO.combineQueryList(model, null, null).getQueryReturnList();
    }
    
    public List<InvestorUserResultModel> queryInvestorUserList(InvestorUserCombineQueryModel model) throws ViewException {
    	return this.investorUserDAO.combineQueryList(model, null, null).getQueryReturnList();
    }
    
    public List<ResearchUserResultModel> queryResearchUserList(ResearchUserQueryModel model) throws ViewException {
    	return this.researchUserDAO.combineQueryList(model, null, null).getQueryReturnList();
    }
   
    @Override
    public Class<Object> getCurrentClass() {
        return Object.class;
    }

	@Override
	public QueryListReturnVo<ResultModel> combineQueryList(QueryModel model,
			Pagination pagination, CurrentUser user) throws ViewException {
		// TODO Auto-generated method stub
		return null;
	}

}
