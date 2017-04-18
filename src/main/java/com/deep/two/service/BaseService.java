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
package com.deep.two.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.deep.two.authority.model.CurrentUser;
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
public interface BaseService<E> {
    
    public void add(E e, Map<String, MultipartFile> files, CurrentUser user) throws ViewException;
    
    public void add(E e, MultipartFile[] files, CurrentUser user) throws ViewException;
    
    public void update(E e, Serializable id,MultipartFile[] files, CurrentUser user) throws ViewException;
    
    public void delete(List<Serializable> list, CurrentUser user) throws ViewException;
    
    public E getDetail(String id, CurrentUser user) throws ViewException;
    
    public ResultModel getDDetail(String id, CurrentUser user) throws ViewException;

    public void update(E e, Serializable id, Map<String, MultipartFile> files, CurrentUser user) throws ViewException;
    
    public E queryUnique(QueryModel model, CurrentUser user) throws ViewException;
    
    public QueryListReturnVo<E> queryList(QueryModel model, Pagination pagination, CurrentUser user) throws ViewException;
    
    public QueryListReturnVo<? extends ResultModel> combineQueryList(QueryModel model, Pagination pagination, CurrentUser user) throws ViewException;

    public void recommend(RecommendModel rm, CurrentUser user) throws ViewException;
    
    public void approve(ApproveModel am, CurrentUser user) throws ViewException;

	public void updateScanNum(Serializable id, CurrentUser currentUser) throws ViewException;
}
