/**
 * Copyright (c) 2015,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:TrafficWebAuthorityService
 * Package Name:com.travelsky.fare.service.authority.checker
 * File Name:UserNameUniqueChecker.java
 * Date:2015-7-10 下午2:59:48
 * 
 */
package com.deep.two.authority.checker;

import java.util.ArrayList;
import java.util.List;

import com.deep.two.authority.model.ResourceModel;
import com.deep.two.business.BusinessCheck;
import com.deep.two.dao.util.CriterionUnit;
import com.deep.two.dao.util.DaoUtil;
import com.deep.two.orm.Resource;
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

public class ResourceUniqueChecker implements BusinessCheck {
    private DaoUtil daoUtil;
    private ResourceModel model;
    
    public ResourceUniqueChecker(ResourceModel model, DaoUtil daoUtil) {
        this.model = model;
        this.daoUtil = daoUtil;
    }

    @Override
    public void check() throws ViewException {
        List<CriterionUnit> cuList = new ArrayList<CriterionUnit>();
        if (model.getId() == null) {
            cuList.add(new CriterionUnit("resourceName", model.getResourceName()));
            int count = daoUtil.queryCount(cuList, Resource.class);
            if (count > 0) {
                throw new ViewException("资源名称已经存在！");
            }
            cuList.clear();
            cuList.add(new CriterionUnit("resourceString", model.getResourceStr()));
            count = daoUtil.queryCount(cuList, Resource.class);
            if (count > 0) {
                throw new ViewException("资源路径已经存在！");
            }
        } 
    }
}
