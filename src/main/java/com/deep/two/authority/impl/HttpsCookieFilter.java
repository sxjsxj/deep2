package com.deep.two.authority.impl;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.Assert;

/**
 * Sessions created under HTTPS, for which the session cookie is marked as
 * “secure”, cannot subsequently be used under HTTP. The browser will not send
 * the cookie back to the server and any session state will be lost (including
 * the security context information)
 * 
 * Tomcat tracks user sessions with the help of the JSESSIONID cookie. If you
 * enter into HTTPS with Tomcat, the cookie will come back with the secure
 * property being set to true. Subsequently when the redirection to http occurs,
 * the browser will not transmit the JSESSIONID cookie and you'll get a new
 * session.
 * 
 * This filter overrides the default Tomcat JSESSIONID behaviour
 */
public class HttpsCookieFilter implements Filter {
    private FilterProcessUrlRequestMatcher requestMatcher;
    private SessionRegistry sessionRegistry;
    private LoginUrlRequestMatcher loginUrlRequestMatcher;
    
    public HttpsCookieFilter() {
    	
    }

    public HttpsCookieFilter(String processUrl) {
        this.requestMatcher = new FilterProcessUrlRequestMatcher(processUrl);
    }

    public void setRequestMatcher(FilterProcessUrlRequestMatcher requestMatcher) {
        this.requestMatcher = requestMatcher;
    }

    public void setLoginUrlRequestMatcher(LoginUrlRequestMatcher loginUrlRequestMatcher) {
        this.loginUrlRequestMatcher = loginUrlRequestMatcher;
    }

    public void setSessionRegistry(SessionRegistry sessionRegistry) {
        this.sessionRegistry = sessionRegistry;
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {

        final HttpServletRequest httpRequest = (HttpServletRequest) request;
        final HttpServletResponse httpResponse = (HttpServletResponse) response;

        if (loginUrlRequestMatcher.matches(httpRequest)) {
            // String userName = request.getParameter("j_username");
            // HttpSession session = SessionHelper.sessionMap.get(userName);
            // if (session != null) {
            // Authentication au = SessionHelper.authencationMap.get(userName);
            // if (au != null) {
            // new FareSessionFixationProtectionHelper().onAuthentication(au,
            // httpRequest, httpResponse);
            // new FareRegisterSessionHelper(sessionRegistry).register(au,
            // httpRequest, httpResponse);
            // }
            // }
        }
  /*      if (!httpRequest.isSecure() && requestMatcher.matches(httpRequest)) {

            String queryString = httpRequest.getQueryString();
            int index = -1;
            if (queryString != null) {
                index = queryString.indexOf("userName=");
            }
            if (index != -1) {
                String userName = queryString.substring(index + 9);
                Authentication au = SessionHelper.authencationMap.get(userName);
                if (au != null) {
                    new FareSessionFixationProtectionHelper().onAuthentication(au, httpRequest, httpResponse);
                    new FareRegisterSessionHelper(sessionRegistry).register(au, httpRequest, httpResponse);
                }
                SessionHelper.authencationMap.put(userName, au);
                SessionHelper.sessionMap.put(userName, httpRequest.getSession());
            }
        }*/
        chain.doFilter(request, response);
    }

    public static void main(String args[]) {
        String uri = "aaaaa?userName=sxj";
        String userName = uri.substring(uri.indexOf("userName=") + 9);
        System.out.println(userName);
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