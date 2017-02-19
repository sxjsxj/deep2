/**
 * Copyright (c) 2014,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:airtisweb-service-authority
 * Package Name:com.travelsky.fare.airtisweb.service.authority.impl
 * File Name:AirtisAccessDecisionManager.java
 * Date:2014-9-1 上午10:23:39
 * 
 */
package com.deep.two.authority.impl;

import java.util.Collection;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 * ClassName: AirtisAccessDecisionManager <br/>
 * Description: 根据SS的框架 编写符合SS框架的决策器 <br/>
 * Date: 2014-9-1 上午10:23:39 <br/>
 * <br/>
 * 
 * @author zangling(邮箱)
 * 
 *         修改记录
 * @version 产品版本信息 2014-09-01 zangl(zangl@) 创建此类<br/>
 * 
 */
public class CustomDecisionManager implements AccessDecisionManager {

    /**
     * 
     * decide:AccessDecisionManager接口定义的方法，目的是判断用户对某个资源是否有权限 <br/>
     * 
     * @param authentication
     *            用户信息，里面包含了用户实际拥有的权限信息<br/>
     * @param object
     *            接口中要求定义的，但是实际上没有使用，应该体现在某个资源对象<br/>
     * @param configAttributes
     *            访问某资源对象(object)需要的权限<br/>
     * 
     * @exception AccessDeniedException
     *                如果判断用户访问到了不该访问的资源，则抛出此异常，提示没有权限 <br/>
     * @exception InsufficientAuthenticationException
     *                没有意义，应该可以去掉！！<br/>
     */
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
            throws AccessDeniedException, InsufficientAuthenticationException {

        if (configAttributes == null) {
            throw new AccessDeniedException("no right!! ");
        }
        boolean hasAuthority = false;
        for (ConfigAttribute ca : configAttributes) {
            String authorityName = ((SecurityConfig) ca).getAttribute();
            // ga 为用户所被赋予的权限。 needRole 为访问相应的资源应该具有的权限。
            for (GrantedAuthority ga : authentication.getAuthorities()) {
                if (ga.getAuthority().trim().equals(authorityName.trim())) {
                    hasAuthority = true;
                    break;
                }
            }
            if (hasAuthority) {
                return;
            }
        }
        throw new AccessDeniedException("no right!! ");
    }

    /**
     * supports:AccessDecisionManager接口定义的方法，是判断本类可以处理的ConfigAttribute类型，
     * 本类只能处理SecurityConfig类 <br/>
     * 
     * @param attribute
     *            某个资源对象所拥有的ConfigAttribute类型。外围类在调用本类时，
     *            需要先调用此方法判断资源对象拥有的权限是否可以通过本类来进行判断<br/>
     * @return boolean 能处理返回true，不能处理返回false <br/>
     */
    public boolean supports(ConfigAttribute attribute) {
        if (attribute instanceof SecurityConfig) {
            return true;
        }
        return false;
    }

    /**
     * supports:AccessDecisionManager接口定义的方法，是判断本类可以处理的Class类型，默认处理所有的类 <br/>
     * 
     * @param clazz
     *            某个资源对象的类型（个人感觉）。外围类在调用本类时，需要先调用此方法判断资源对象是否可以通过本类来进行判断<br/>
     * @return boolean 能处理返回true，不能处理返回false <br/>
     */
    public boolean supports(Class<?> clazz) {
        return true;
    }

}
