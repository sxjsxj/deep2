/**
 * Copyright (c) 2015,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:TrafficWebRoleService
 * Package Name:com.travelsky.fare.service.authority.helper
 * File Name:UserHelper.java
 * Date:2015-7-3 下午4:07:15
 * 
 */
package com.deep.two.authority.helper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.deep.two.authority.checker.RoleUniqueChecker;
import com.deep.two.authority.model.CurrentUser;
import com.deep.two.authority.model.ResourceModel;
import com.deep.two.authority.model.RoleModel;
import com.deep.two.authority.model.RoleQueryVO;
import com.deep.two.business.BusinessCheck;
import com.deep.two.dao.util.CriteriaUtil;
import com.deep.two.dao.util.CriterionUnit;
import com.deep.two.dao.util.DaoUtil;
import com.deep.two.dao.util.IdProcessUtil;
import com.deep.two.dao.util.Pagination;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.orm.Resource;
import com.deep.two.orm.Role;
import com.deep.two.orm.RoleResource;
import com.deep.two.orm.RoleResourceId;
import com.deep.two.util.CopyUtil;
import com.deep.two.util.ViewException;

 /**
 * ClassName: UserHelper <br/>
 * Description: TODO <br/>
 * Date: 2015-7-3 下午4:07:15 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */
public class RoleHelper {
    
    private DaoUtil daoUtil;
    private RoleModel model;
    
    public RoleHelper(RoleModel model, DaoUtil daoUtil) {
        this.model = model;
        this.daoUtil = daoUtil;
    }
    
    public void check() throws ViewException{
        BusinessCheck checker;
        checker = new RoleUniqueChecker(model, daoUtil);
        checker.check();
    }
    
    public RoleModel ormToModel(Role orm) throws ViewException {
        RoleModel model = CopyUtil.copyProperty(orm, RoleModel.class);
        Set<ResourceModel> roleResources = new HashSet<ResourceModel>();
        for(RoleResource cra : orm.getRoleResources()) {
        	Resource resource = cra.getResource();
            ResourceModel rm = CopyUtil.copyProperty(resource, ResourceModel.class);
            roleResources.add(rm);
        }
        model.setResourceModels(roleResources);
        return model;
    }
    
    public Role modelToOrm(CurrentUser userModel) throws ViewException {
        Role orm = CopyUtil.copyProperty(model, Role.class);
        Set<RoleResource> roleResources = new HashSet<RoleResource>();

        IdProcessUtil.setId(orm);
        this.daoUtil.getCurrentSession().clear();
        for(ResourceModel am : model.getResourceModels()) {
            Resource resource = CopyUtil.copyProperty(am, Resource.class);
            RoleResource e = new RoleResource();
            RoleResourceId id = new RoleResourceId(orm.getId(), am.getId());
            e.setId(id);
            e.setRole(orm);
            e.setResource(resource);
            roleResources.add(e);
        }
        orm.setRoleResources(roleResources);
        return orm;
    }
    
    public QueryListReturnVo<RoleModel> query(RoleQueryVO vo, Pagination pageInfo) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (vo != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(vo);
        }
        List<Role> list = this.daoUtil.queryList(criteriaUnitList, null, pageInfo, Role.class);
        if (pageInfo != null) {
            pageInfo.setSumRecord(this.daoUtil.queryCount(criteriaUnitList, Role.class));
        }
        
        List<RoleModel> modelList = new ArrayList<RoleModel>();
        for(Role role : list) {
            RoleModel model = CopyUtil.copyProperty(role, RoleModel.class);
            modelList.add(model);
        }
        return new QueryListReturnVo<RoleModel>(modelList, pageInfo);
    }
}
