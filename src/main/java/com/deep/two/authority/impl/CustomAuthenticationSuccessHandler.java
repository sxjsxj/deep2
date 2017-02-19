package com.deep.two.authority.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.deep.two.authority.model.UserExtend;

/**
 * <tt>AuthenticationSuccessHandler</tt> which can be configured with a default
 * URL which users should be sent to upon successful authentication.
 * <p>
 * The logic used is that of the
 * {@link AbstractAuthenticationTargetUrlRequestHandler parent class}.
 * 
 * @author Luke Taylor
 * @since 3.0
 */
public class CustomAuthenticationSuccessHandler extends AbstractAuthenticationTargetUrlRequestHandler implements AuthenticationSuccessHandler {
	private String adminTargetUrl;
	private String commonTargetUrl;
	private String researchTargetUrl;
	private String companyTargetUrl;
	private String investorTargetUrl;
	
    public String getCommonTargetUrl() {
		return this.commonTargetUrl;
	}

	public void setCommonTargetUrl(String commonTargetUrl) {
		this.commonTargetUrl = commonTargetUrl;
	}

	public String getAdminTargetUrl() {
		return this.adminTargetUrl;
	}

	public void setAdminTargetUrl(String adminTargetUrl) {
		this.adminTargetUrl = adminTargetUrl;
	}

	public String getResearchTargetUrl() {
		return researchTargetUrl;
	}

	public void setResearchTargetUrl(String researchTargetUrl) {
		this.researchTargetUrl = researchTargetUrl;
	}

	public String getCompanyTargetUrl() {
		return companyTargetUrl;
	}

	public void setCompanyTargetUrl(String companyTargetUrl) {
		this.companyTargetUrl = companyTargetUrl;
	}

	public String getInvestorTargetUrl() {
		return investorTargetUrl;
	}

	public void setInvestorTargetUrl(String investorTargetUrl) {
		this.investorTargetUrl = investorTargetUrl;
	}

	public CustomAuthenticationSuccessHandler() {
    }

    /**
     * Constructor which sets the <tt>defaultTargetUrl</tt> property of the base
     * class.
     * 
     * @param defaultTargetUrl
     *            the URL to which the user should be redirected on successful
     *            authentication.
     */
    public CustomAuthenticationSuccessHandler(String defaultTargetUrl) {
        setDefaultTargetUrl(defaultTargetUrl);
    }

    /**
     * Calls the parent class {@code handle()} method to forward or redirect to
     * the target URL, and then calls {@code clearAuthenticationAttributes()} to
     * remove any leftover session data.
     */
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
    	UserExtend user = (UserExtend) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	boolean isAdmin = false;
    	boolean isCompany = false;
    	boolean isResearch = false;
    	boolean isInvestor = false;
    	for (GrantedAuthority ga: user.getAuthorities()) {
    		if (ga.getAuthority().equals("role_admin")) {
    			isAdmin = true;
    			break;
    		}
    		if (ga.getAuthority().equals("role_companyuser")) {
    			isCompany = true;
    			break;
    		}
    		if (ga.getAuthority().equals("role_researchuser")) {
    			isResearch = true;
    			break;
    		}
    		if (ga.getAuthority().equals("role_investoruser")) {
    			isInvestor = true;
    			break;
    		}
    	}
    	if (isAdmin) {
    		this.setDefaultTargetUrl(this.adminTargetUrl);
    	} else if (isResearch) {
    		this.setDefaultTargetUrl(this.getResearchTargetUrl());
    	} else if (isCompany){
    		this.setDefaultTargetUrl(this.getCompanyTargetUrl());
    	} else if (isInvestor) {
    		this.setDefaultTargetUrl(this.getInvestorTargetUrl());
    	} else {
    		this.setDefaultTargetUrl(this.commonTargetUrl);
    	}
        handle(request, response, authentication);
        clearAuthenticationAttributes(request);
    }

    /**
     * Removes temporary authentication-related data which may have been stored
     * in the session during the authentication process.
     */
    protected final void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session == null) {
            return;
        }

        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
}
