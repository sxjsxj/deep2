/**
 * Copyright (c) 2015,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:TrafficWebRoleService
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

import com.deep.two.authority.helper.RoleHelper;
import com.deep.two.authority.model.CurrentUser;
import com.deep.two.authority.model.ResourceModel;
import com.deep.two.authority.model.RoleModel;
import com.deep.two.authority.model.RoleQueryVO;
import com.deep.two.dao.util.CriterionUnit;
import com.deep.two.dao.util.DaoUtil;
import com.deep.two.dao.util.OrderUnit;
import com.deep.two.dao.util.Pagination;
import com.deep.two.model.result.DMLResultModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.orm.Role;
import com.deep.two.orm.RoleResource;
import com.deep.two.orm.UserRole;
import com.deep.two.service.authority.RoleService;
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
@Service("roleService")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {

    @Autowired
    @Qualifier("daoUtil")
    private transient DaoUtil daoUtil;

    private RoleHelper helper;

    @Override
    public List<RoleModel> queryAll() throws ViewException {
        helper = new RoleHelper(null, daoUtil);
        List<OrderUnit> orderList = new ArrayList<OrderUnit>();
        orderList.add(new OrderUnit("roleName", OrderUnit.ASC));
        List<Role> list = daoUtil.queryList(this.getCondition(), orderList, null, Role.class);
        List<RoleModel> modelList = new ArrayList<RoleModel>();
        for (Role authority : list) {
            modelList.add(helper.ormToModel(authority));
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
    public DMLResultModel insert(RoleModel model, CurrentUser user) throws ViewException {
        Assert.notNull(model, "model对象不能为空");
        helper = new RoleHelper(model, daoUtil);
        helper.check();
        Role orm = helper.modelToOrm(user);
        this.daoUtil.insert(orm);
        return new DMLResultModel(DMLResultModel.SUCCESS);
    }

    @Override
    public RoleModel getDetail(String id) throws ViewException {
        Assert.notNull(id, "id不能为空");
        Role role = this.daoUtil.queryById(Role.class, id);
        RoleModel modelReturn = CopyUtil.copyProperty(role, RoleModel.class);
        for (RoleResource rr : role.getRoleResources()) {
            ResourceModel rm = CopyUtil.copyProperty(rr.getResource(), ResourceModel.class);
            modelReturn.getResourceModels().add(rm);
        }
        return modelReturn;
    }

    @Override
    public DMLResultModel update(RoleModel model, CurrentUser user) throws ViewException {
        Assert.notNull(model, "model对象不能为空");
        Assert.notNull(model.getId(), "更新时，id不能为空");
        helper = new RoleHelper(model, daoUtil);
        helper.check();
        this.daoUtil.getCurrentSession().clear();
        Role Role = this.daoUtil.queryById(Role.class, model.getId());
        for (RoleResource cta : Role.getRoleResources()) {
            cta.getRole().setRoleResources(null);
            this.daoUtil.delete(cta);
        }
        this.daoUtil.getCurrentSession().flush();
        Role orm = helper.modelToOrm(user);
        this.daoUtil.updateDBObject(Role.class, model.getId(), orm);
        return new DMLResultModel(DMLResultModel.SUCCESS);
    }

    @Override
    public DMLResultModel delete(List<String> idList) throws ViewException {
        for (String id : idList) {
            Role role = this.daoUtil.queryById(Role.class, id);
            if (role == null) {
                continue;
            }
            for (RoleResource cra : role.getRoleResources()) {
                cra.getResource().setRoleResources(null);
            }
            for (UserRole cur : role.getUserRoles()) {
                cur.getUser().setUserRoles(null);
            }
            this.daoUtil.delete(role);
        }
        return new DMLResultModel(DMLResultModel.SUCCESS);
    }

    @Override
    public QueryListReturnVo<RoleModel> query(RoleQueryVO queryVO, Pagination pagination) throws ViewException {
        helper = new RoleHelper(null, daoUtil);
        return helper.query(queryVO, pagination);
    }
}
