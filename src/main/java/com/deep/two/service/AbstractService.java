/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:com.deep.two.service
 * File Name:AbstractService.java
 * Date:2016-4-28 下午5:11:18
 * 
 */
package com.deep.two.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.deep.two.authority.model.CurrentUser;
import com.deep.two.controller.util.FileHelper;
import com.deep.two.dao.BaseDAO;
import com.deep.two.dao.util.IdProcessUtil;
import com.deep.two.dao.util.Pagination;
import com.deep.two.dao.util.UrlProcessUtil;
import com.deep.two.model.ApproveModel;
import com.deep.two.model.RecommendModel;
import com.deep.two.model.query.QueryModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.model.result.ResultModel;
import com.deep.two.util.AttachConstant;
import com.deep.two.util.ViewException;

 /**
 * ClassName: AbstractService <br/>
 * Description: TODO <br/>
 * Date: 2016-4-28 下午5:11:18 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
public abstract class AbstractService<T extends BaseDAO<E>, E> implements BaseService<E> {
	
	@Autowired
	private FileHelper fileHelper;
	
	public abstract String getPath();
	
    public abstract T getT();
    
    @Override
    public void add(E e, MultipartFile[] files, CurrentUser user) throws ViewException {
    	IdProcessUtil.setId(e);
    	this.getT().add(e, user);
    }

    @Override
    public void add(E e, Map<String, MultipartFile> files, CurrentUser user) throws ViewException {
        if (files == null || files.size() == 0) {
        	IdProcessUtil.setId(e);
        	this.getT().add(e, user);
        } else {
        	IdProcessUtil.setId(e);
        	String id = IdProcessUtil.getId(e);
        	MultipartFile logoFile = files.get(AttachConstant.LOGOFILE);
    		if (logoFile != null) {
    			UrlProcessUtil.setLogoUrl(e, getPath(), id, logoFile.getOriginalFilename());
    		}
    		MultipartFile leaderFile = files.get(AttachConstant.LEADERFILE);
    		if (leaderFile != null) {
    			UrlProcessUtil.setLeaderUrl(e, getPath(), id, leaderFile.getOriginalFilename());
    		} 
    		MultipartFile attachFile = files.get(AttachConstant.ATTACHFILE);
    		if (logoFile != null) {
    			UrlProcessUtil.setAttachUrl(e, getPath(), id, attachFile.getOriginalFilename());
        	}
        	this.getT().add(e, user);
        	fileHelper.saveFile(getPath(), id, files);
        }
    }

    @Override
    public void delete(List<Serializable> list, CurrentUser user) throws ViewException {
        this.getT().delete(list, user);
    }
    
    @Override
    public E getDetail(String id, CurrentUser user) throws ViewException {
        return this.getT().getDetail(id, user);
    }
    
    @Override
    public ResultModel getDDetail(String id, CurrentUser user) throws ViewException {
    	 return this.getT().getDDetail(id, user);
    }
    
    @Override
    public void update(E e, Serializable id, MultipartFile[] files, CurrentUser user) throws ViewException {
    	this.getT().update(e, id, user);
    }

    @Override
    public void update(E e, Serializable id, Map<String, MultipartFile> files, CurrentUser user) throws ViewException {
    	if (files == null || files.size() == 0) {
            this.getT().update(e, id, user);
        } else {
        	String idStr = (String)id;
        	MultipartFile logoFile = files.get(AttachConstant.LOGOFILE);
    		if (logoFile != null) {
    			UrlProcessUtil.setLogoUrl(e, getPath(), idStr, logoFile.getOriginalFilename());
    		}
    		MultipartFile leaderFile = files.get(AttachConstant.LEADERFILE);
    		if (leaderFile != null) {
    			UrlProcessUtil.setLeaderUrl(e, getPath(), idStr, leaderFile.getOriginalFilename());
    		} 
    		MultipartFile attachFile = files.get(AttachConstant.ATTACHFILE);
    		if (logoFile != null) {
    			UrlProcessUtil.setAttachUrl(e, getPath(), idStr, attachFile.getOriginalFilename());
        	}
            this.getT().update(e, id, user);
        	fileHelper.saveFile(getPath(), (String)id, files);
        }
    }

    @Override
    public E queryUnique(QueryModel model, CurrentUser user) throws ViewException {
        return this.getT().queryUnique(model, user);
    }

    @Override
    public QueryListReturnVo<E> queryList(QueryModel model, Pagination pagination, CurrentUser user) throws ViewException {
        return this.getT().queryList(model, pagination, user);
    }
    
    @Override
    public QueryListReturnVo<? extends ResultModel> combineQueryList(QueryModel model, Pagination pagination, CurrentUser user) throws ViewException {
        return this.getT().combineQueryList(model, pagination, user);
    }
    
    @Override
    public void recommend(RecommendModel rm, CurrentUser user) throws ViewException {
    	 this.getT().recommend(rm, user);
    }
    
    @Override
    public void approve(ApproveModel am, CurrentUser currentUser) throws ViewException{
    	this.getT().approve(am, currentUser);
    }
    
    @Override
    public void updateScanNum(Serializable id, CurrentUser currentUser) throws ViewException {
    	this.getT().updateScanNum(id, currentUser);
    }
}
