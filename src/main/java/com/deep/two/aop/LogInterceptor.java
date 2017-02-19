package com.deep.two.aop;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.deep.two.authority.model.UserExtend;
import com.deep.two.util.StringUtil;

@Aspect
@Service("logInterceptor")
public class LogInterceptor {
    private static Logger LOG = Logger.getLogger(LogInterceptor.class);
   
    @Before("execution(public * com.deep.two.service..*.*(..))")
    public void beforeService(JoinPoint jp) {
        StringBuffer sb = new StringBuffer();
        UserExtend userExtend = null;
        Authentication au =  SecurityContextHolder.getContext().getAuthentication();
		if (au != null && au.isAuthenticated() && au.getPrincipal() !=null && !"anonymousUser".equals(au.getPrincipal())) {
	        userExtend = (UserExtend) au.getPrincipal();
		} else {
			return;
		}
        ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
        HttpServletRequest  request = attr.getRequest();
        String ipString = request.getHeader("x-forwarded-for");
        if (StringUtil.isEmpty(ipString) || "unknown".equalsIgnoreCase(ipString)) {
            ipString = request.getHeader("Proxy-Client-IP");
        }
        String className = jp.getSignature().getDeclaringTypeName();
        String methodName = jp.getSignature().getName();
        WebAuthenticationDetails details = (WebAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        String ip = details.getRemoteAddress();
        sb.append("USER OPERATION")
        .append("- ip: ").append(ip)
        .append(", email: ").append(userExtend.getEmail())
        .append(", user: ").append(userExtend.getUsername())
        .append(", class: ").append(className)
        .append(", execute: ").append(methodName).append(" start!!");
        LOG.info(sb.toString());
    }
    
    @AfterReturning("execution(public * com.deep.two.service..*.*(..))")
    public void afterReturnService(JoinPoint jp) throws Throwable {
        StringBuffer sb = new StringBuffer();
        UserExtend userExtend = null;
        Authentication au =  SecurityContextHolder.getContext().getAuthentication();
		if (au != null && au.isAuthenticated() && au.getPrincipal() !=null && !"anonymousUser".equals(au.getPrincipal())) {
	        userExtend = (UserExtend) au.getPrincipal();
		} else {
			return;
		}
        String className = jp.getSignature().getDeclaringTypeName();
        String methodName = jp.getSignature().getName();
        WebAuthenticationDetails details = (WebAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        String ip = details.getRemoteAddress();
        sb.append("USER OPERATION")
        .append("- ip: ").append(ip)
        .append(", email: ").append(userExtend.getEmail())
        .append(", user:").append(userExtend.getUsername())
        .append(", class:").append(className)
        .append(", execute:").append(methodName).append(" end!!");
        LOG.info(sb.toString());
    }
    
    @AfterThrowing("execution(public * com.deep.two..service..*.*(..))")
    public void afterThrowService(JoinPoint jp) throws Throwable {
        StringBuffer sb = new StringBuffer();
        UserExtend userExtend = null;
        Authentication au =  SecurityContextHolder.getContext().getAuthentication();
		if (au != null && au.isAuthenticated() && au.getPrincipal() !=null && !"anonymousUser".equals(au.getPrincipal())) {
	        userExtend = (UserExtend) au.getPrincipal();
		} else {
			return;
		}
        String className = jp.getSignature().getDeclaringTypeName();
        String methodName = jp.getSignature().getName();
        WebAuthenticationDetails details = (WebAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        String ip = details.getRemoteAddress();
        sb.append("USER OPERATION")
        .append("- ip: ").append(ip)
        .append(", email: ").append(userExtend.getEmail())
        .append(", user:").append(userExtend.getUsername())
        .append(", class:").append(className)
        .append(", execute:").append(methodName).append(" throws Exception!!");
        //.append(e.getMessage());
        LOG.error(sb.toString());
        //throw e;
    }
}
