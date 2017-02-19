/* Copyright 2004, 2005, 2006 Acegi Technology Pty Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.deep.two.authority.impl;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.Assert;
import org.springframework.web.filter.GenericFilterBean;

/**
 * Detects if there is no {@code Authentication} object in the
 * {@code SecurityContextHolder}, and populates it with one if needed.
 * 
 * @author Ben Alex
 * @author Luke Taylor
 */
public class FareAnonymousAuthenticationFilter extends GenericFilterBean implements InitializingBean {

    private AuthenticationFailureHandler failureHandler = new SimpleUrlAuthenticationFailureHandler();

    public void setFailureHandler(AuthenticationFailureHandler failureHandler) {
        this.failureHandler = failureHandler;
    }

    private FilterProcessUrlRequestMatcher requestMatcher;

    public FareAnonymousAuthenticationFilter(String processUrl) {
        this.requestMatcher = new FilterProcessUrlRequestMatcher(processUrl);
    }

    public FareAnonymousAuthenticationFilter() {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        Authentication au = SecurityContextHolder.getContext().getAuthentication();

        if (!requestMatcher.matches(req)) {
            if (au instanceof AnonymousAuthenticationToken) {
                failureHandler.onAuthenticationFailure(req, res, new InsufficientAuthenticationException("未登录"));
                return;
            }
        }
        chain.doFilter(req, res);
    }

    private static final class FilterProcessUrlRequestMatcher implements RequestMatcher {
        private final String filterProcessesUrl;

        private FilterProcessUrlRequestMatcher(String filterProcessesUrl) {
            Assert.hasLength(filterProcessesUrl, "filterProcessesUrl must be specified");
            Assert.isTrue(UrlUtils.isValidRedirectUrl(filterProcessesUrl), filterProcessesUrl
                    + " isn't a valid redirect URL");
            this.filterProcessesUrl = filterProcessesUrl;
        }

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
