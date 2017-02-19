/**
 * Copyright (c) 2014,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:airtisweb-service-authority
 * Package Name:com.travelsky.fare.airtisweb.service.authority.impl
 * File Name:UserExtendService.java
 * Date:2014-8-20 下午3:59:32
 * 
 */
package com.deep.two.authority.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.deep.two.authority.model.UserExtend;
import com.deep.two.authority.model.UserModel;
import com.deep.two.dao.CommonDAO;
import com.deep.two.dao.util.DaoUtil;
import com.deep.two.model.query.authority.UserQueryModel;
import com.deep.two.model.query.companyUser.CompanyUserCombineQueryModel;
import com.deep.two.model.query.investorUser.InvestorUserCombineQueryModel;
import com.deep.two.model.query.researchUser.ResearchUserQueryModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.orm.User;
import com.deep.two.orm.UserRole;
import com.deep.two.service.authority.UserService;
import com.deep.two.util.CopyUtil;
import com.deep.two.util.ViewException;

/**
 * ClassName: UserExtendService <br/>
 * Description: 根据SS的框架 编写符合SS框架的用户处理器<br/>
 * Date: 2014-8-20 下午3:59:32 <br/>
 * <br/>
 * 
 * @author zangling(邮箱)
 * 
 *         修改记录
 * @version 产品版本信息 2014-08-20 zangl(zangl@) 修改信息<br/>
 * 
 */
public class UserExtendService implements UserDetailsService {

    private static final Logger LOGGER = Logger.getLogger(UserExtendService.class);
    private static final String USER = " User:";
    @Autowired
    private DaoUtil daoUtil;
    @Autowired
    private CommonDAO commonDAO;
    @Autowired
    private UserService userService;
    

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Assert.notNull(email, "用户名不能为空！");

        UserExtend userExtend = new UserExtend(email, null, null);
        User user = null;
        // 根据用户名查询User对象
        try {
//            Criteria criteria = daoUtil.getCurrentSession().createCriteria(CpubTUser.class);
//            criteria.add(CriterionUtil.createCriterion(this.queryConditionFromUserTable(username)));
//            user = (CpubTUser)criteria.uniqueResult();
            StringBuffer hql = new StringBuffer();
            hql.append("from User where email='"+email+"'");
            /*UserQueryModel model = new UserQueryModel();
            model.setEmail(email);
            QueryListReturnVo<UserModel> returnVo = this.userService.query(model , null)*/;
            user = (User)this.daoUtil.getCurrentSession().createQuery(hql.toString()).uniqueResult();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        if (user == null) {
            throw new UsernameNotFoundException(UserExtendService.USER + email + " not found.");
        }
        try {
            userExtend = this.createUserExtend(user);
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
        }
        return userExtend;
    }

    /**
     * createUserExtend:将数据库的用户模型转化成系统内部符合SS框架的模型UserExtend <br/>
     * 
     * @param userFromDB 对应数据库的类。
     * @return 符合SS框架的 User对象类 UserExtend <br/>
     * @throws ViewException
     */
    private UserExtend createUserExtend(User user) throws ViewException {
        UserExtend userExtend = CopyUtil.copyProperty(user, UserExtend.class);
        String id = user.getId();
		UserQueryModel uqm = new UserQueryModel();
		uqm.setId(id);
		userExtend.setCompanyUserModels(this.commonDAO.queryCompanyUserList(new CompanyUserCombineQueryModel(uqm, null)));
		userExtend.setInvestorUserModels(this.commonDAO.queryInvestorUserList(new InvestorUserCombineQueryModel(uqm, null)));
		userExtend.setResearchUserModels(this.commonDAO.queryResearchUserList(new ResearchUserQueryModel(uqm, null, null)));
        Set<GrantedAuthority> gaSet = new HashSet<GrantedAuthority>();
        for (UserRole ctr : user.getUserRoles()) {
            if ("0".equals(ctr.getEnabled())) {
                continue;
            }
            gaSet.add(new SimpleGrantedAuthority(ctr.getRole().getRoleName()));
        }
        userExtend.setAuthorities(gaSet);
        return userExtend;
    }
}
