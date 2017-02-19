package com.deep.two.dao.investorUser;

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
import com.deep.two.model.query.investorUser.InvestorUserCombineQueryModel;
import com.deep.two.model.query.investorUser.InvestorUserFollowerCombineQueryModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.model.result.investorUser.InvestorUserFollowerResultModel;
import com.deep.two.model.result.investorUser.InvestorUserResultModel;
import com.deep.two.orm.InvestorFollower;
import com.deep.two.orm.InvestorFollowerId;
import com.deep.two.orm.InvestorUser;
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
@Repository("investorUserFollowerDAO")
public class InvestorUserFollowerDAO extends AbstractDAO<InvestorFollower> {
	public Map<String, InvestorFollower> queryFollowerListByUser(CurrentUser currentUser) throws ViewException {
		Map<String, InvestorFollower> map = new HashMap<String, InvestorFollower>();
		if(currentUser == null) return map;
		List<CriterionUnit> criteriaUnitList = new ArrayList<CriterionUnit>();
		criteriaUnitList.add(new CriterionUnit("id.userId", currentUser.getId()));
		QueryListReturnVo<InvestorFollower> tmp = this.queryList(criteriaUnitList , null, currentUser);
		if(!CollectionUtil.isEmpty(tmp.getQueryReturnList())) {
			for(InvestorFollower ff : tmp.getQueryReturnList()) {
				map.put(ff.getId().getUserId()+"_"+ff.getId().getInvestorId()+"_"+ff.getId().getRelationType(), ff);
			}
			return map;
		}
		return map;
    }
	
	@Override
    public void add(InvestorFollower t, CurrentUser user) throws ViewException {
		if (exists(t.getId())) {
			if (t.getId().getRelationType().equals("0")) {
				throw new ViewException("您已经提交寻求合作申请。");
			} else {
				throw new ViewException("您已经收藏此信息。");
			}
		}
		InvestorUser rg = this.daoUtil.queryById(InvestorUser.class, t.getId().getInvestorId());
        if (rg != null && t.getId().getRelationType().equals("1")) {
//        	if(rg.getConcernNumber() == null) {
//        		rg.setConcernNumber(1);
//        	} else {
//        		rg.setConcernNumber(rg.getConcernNumber()+1);
//        	}
        }
        CommonProcessUtil.setCommon(t, user);
        daoUtil.insert(t);
    }
	
	@Override
    public void delete(List<Serializable> list, CurrentUser user) throws ViewException {
    	for(Serializable id : list) {
    		InvestorFollowerId dd = (InvestorFollowerId)id;
    		InvestorFollower af = this.daoUtil.queryById(getCurrentClass(), dd);
    		InvestorUser rg = this.daoUtil.queryById(InvestorUser.class, dd.getInvestorId());
	        if (rg != null && af.getId().getRelationType().equals("1")) {
//	            rg.setConcernNumber(rg.getConcernNumber()-1);
	        }
	        this.daoUtil.deleteById(id, getCurrentClass());
    	}
    }
    
	@Override
    public QueryListReturnVo<InvestorUserFollowerResultModel> combineQueryList(QueryModel model2, Pagination pageInfo, CurrentUser user) throws ViewException {
		if(model2 == null) {
			model2 = new InvestorUserFollowerCombineQueryModel();
		}
		InvestorUserFollowerCombineQueryModel model = (InvestorUserFollowerCombineQueryModel)model2;
    	Criteria criteria = getCriteria(model);
        Criteria criteriaCount = getCriteria(model);
        List<OrderUnit> orderList = new ArrayList<OrderUnit>();
        
        List<InvestorFollower> records = this.daoUtil.queryList(criteria, orderList, pageInfo);
        List<InvestorUserFollowerResultModel> list = new ArrayList<InvestorUserFollowerResultModel>();
    	Map<String, InvestorFollower> map = this.queryFollowerListByUser(user);
        for(InvestorFollower rg : records) {
        	InvestorUserFollowerResultModel frfrm = CopyUtil.copyProperty(rg, InvestorUserFollowerResultModel.class);
        	UserModel um = CopyUtil.copyProperty(rg.getUser(), UserModel.class);
        	frfrm.setUserModel(um);
        	InvestorUserResultModel frrm = CopyUtil.copyProperty(rg.getInvestorUser(), InvestorUserResultModel.class);
        	frfrm.setInvestorUserResultModel(frrm);
      	    this.setFlag(map, frrm, frrm.getId(), user);
        	list.add(frfrm);
        }
        // 调用方法查询sum Record
        if (pageInfo != null) {
            pageInfo.setSumRecord(this.daoUtil.queryCount(criteriaCount));
        }
        return new QueryListReturnVo<InvestorUserFollowerResultModel>(list, pageInfo);
    }
    
    private Criteria getCriteria(InvestorUserFollowerCombineQueryModel model) throws ViewException {
        Criteria criteria = daoUtil.getCurrentSession().createCriteria(InvestorFollower.class);
        Criterion investorFollowerCriterion = getInvestorFollowerCriterion(model);
        Criterion investorUserCriterion = getInvestorUserCriterion(model);
        Criterion userCriterion = getUserCriterion(model);
        
        if (investorFollowerCriterion != null) {
            criteria.add(investorFollowerCriterion);
        }
        if (investorUserCriterion != null) {
            criteria.createCriteria("investorUser").add(investorUserCriterion);
        }
        if (userCriterion != null) {
            criteria.createCriteria("user").add(userCriterion);
        }
        return criteria;
    }
    
    private Criterion getInvestorFollowerCriterion(InvestorUserFollowerCombineQueryModel model) throws ViewException {
    	 List<CriterionUnit> criteriaUnitList = null;
         if (model.getInvestorUserQueryModel() != null) {
             criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getInvestorUserFollowerQueryModel());
         }
         return CriterionUtil.createCriterion(criteriaUnitList);
	}

	private Criterion getInvestorUserCriterion(InvestorUserFollowerCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getInvestorUserQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getInvestorUserQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }

    private Criterion getUserCriterion(InvestorUserFollowerCombineQueryModel model) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (model.getUserQueryModel() != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(model.getUserQueryModel());
        }
        return CriterionUtil.createCriterion(criteriaUnitList);
    }

	@Override
	public Class<InvestorFollower> getCurrentClass() {
		return InvestorFollower.class;
	}
}
