/**
 * Copyright (c) 2015,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:TrafficWebAuthorityService
 * Package Name:com.travelsky.fare.service.authority.impl
 * File Name:ResourceServiceImpl.java
 * Date:2015-7-6 下午3:58:42
 * 
 */
package com.deep.two.service.authority.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.deep.two.authority.helper.ResourceHelper;
import com.deep.two.authority.model.CurrentUser;
import com.deep.two.authority.model.ResourceModel;
import com.deep.two.authority.model.ResourceQueryVO;
import com.deep.two.dao.util.CriterionUnit;
import com.deep.two.dao.util.DaoUtil;
import com.deep.two.dao.util.OrderUnit;
import com.deep.two.dao.util.Pagination;
import com.deep.two.model.result.DMLResultModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.orm.Resource;
import com.deep.two.orm.RoleResource;
import com.deep.two.service.authority.ResourceService;
import com.deep.two.util.CopyUtil;
import com.deep.two.util.ViewException;

/**
 * ClassName: ResourceServiceImpl <br/>
 * Description: TODO <br/>
 * Date: 2015-7-6 下午3:58:42 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */
@Service("resourceService")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    @Qualifier("daoUtil")
    private transient DaoUtil daoUtil;
    private ResourceHelper helper;

    @Override
    public List<ResourceModel> queryAll() throws ViewException {
        helper = new ResourceHelper(null, daoUtil);
        List<ResourceModel> modelList = new ArrayList<ResourceModel>();
        List<OrderUnit> orderList = new ArrayList<OrderUnit>();
        orderList.add(new OrderUnit("resourceName", OrderUnit.ASC));
        List<Resource> list = daoUtil.queryList(this.getCondition(), orderList, null, Resource.class);
        for (Resource resource : list) {
            modelList.add(helper.ormToModel(resource));
        }
        return modelList;
    }

    /**
     * getCondition:得到查询条件 <br/>
     * 
     * @return List<CriterionUnit>查询条件 enable=1 <br/>
     */
    private List<CriterionUnit> getCondition() {
        List<CriterionUnit> criteriaUnitList = new ArrayList<CriterionUnit>();
        return criteriaUnitList;
    }

    @Override
    public DMLResultModel insert(ResourceModel resourceModel, CurrentUser user) throws ViewException{
        Assert.notNull(resourceModel, "resourceModel对象不能为空");
        helper = new ResourceHelper(resourceModel, daoUtil);
        helper.check();
        Resource orm = helper.modelToOrm(user);
        this.daoUtil.insert(orm);
        return new DMLResultModel(DMLResultModel.SUCCESS);
    }

    @Override
    public ResourceModel getDetail(String id) throws ViewException {
        Assert.notNull(id, "id不能为空");
        Resource resource = this.daoUtil.queryById(Resource.class, id);
        ResourceModel model = CopyUtil.copyProperty(resource, ResourceModel.class);
        return model;
    }

    @Override
    public DMLResultModel update(ResourceModel resourceModel, CurrentUser user) throws ViewException {
        Assert.notNull(resourceModel, "resourceModel对象不能为空");
        Assert.notNull(resourceModel.getId(), "更新时，id不能为空");
        helper = new ResourceHelper(resourceModel, daoUtil);
        helper.check();
        Resource orm = helper.modelToOrm(user);
        this.daoUtil.updateDBObject(Resource.class, orm.getId(), orm);
        return new DMLResultModel(DMLResultModel.SUCCESS);
    }

    @Override
    public DMLResultModel delete(List<String> idList) throws ViewException {
        for (String id : idList) {
            Resource resource = this.daoUtil.queryById(Resource.class, id);
            if (resource == null) {
                continue;
            }
            for (RoleResource rr : resource.getRoleResources()) {
                rr.getRole().setRoleResources(null);
            }
            this.daoUtil.delete(resource);
        }
        return new DMLResultModel(DMLResultModel.SUCCESS);
    }

    @Override
    public QueryListReturnVo<ResourceModel> query(ResourceQueryVO queryVO, Pagination pagination) throws ViewException {
        helper = new ResourceHelper(null, daoUtil);
        return helper.query(queryVO, pagination);
    }
}
