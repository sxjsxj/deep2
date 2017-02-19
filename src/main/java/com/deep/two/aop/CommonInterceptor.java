package com.deep.two.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Aspect
@Component
public class CommonInterceptor {
    
	@Around("execution(public org.springframework.web.servlet.ModelAndView com.deep.two.controller..*.*(..))")
    public Object around(ProceedingJoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();
       
        ModelAndView mv = (ModelAndView) jp.proceed(args);
        mv.addObject("jspPath", "/WEB-INF/pages/"+mv.getViewName()+".jsp");
		return mv;
    }
}
