/**
 * Copyright (c) 2015,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:TrafficWebAuthorityService
 * Package Name:com.travelsky.fare.service.authority.impl
 * File Name:FareLogoutSuccessHandler.java
 * Date:2015-7-20 下午3:41:23
 * 
 */
package com.deep.two.authority.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import com.deep.two.authority.model.UserExtend;
import com.deep.two.util.CollectionUtil;

/**
 * ClassName: FareLogoutSuccessHandler <br/>
 * Description: TODO <br/>
 * Date: 2015-7-20 下午3:41:23 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

public class CustomLogoutSuccessHandler extends AbstractAuthenticationTargetUrlRequestHandler implements
        LogoutSuccessHandler {
    private SessionRegistry sessionRegistry;

    public void setSessionRegistry(SessionRegistry sessionRegistry) {
        this.sessionRegistry = sessionRegistry;
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
    	super.handle(request, response, authentication);
    	if(authentication == null) return;
    	UserExtend userExtend = (UserExtend) authentication.getPrincipal();
        List<SessionInformation> list = sessionRegistry.getAllSessions(userExtend, false);
        List<String> ids = new ArrayList<String>();
        if (!CollectionUtil.isEmpty(list)) {
            for (SessionInformation info : list) {
                ids.add(info.getSessionId());
            }
        }
        for (String sessionId : ids) {
            sessionRegistry.removeSessionInformation(sessionId);
        }
    }

}
