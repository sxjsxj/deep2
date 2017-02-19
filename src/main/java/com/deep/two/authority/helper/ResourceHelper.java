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
import java.util.List;

import com.deep.two.authority.checker.ResourceUniqueChecker;
import com.deep.two.authority.model.CurrentUser;
import com.deep.two.authority.model.ResourceModel;
import com.deep.two.authority.model.ResourceQueryVO;
import com.deep.two.business.BusinessCheck;
import com.deep.two.dao.util.CriteriaUtil;
import com.deep.two.dao.util.CriterionUnit;
import com.deep.two.dao.util.DaoUtil;
import com.deep.two.dao.util.IdProcessUtil;
import com.deep.two.dao.util.Pagination;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.orm.Resource;
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
public class ResourceHelper {
    
    private DaoUtil daoUtil;
    private ResourceModel model;
    
    public ResourceHelper(ResourceModel model, DaoUtil daoUtil) {
        this.model = model;
        this.daoUtil = daoUtil;
    }
    
    public void check() throws ViewException {
        BusinessCheck checker;
        checker = new ResourceUniqueChecker(model, daoUtil);
        checker.check();
    }
    
    public ResourceModel ormToModel(Resource orm) throws ViewException {
        ResourceModel model = CopyUtil.copyProperty(orm, ResourceModel.class);
        return model;
    }
    
    public Resource modelToOrm(CurrentUser userModel) throws ViewException {
        Resource orm = CopyUtil.copyProperty(model, Resource.class);
        // 设置id
       IdProcessUtil.setId(orm);
        return orm;
    }
    
    public QueryListReturnVo<ResourceModel> query(ResourceQueryVO vo, Pagination pageInfo) throws ViewException {
        List<CriterionUnit> cuList = null;
        if (vo != null) {
           cuList = CriteriaUtil.vo2CriteriaUnitList(vo);
        }
        List<Resource> list = this.daoUtil.queryList(cuList, null, pageInfo, Resource.class);
        if (pageInfo != null) {
            pageInfo.setSumRecord(this.daoUtil.queryCount(cuList, Resource.class));
        }
        
        List<ResourceModel> modelList = new ArrayList<ResourceModel>();
        for(Resource resource : list) {
            ResourceModel model = CopyUtil.copyProperty(resource, ResourceModel.class);
            modelList.add(model);
        }
        return new QueryListReturnVo<ResourceModel>(modelList, pageInfo);
    }
}
