/**
 * Copyright (c) 2015,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:TrafficWebDAO
 * Package Name:com.travelsky.fare.trafficweb.dao
 * File Name:BaseDAO.java
 * Date:2015-3-24 下午7:29:39
 * 
 */
package com.deep.two.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.deep.two.authority.model.CurrentUser;
import com.deep.two.dao.util.CriterionUnit;
import com.deep.two.dao.util.Pagination;
import com.deep.two.model.ApproveModel;
import com.deep.two.model.RecommendModel;
import com.deep.two.model.query.QueryModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.model.result.ResultModel;
import com.deep.two.util.ViewException;

 /**
 * ClassName: BaseDAO <br/>
 * Description: TODO <br/>
 * Date: 2015-3-24 下午7:29:39 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */
@Repository
public interface BaseDAO<T> {
    
    public void add(T t, CurrentUser user) throws ViewException;
    
    public void delete(List<Serializable> list, CurrentUser user) throws ViewException;
    
    public void delete(Serializable id, CurrentUser user) throws ViewException;
    
    public T getDetail(String id, CurrentUser user) throws ViewException;
    	
    public ResultModel getDDetail(String id, CurrentUser user) throws ViewException;

    public void update(T t, Serializable id, CurrentUser user) throws ViewException;
    
    public T queryUnique(QueryModel model, CurrentUser user) throws ViewException;
    
    public QueryListReturnVo<T> queryList(QueryModel model, Pagination pagination, CurrentUser user) throws ViewException;
    public QueryListReturnVo<T> queryList(List<CriterionUnit> criteriaUnitList, Pagination pagination, CurrentUser user) throws ViewException;
    
    public QueryListReturnVo<? extends ResultModel> combineQueryList(QueryModel model, Pagination pagination, CurrentUser user) throws ViewException;
    
    public void recommend(RecommendModel rm, CurrentUser user) throws ViewException;
    
    public void approve(ApproveModel am, CurrentUser user) throws ViewException;
    
    public void updateScanNum(Serializable id, CurrentUser currentUser) throws ViewException;
    
    //根据currentUser的userId查询当前用户关注的技术需求
    //public List<?> queryFollowerListByUser(CurrentUser currentUser) throws ViewException;
}
