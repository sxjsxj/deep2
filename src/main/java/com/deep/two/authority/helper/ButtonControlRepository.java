/**
 * Copyright (c) 2015,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:TrafficWebAuthorityService
 * Package Name:com.travelsky.fare.service.authority.impl
 * File Name:ButtonControlServiceImpl.java
 * Date:2015-7-21 下午7:00:23
 * 
 */
package com.deep.two.authority.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.deep.two.authority.model.ButtonModel;
import com.deep.two.authority.model.ResourceModel;
import com.deep.two.authority.model.RoleModel;
import com.deep.two.orm.User;
import com.deep.two.orm.UserRole;
import com.deep.two.service.authority.RoleService;
import com.deep.two.service.authority.UserService;
import com.deep.two.util.ViewException;

/**
 * ClassName: ButtonControlServiceImpl <br/>
 * Description: TODO <br/>
 * Date: 2015-7-21 下午7:00:23 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

@Repository("buttonControlRepository")
public class ButtonControlRepository {
    @Autowired
    @Qualifier("userService")
    private UserService userService;
    
    @Autowired
    @Qualifier("roleService")
    private RoleService roleService;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public List<ButtonModel> getHiddenList(List<String> list, String id) throws ViewException {
        Map<String, List<String>> map = this.getResourceMap();
        List<String> uaList = this.getUserRoleList(id);
        List<ButtonModel> resultList = new ArrayList<ButtonModel>();

        for (String resourceId : list) {
            boolean flag = true;
            ButtonModel bm = new ButtonModel();
            bm.setId(resourceId);
            if (!map.containsKey(resourceId)) {
                flag = false;
            } else {
                // 可以访问该resourceId的权限列表
                List<String> ruList = map.get(resourceId);
                for (String ru : ruList) {
                    if (uaList.contains(ru)) {
                        flag = false;
                        break;
                    }
                }
            }
            bm.setHidden(flag);
            resultList.add(bm);
        }
        return resultList;
    }

    public List<String> getUserRoleList(String id) throws ViewException {
        User user = this.userService.queryById(id);
        List<String> caList = new ArrayList<String>();
        for (UserRole ur : user.getUserRoles()) {
            caList.add(ur.getRole().getRoleName());
        }
        return caList;
    }

    /**
     * getResourceMap: 获取资源被哪些角色拥有<br/>
     * <资源id，角色列表>
     * @return
     * @throws ViewException
     * <br/>
     */
    private Map<String, List<String>> getResourceMap() throws ViewException {
        List<RoleModel> rmList = this.roleService.queryAll();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (RoleModel model : rmList) {
            for (ResourceModel rm : model.getResourceModels()) {
                if ("element".equals(rm.getResourceType())) {
                    if (!map.containsKey(rm.getResourceStr())) {
                        List<String> caList = new ArrayList<String>();
                        caList.add(model.getRoleName());
                        map.put(rm.getResourceStr(), caList);
                    } else {
                        map.get(rm.getResourceStr()).add(model.getRoleName());
                    }
                }
            }
        }
        return map;
    }
}
