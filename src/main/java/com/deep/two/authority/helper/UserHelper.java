/**
 * Copyright (c) 2015,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:TrafficWebAuthorityService
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
import com.deep.two.authority.checker.UserUniqueChecker;
import com.deep.two.authority.model.CurrentUser;
import com.deep.two.authority.model.RoleModel;
import com.deep.two.authority.model.UserModel;
import com.deep.two.business.BusinessCheck;
import com.deep.two.dao.util.CriteriaUtil;
import com.deep.two.dao.util.CriterionUnit;
import com.deep.two.dao.util.DaoUtil;
import com.deep.two.dao.util.IdProcessUtil;
import com.deep.two.dao.util.Pagination;
import com.deep.two.model.query.authority.UserQueryModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.orm.Role;
import com.deep.two.orm.User;
import com.deep.two.orm.UserRole;
import com.deep.two.orm.UserRoleId;
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
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */
public class UserHelper {

    private DaoUtil daoUtil;
    private UserModel model;

    public UserHelper(UserModel model, DaoUtil daoUtil) {
        this.model = model;
        this.daoUtil = daoUtil;
    }

    public void check() throws ViewException {
        BusinessCheck checker = new UserUniqueChecker(model, daoUtil);
        checker.check();
    }

    public UserModel ormToModel(User orm) throws ViewException {
        UserModel model = CopyUtil.copyProperty(orm, UserModel.class);
        Set<RoleModel> userRoles = new HashSet<RoleModel>();
        for(UserRole cur : orm.getUserRoles()) {
            RoleModel am = CopyUtil.copyProperty(cur.getRole(), RoleModel.class);
            userRoles.add(am);
        }
        model.setRoleModels(userRoles);
        return model;
    }

    public User modelToOrm(CurrentUser currentUser) throws ViewException {
        String md5Password = Md5Singleton.getInstance().encodePassword(model.getPassword(), model.getEmail());
        model.setPassword(md5Password);
        User orm = CopyUtil.copyProperty(model, User.class);
        Set<UserRole> UserRoles = new HashSet<UserRole>();
        IdProcessUtil.setId(orm);

        for (RoleModel rm : model.getRoleModels()) {
            Role role = CopyUtil.copyProperty(rm, Role.class);
            UserRole e = new UserRole();
            UserRoleId id = new UserRoleId(orm.getId(), rm.getId());
            e.setId(id);
            e.setRole(role);
            e.setUser(orm);
            UserRoles.add(e);
        }
        orm.setUserRoles(UserRoles);
        return orm;
    }

    public QueryListReturnVo<UserModel> query(UserQueryModel vo, Pagination pageInfo) throws ViewException {
        List<CriterionUnit> criteriaUnitList = null;
        if (vo != null) {
            criteriaUnitList = CriteriaUtil.vo2CriteriaUnitList(vo);
        }
        List<User> list = this.daoUtil.queryList(criteriaUnitList, null, pageInfo, User.class);
        if (pageInfo != null) {
            pageInfo.setSumRecord(this.daoUtil.queryCount(criteriaUnitList, User.class));
        }

        List<UserModel> modelList = new ArrayList<UserModel>();
        for (User user : list) {
            UserModel model = CopyUtil.copyProperty(user, UserModel.class);
            modelList.add(model);
        }
        return new QueryListReturnVo<UserModel>(modelList, pageInfo);
    }
}
