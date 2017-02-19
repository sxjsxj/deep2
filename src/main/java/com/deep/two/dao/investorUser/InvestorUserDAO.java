package com.deep.two.dao.investorUser;

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
import com.deep.two.dao.util.CriteriaUtil;
import com.deep.two.dao.util.CriterionUnit;
import com.deep.two.dao.util.CriterionUtil;
import com.deep.two.dao.util.OrderUnit;
import com.deep.two.dao.util.Pagination;
import com.deep.two.dao.util.StatusProcessUtil;
import com.deep.two.model.ApproveModel;
import com.deep.two.model.query.QueryModel;
import com.deep.two.model.query.companyUser.FundRequirementFollowerCombineQueryModel;
import com.deep.two.model.query.investorUser.InvestorUserCombineQueryModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.model.result.ResultModel;
import com.deep.two.model.result.investorUser.InvestorUserResultModel;
import com.deep.two.orm.InvestorFollower;
import com.deep.two.orm.InvestorUser;
import com.deep.two.orm.ResearchUser;
import com.deep.two.util.CollectionUtil;
import com.deep.two.util.CopyUtil;
import com.deep.two.util.ViewException;

 /**
 * ClassName: InvestorUserDAO <br/>
 * Description: TODO <br/>
 * Date: 2016-4-21 上午11:05:46 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */
@Repository("investorUserDAO")
public class InvestorUserDAO extends AbstractDAO<InvestorUser> {
	@Autowired
	private InvestorUserFollowerDAO InvestorUserFollowerDAO;
	
	public Map<String, InvestorFollower> queryFollowerListByUser(CurrentUser currentUser) throws ViewException {
		Map<String, InvestorFollower> map = new HashMap<String, InvestorFollower>();
		if(currentUser == null) return map;
		List<CriterionUnit> criteriaUnitList = new ArrayList<CriterionUnit>();
		criteriaUnitList.add(new CriterionUnit("id.userId", currentUser.getId()));
		QueryListReturnVo<InvestorFollower> tmp = this.InvestorUserFollowerDAO.queryList(criteriaUnitList , null, currentUser);
		if(!CollectionUtil.isEmpty(tmp.getQueryReturnList())) {
			for(InvestorFollower ff : tmp.getQueryReturnList()) {
				map.put(ff.getId().getUserId()+"_"+ff.getId().getInvestorId()+"_"+ff.getId().getRelationType(), ff);
			}
			return map;
		}
		return map;
    }
	
	@Override
    public ResultModel getDDetail(String id, CurrentUser user) throws ViewException {
		InvestorUser rg = this.getDetail(id, user);
		InvestorUserResultModel iurm = CopyUtil.copyProperty(rg, InvestorUserResultModel.class);
		UserModel um = CopyUtil.copyProperty(rg.getUser(), UserModel.class);
		iurm.setUserModel(um);
    	Map<String, InvestorFollower> map = this.queryFollowerListByUser(user);
  	    this.setFlag(map, iurm, id, user);
	   return iurm;
    }
    
	@Override
    public QueryListReturnVo<InvestorUserResultModel> combineQueryList(QueryModel model2, Pagination pageInfo, CurrentUser user) throws ViewException {
		if(model2 == null) {
			model2 = new InvestorUserCombineQueryModel();
		}
		InvestorUserCombineQueryModel model = (InvestorUserCombineQueryModel)model2;
    	Criteria criteria = getCriteria(model);
        Criteria criteriaCount = getCriteria(model);
        List<OrderUnit> orderList = new ArrayList<OrderUnit>();
        orderList.add(new OrderUnit("seqNum", OrderUnit.DESC));
        //orderList.add(new OrderUnit("concernNumber", OrderUnit.DESC));
        orderList.add(new OrderUnit("whenLastUpdate", OrderUnit.DESC));
        
        List<InvestorUser> records = this.daoUtil.queryList(criteria, orderList, pageInfo);
        List<InvestorUserResultModel> list = new ArrayList<InvestorUserResultModel>();
    	Map<String, InvestorFollower> map = this.queryFollowerListByUser(user);
        for(InvestorUser rg : records) {
        	InvestorUserResultModel iurm = CopyUtil.copyProperty(rg, InvestorUserResultModel.class);
        	UserModel um = CopyUtil.copyProperty(rg.getUser(), UserModel.class);
        	iurm.setUserModel(um);
      	    this.setFlag(map, iurm, rg.getId(), user);
        	list.add(iurm);
        }
        // 调用方法查询sum Record
        if (pageInfo != null) {
            pageInfo.setSumRecord(this.daoUtil.queryCount(criteriaCount));
        }
        return new QueryListReturnVo<InvestorUserResultModel>(list, pageInfo);
    }
    
    private Criteria getCriteria(InvestorUserCombineQueryModel model) throws ViewException {
        Criteria criteria = daoUtil.getCurrentSession().createCriteria(InvestorUser.class);
        Criterion InvestorUserCriterion = getInvestorUserCriterion(model);
        Criterion userCriterion = getUserCriterion(model);
        
        if (InvestorUserCriterion != null) {
            criteria.add(InvestorUserCriterion);
        }
        if (userCriterion != null) {
            criteria.createCriteria("user").add(userCriterion);
        }
        return criteria;
    }
    
    private Criterion getInvestorUserCriterion(InvestorUserCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getInvestorUserQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getInvestorUserQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }

    private Criterion getUserCriterion(InvestorUserCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getUserQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getUserQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }

	@Override
	public Class<InvestorUser> getCurrentClass() {
		return InvestorUser.class;
	}
	
	@Override
	public void approve(ApproveModel am, CurrentUser user) throws ViewException {
		for (Serializable id : am.getIdList()) {
			InvestorUser t = daoUtil.queryById(getCurrentClass(), id);
			StatusProcessUtil.setStatus(t.getUser(), am.getStatus());
			StatusProcessUtil.setCommunicateStatus(t.getUser(), am.getCommunicateStatus());
			StatusProcessUtil.setRemark(t.getUser(), am.getRemark());
			StatusProcessUtil.setStatus(t, am.getStatus());
			StatusProcessUtil.setCommunicateStatus(t, am.getCommunicateStatus());
			//StatusProcessUtil.setRemark(t, am.getRemark());
			daoUtil.update(t);
		}
	}
}
