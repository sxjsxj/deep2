package com.deep.two.authority.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.util.Assert;

/**
 * <tt>AuthenticationFailureHandler</tt> which performs a redirect to the value
 * of the {@link #setDefaultFailureUrl defaultFailureUrl} property when the
 * <tt>onAuthenticationFailure</tt> method is called. If the property has not
 * been set it will send a 401 response to the client, with the error message
 * from the <tt>AuthenticationException</tt> which caused the failure.
 * <p>
 * If the {@code useForward} property is set, a
 * {@code RequestDispatcher.forward} call will be made to the destination
 * instead of a redirect.
 * 
 * @author Luke Taylor
 * @since 3.0
 */
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
    protected final Log logger = LogFactory.getLog(getClass());

    private String defaultFailureUrl;
    private boolean forwardToDestination = true;
    private boolean allowSessionCreation = true;
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	private String userNotFoundUrl;
	private String accountStatusUrl;
	private String sessionExceedUrl;
	private String anonymousUrl;
    private static final String ERROR_FLAG="errorFlag";
    
    public static final String SPRING_SECURITY_FORM_USERNAME_KEY = "j_username";
    public static final String SPRING_SECURITY_FORM_PASSWORD_KEY = "j_password";

    private String usernameParameter = SPRING_SECURITY_FORM_USERNAME_KEY;
    private String passwordParameter = SPRING_SECURITY_FORM_PASSWORD_KEY;

    public CustomAuthenticationFailureHandler() {
    }

    public CustomAuthenticationFailureHandler(String defaultFailureUrl) {
        setDefaultFailureUrl(defaultFailureUrl);
    }

    /**
     * Performs the redirect or forward to the {@code defaultFailureUrl} if set,
     * otherwise returns a 401 error code.
     * <p>
     * If redirecting or forwarding, {@code saveException} will be called to
     * cache the exception for use in the target view.
     */
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {

        if (defaultFailureUrl == null) {
            logger.debug("No failure URL set, sending 401 Unauthorized error");
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication Failed: " + exception.getMessage());
        } else {
            saveException(request, exception);
            String redirectUrl = getRedirectUrlByExceptionType(request, exception);
            String username = obtainUsername(request);
            String password = obtainPassword(request);
            //request.getSession().setAttribute("userName", userName);
            if (forwardToDestination) {
                logger.debug("Forwarding to " + redirectUrl);
                request.getRequestDispatcher(redirectUrl).forward(request, response);
            } else {
                logger.debug("Redirecting to " + redirectUrl);
                redirectStrategy.sendRedirect(request, response, redirectUrl);
            }
        }
    }

    private String getRedirectUrlByExceptionType(HttpServletRequest request, AuthenticationException exception) {
        String url = this.defaultFailureUrl;
        String flag = "1";
        if (exception.getClass() == UsernameNotFoundException.class) {
            url = this.userNotFoundUrl;
            flag = "0";
        }
        if (exception.getClass() == BadCredentialsException.class) {
            url = this.defaultFailureUrl;
            flag = "1";
        }
        if (exception.getClass() == AccountStatusException.class) {
            url = this.accountStatusUrl;
            flag = "2";
        }
        if (exception.getClass() == SessionAuthenticationException.class) {
            url = this.sessionExceedUrl;
            flag = "3";
        }
        if (exception.getClass() == InsufficientAuthenticationException.class) {
            url = this.anonymousUrl;
            flag = "4";
        }
        request.getSession().setAttribute(ERROR_FLAG, flag);
        return url;
    }
    
    protected String obtainPassword(HttpServletRequest request) {
        return request.getParameter(passwordParameter);
    }
    protected String obtainUsername(HttpServletRequest request) {
        return request.getParameter(usernameParameter);
    }

    /**
     * Caches the {@code AuthenticationException} for use in view rendering.
     * <p>
     * If {@code forwardToDestination} is set to true, request scope will be
     * used, otherwise it will attempt to store the exception in the session. If
     * there is no session and {@code allowSessionCreation} is {@code true} a
     * session will be created. Otherwise the exception will not be stored.
     */
    protected final void saveException(HttpServletRequest request, AuthenticationException exception) {
        if (forwardToDestination) {
            request.setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, exception);
        } else {
            HttpSession session = request.getSession(false);

            if (session != null || allowSessionCreation) {
                request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, exception);
            }
        }
    }

    /**
     * The URL which will be used as the failure destination.
     * 
     * @param defaultFailureUrl
     *            the failure URL, for example "/loginFailed.jsp".
     */
    public void setDefaultFailureUrl(String defaultFailureUrl) {
        Assert.isTrue(UrlUtils.isValidRedirectUrl(defaultFailureUrl), "'" + defaultFailureUrl
                + "' is not a valid redirect URL");
        this.defaultFailureUrl = defaultFailureUrl;
    }

    protected boolean isUseForward() {
        return forwardToDestination;
    }

    /**
     * If set to <tt>true</tt>, performs a forward to the failure destination
     * URL instead of a redirect. Defaults to <tt>false</tt>.
     */
    public void setUseForward(boolean forwardToDestination) {
        this.forwardToDestination = forwardToDestination;
    }

    /**
     * Allows overriding of the behaviour when redirecting to a target URL.
     */
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

    protected boolean isAllowSessionCreation() {
        return allowSessionCreation;
    }

    public void setAllowSessionCreation(boolean allowSessionCreation) {
        this.allowSessionCreation = allowSessionCreation;
    }

    public void setUserNotFoundUrl(String userNotFoundUrl) {
        this.userNotFoundUrl = userNotFoundUrl;
    }

    public void setAccountStatusUrl(String accountStatusUrl) {
        this.accountStatusUrl = accountStatusUrl;
    }

    public void setSessionExceedUrl(String sessionExceedUrl) {
        this.sessionExceedUrl = sessionExceedUrl;
    }

    public void setAnonymousUrl(String anonymousUrl) {
        this.anonymousUrl = anonymousUrl;
    }

}
