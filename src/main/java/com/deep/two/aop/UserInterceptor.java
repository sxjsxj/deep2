package com.deep.two.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletWebRequest;

import com.deep.two.authority.model.CurrentUser;
import com.deep.two.authority.model.UserExtend;
import com.deep.two.util.CopyUtil;

@Aspect
@Service("userInterceptor")
public class UserInterceptor {

    /**
     * 
     * aroundService:AOP拦截所有第一个参数为AirtisUsers对象的Service方法<br/>
     * 
     * @param jp
     *            第一个参数为AirtisUsers对象的Service方法
     * @return 为Service方法中的AirtisUsers参数赋值后的Service方法
     * @throws Throwable
     *             异常
     * 
     */
    public Object aroundService(ProceedingJoinPoint jp) throws Throwable {
        UserExtend userExtend = (UserExtend) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CurrentUser user = CopyUtil.copyProperty(userExtend, CurrentUser.class);
        Object[] args = jp.getArgs();
      
        return jp.proceed(args);
    }
    
    public Object aroundGetUserName(ProceedingJoinPoint jp) throws Throwable {
        UserExtend userExtend = (UserExtend) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userExtend.getEmail();
    }
}
