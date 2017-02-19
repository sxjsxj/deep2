/**
 * Copyright (c) 2015,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:TrafficWebAuthorityService
 * Package Name:com.travelsky.fare.service.authority.impl
 * File Name:LoginUrlRequestMatcher.java
 * Date:2015-7-9 下午1:00:10
 * 
 */
package com.deep.two.authority.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.UrlUtils;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.Assert;

/**
 * ClassName: LoginUrlRequestMatcher <br/>
 * Description: TODO <br/>
 * Date: 2015-7-9 下午1:00:10 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

public class LoginUrlRequestMatcher implements RequestMatcher {

    private String filterProcessesUrl;

    public LoginUrlRequestMatcher() {

    }

    public LoginUrlRequestMatcher(String filterProcessesUrl) {
        Assert.hasLength(filterProcessesUrl, "filterProcessesUrl must be specified");
        Assert.isTrue(UrlUtils.isValidRedirectUrl(filterProcessesUrl), filterProcessesUrl
                + " isn't a valid redirect URL");
        this.filterProcessesUrl = filterProcessesUrl;
    }

    public void setFilterProcessesUrl(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }

    public String getFilterProcessesUrl() {
        return filterProcessesUrl;
    }

    public boolean matches(HttpServletRequest request) {
        String uri = request.getRequestURI();
        int pathParamIndex = uri.indexOf(';');

        if (pathParamIndex > 0) {
            // strip everything after the first semi-colon
            uri = uri.substring(0, pathParamIndex);
        }

        if ("".equals(request.getContextPath())) {
            return uri.endsWith(filterProcessesUrl);
        }

        return uri.endsWith(request.getContextPath() + filterProcessesUrl);
    }
}
