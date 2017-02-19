/**
 * Copyright (c) 2014,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:airtisweb-service-authority
 * Package Name:com.travelsky.fare.airtisweb.service.authority.impl
 * File Name:AirtisInvocationSecurityMetadataSourceService.java
 * Date:2014-8-20 下午5:24:23
 * 
 */
package com.deep.two.authority.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.deep.two.authority.model.ResourceModel;
import com.deep.two.authority.model.RoleModel;
import com.deep.two.service.authority.RoleService;
import com.deep.two.util.ViewException;


public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    @Qualifier("roleService")
    private RoleService roleService;
    /**
     * 放置所有的资源-权限对应关系
     */
    private static Map<RequestMatcher, Collection<ConfigAttribute>> requestMap;

	/**
     * 获得log4j的日志输出
     */
    private static final Logger LOGGER = Logger.getLogger(CustomFilterInvocationSecurityMetadataSource.class);
    /**
     * 如果一个资源没有分配任何权限，则框架默认为可以通过，因此需要给每个资源一个默认权限，以便使没有赋权的资源不被任何用户访问到。
     */
    private static final String AUDENIED = "AU_DENIED";

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void initResourceMap() throws ViewException {
        requestMap = new LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>();
        Map<String, List<ConfigAttribute>> map = getMap();
        for (Entry<String, List<ConfigAttribute>> entry : map.entrySet()) {
            requestMap.put(new FilterProcessUrlRequestMatcher(entry.getKey()), entry.getValue());
        }
    }
    
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    private Map<String, List<ConfigAttribute>> getMap() throws ViewException {
        List<RoleModel> rmList = this.roleService.queryAll();
        Map<String, List<ConfigAttribute>> map = new HashMap<String, List<ConfigAttribute>>();
        for (RoleModel model : rmList) {
            for (ResourceModel rm : model.getResourceModels()) {
                if ("url".equals(rm.getResourceType())) {
                    if (!map.containsKey(rm.getResourceStr())) {
                        List<ConfigAttribute> caList = new ArrayList<ConfigAttribute>();
                        caList.add(new SecurityConfig(model.getRoleName()));
                        map.put(rm.getResourceStr(), caList);
                    } else {
                        map.get(rm.getResourceStr()).add(new SecurityConfig(model.getRoleName()));
                    }
                }
            }
        }
        return map;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Collection<ConfigAttribute> getAllConfigAttributes() {

        Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();
        
        try {
        	if (requestMap == null) {
        		this.initResourceMap();
        	}
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
        }
        if (requestMap != null) {
            for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap.entrySet()) {
                allAttributes.addAll(entry.getValue());
            }
        }
        return allAttributes;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Collection<ConfigAttribute> getAttributes(Object object) {
        try {
        	if (requestMap == null) {
        		this.initResourceMap();
        	}
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
        }
        final HttpServletRequest request = ((FilterInvocation) object).getRequest();
        if (requestMap != null) {
            for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap.entrySet()) {
                if (entry.getKey().matches(request)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }

    /**
     * 
     * ClassName: FilterProcessUrlRequestMatcher <br/>
     * Description: 目的为了实现RequestMatcher接口，来处理用户输入的资源和系统数据库中的资源名称是否匹配的问题 <br/>
     * Date: 2014-11-24 下午4:51:29 <br/>
     * <br/>
     * 
     * @author zangling(邮箱)
     * 
     *         修改记录
     * @version 产品版本信息 2014-09-01 zangl(zangl@) 创建内部类<br/>
     * 
     */
    private static final class FilterProcessUrlRequestMatcher implements RequestMatcher {
        /**
         * filterProcessesUrl:保存URL(描述这个变量用途).
         */
        private final transient String filterProcessesUrl;

        /**
         * Creates a new instance of FilterProcessUrlRequestMatcher.<br/>
         * Description: 构造器<br/>
         * 
         * @param filterProcessesUrl
         *            ：需要比较的URL参数
         */
        private FilterProcessUrlRequestMatcher(String filterProcessesUrl) {
            Assert.hasLength(filterProcessesUrl, "filterProcessesUrl must be specified");
            Assert.isTrue(UrlUtils.isValidRedirectUrl(filterProcessesUrl), filterProcessesUrl
                    + " isn't a valid redirect URL");
            this.filterProcessesUrl = filterProcessesUrl;
        }

        @Override
        public boolean matches(HttpServletRequest request) {
            String uri = request.getRequestURI();
            int pathParamIndex = uri.indexOf(';');

            if (pathParamIndex > 0) {
                // strip everything from the first semi-colon
                uri = uri.substring(0, pathParamIndex);
            }
            int queryParamIndex = uri.indexOf('?');
            if (queryParamIndex > 0) {
                // strip everything from the first question mark
                uri = uri.substring(0, queryParamIndex);
            }

            if ("".equals(request.getContextPath())) {
                return uri.endsWith(filterProcessesUrl);
            }

            return uri.endsWith(request.getContextPath() + filterProcessesUrl);
        }
    }
}
