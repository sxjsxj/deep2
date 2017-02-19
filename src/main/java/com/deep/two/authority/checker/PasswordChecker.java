/**
 * Copyright (c) 2015,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:TrafficWebUserService
 * Package Name:com.travelsky.fare.service.authority.checker
 * File Name:UserNameUniqueChecker.java
 * Date:2015-7-10 下午2:59:48
 * 
 */
package com.deep.two.authority.checker;

import com.deep.two.authority.helper.Md5Singleton;
import com.deep.two.authority.model.PasswordModel;
import com.deep.two.business.BusinessCheck;
import com.deep.two.dao.util.DaoUtil;
import com.deep.two.orm.User;
import com.deep.two.util.ViewException;


 /**
 * ClassName: UserNameUniqueChecker <br/>
 * Description: TODO <br/>
 * Date: 2015-7-10 下午2:59:48 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

public class PasswordChecker implements BusinessCheck {
    private DaoUtil daoUtil;
    private PasswordModel model;
    
    public PasswordChecker(PasswordModel model, DaoUtil daoUtil) {
        this.model = model;
        this.daoUtil = daoUtil;
    }

    @Override
    public void check() throws ViewException {
        User user =  this.daoUtil.queryById(User.class, model.getId());
        if (user == null) {
            throw new ViewException("用户不存在");
        }
        String oldPassword = model.getOldPassword();
        String userName = user.getEmail();
        String oldMd5Password = Md5Singleton.getInstance().encodePassword(oldPassword, userName);

        if (!user.getPassword().equals(oldMd5Password)) {
            throw new ViewException("旧密码错误！");
        } 
    }
}
