/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:com.deep.two.dao
 * File Name:AbstractDAO.java
 * Date:2016-4-22 下午6:13:51
 * 
 */
package com.deep.two.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.alibaba.fastjson.JSON;
import com.deep.two.authority.model.CurrentUser;
import com.deep.two.dao.util.CommonProcessUtil;
import com.deep.two.dao.util.CriteriaUtil;
import com.deep.two.dao.util.CriterionUnit;
import com.deep.two.dao.util.DaoUtil;
import com.deep.two.dao.util.IdGenerator;
import com.deep.two.dao.util.Pagination;
import com.deep.two.dao.util.RecommendFlagUtil;
import com.deep.two.dao.util.SeqNumProcessUtil;
import com.deep.two.dao.util.StatusProcessUtil;
import com.deep.two.model.ApproveModel;
import com.deep.two.model.RecommendModel;
import com.deep.two.model.query.QueryModel;
import com.deep.two.model.result.FollowerModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.model.result.ResultModel;
import com.deep.two.orm.Achievement;
import com.deep.two.orm.AchievementFollower;
import com.deep.two.orm.AchievementFollowerId;
import com.deep.two.orm.FundRequirement;
import com.deep.two.orm.FundRequirementFollower;
import com.deep.two.orm.FundRequirementFollowerId;
import com.deep.two.orm.InvestorFollower;
import com.deep.two.orm.InvestorFollowerId;
import com.deep.two.orm.ResearchGroupFollower;
import com.deep.two.orm.ResearchGroupFollowerId;
import com.deep.two.orm.TechRequirement;
import com.deep.two.orm.TechRequirementFollower;
import com.deep.two.orm.TechRequirementFollowerId;
import com.deep.two.util.CopyUtil;
import com.deep.two.util.ViewException;

 /**
 * ClassName: AbstractDAO <br/>
 * Description: TODO <br/>
 * Date: 2016-4-22 下午6:13:51 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */
@Repository
public abstract class AbstractDAO<T> implements BaseDAO<T> {
    
    @Autowired
    @Qualifier("daoUtil")
    protected DaoUtil daoUtil;
    
    public abstract Class<T> getCurrentClass();

    @Override
    public void add(T t, CurrentUser user) throws ViewException {
        if (t instanceof Achievement) {
        	((Achievement) t).setSequenceNumber(IdGenerator.getSequenceNum("A"));
        }
        if (t instanceof TechRequirement) {
        	((TechRequirement) t).setSequenceNumber(IdGenerator.getSequenceNum("R"));
        }
        if (t instanceof FundRequirement) {
        	((FundRequirement) t).setSequenceNumber(IdGenerator.getSequenceNum("F"));
        }
        CommonProcessUtil.setCommon(t, user);
    	daoUtil.insert(t);
    }

    @Override
    public void delete(List<Serializable> list, CurrentUser user) throws ViewException {
    	for(Serializable id : list) {
    		if(id == null || id.toString().equals("")) continue;
    		this.delete(id, user);
    	}
    }
    
    @Override
    public void delete(Serializable id, CurrentUser user) throws ViewException {
    	T t = this.daoUtil.queryById(this.getCurrentClass(), id);
    	CommonProcessUtil.setRemoveFlag(t);
    }
    
    @Override
    public T getDetail(String id, CurrentUser user) throws ViewException {
       return daoUtil.queryById(getCurrentClass(), id);
    }
    
    @Override
    public ResultModel getDDetail(String id, CurrentUser user) throws ViewException {
       return null;
    }

    @Override
    public void update(T t, Serializable id, CurrentUser user) throws ViewException {
    	CommonProcessUtil.updateCommon(t, user);
		T t1 = this.daoUtil.queryById(getCurrentClass(), id);
		this.daoUtil.getCurrentSession().clear();
		CopyUtil.copyProperty(t, t1, getCurrentClass());
    	daoUtil.update(t1);
    }

    @Override
    public T queryUnique(QueryModel model, CurrentUser user) throws ViewException {
    	return daoUtil.uniqueQuery(CriteriaUtil.vo2CriteriaUnitList(model), getCurrentClass());
    }

    @Override
    public QueryListReturnVo<T> queryList(QueryModel model, Pagination pagination, CurrentUser user) throws ViewException {
        List<T> tList = daoUtil.queryList(CriteriaUtil.vo2CriteriaUnitList(model), null, pagination, getCurrentClass());
        if (pagination != null) {
            pagination.setSumRecord(this.daoUtil.queryCount(CriteriaUtil.vo2CriteriaUnitList(model), getCurrentClass()));
        }
        return new QueryListReturnVo<T>(tList, pagination);
    }
    
    @Override
    public QueryListReturnVo<T> queryList(List<CriterionUnit> criteriaUnitList, Pagination pagination, CurrentUser user) throws ViewException {
        List<T> tList = daoUtil.queryList(criteriaUnitList, null, pagination, getCurrentClass());
        if (pagination != null) {
            pagination.setSumRecord(this.daoUtil.queryCount(criteriaUnitList, getCurrentClass()));
        }
        return new QueryListReturnVo<T>(tList, pagination);
    }
    
    @Override
	public QueryListReturnVo<? extends ResultModel> combineQueryList(QueryModel queryModel, Pagination pagination, CurrentUser user) throws ViewException {
		return null;
	}
    
    @Override
    public void recommend(RecommendModel rm, CurrentUser user) throws ViewException {
    	for (Serializable id : rm.getIdList()) {
    		T t = daoUtil.queryById(getCurrentClass(), id);
    		RecommendFlagUtil.setRecommendFlag(t, rm.getRecommendFlag());
    		SeqNumProcessUtil.setSeqNum(t, rm.getSeqNum());
    	}
    }
    
    @Override
    public void approve(ApproveModel am, CurrentUser user) throws ViewException {
    	for (Serializable id : am.getIdList()) {
    		if(getCurrentClass() == InvestorFollower.class) {
    			id = JSON.parseObject(id.toString(), InvestorFollowerId.class);
    		}
    		if(getCurrentClass() == ResearchGroupFollower.class) {
    			id = JSON.parseObject(id.toString(), ResearchGroupFollowerId.class);
    		}
    		if(getCurrentClass() == AchievementFollower.class) {
    			id = JSON.parseObject(id.toString(), AchievementFollowerId.class);
    		}
    		if(getCurrentClass() == TechRequirementFollower.class) {
    			id = JSON.parseObject(id.toString(), TechRequirementFollowerId.class);
    		}
    		if(getCurrentClass() == FundRequirementFollower.class) {
    			id = JSON.parseObject(id.toString(), FundRequirementFollowerId.class);
    		}
    		T t = daoUtil.queryById(getCurrentClass(), id);
    		StatusProcessUtil.setStatus(t, am.getStatus());
    		StatusProcessUtil.setCommunicateStatus(t, am.getCommunicateStatus());
    		StatusProcessUtil.setRemark(t, am.getRemark());
    		daoUtil.update(t);
    	}
    }
    
    @Override
    public void updateScanNum(Serializable id, CurrentUser currentUser) throws ViewException {
    	T t = daoUtil.queryById(getCurrentClass(), id);
    	CommonProcessUtil.setScanNum(t);
    }
    
    public boolean exists(Serializable id) {
    	T t = this.daoUtil.queryById(getCurrentClass(), id);
    	if (t != null) return true;
    	return false;
    }
    
	public void setFlag(Map<String, ?> map, FollowerModel trrm, String id, CurrentUser user) {
		if(user != null) {
			String cooperateId = user.getId()+"_"+id+"_"+"0";
			String collectId = user.getId()+"_"+id+"_"+"1";
			if(map.containsKey(cooperateId)) {
    		   trrm.setCooperateFlag("true");
			} else {
    		   trrm.setCooperateFlag("false");
			}
			if(map.containsKey(collectId)) {
    		   trrm.setCollectFlag("true");
			} else {
    		   trrm.setCooperateFlag("false");
			}
		}
	}
}
