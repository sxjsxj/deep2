package com.deep.two.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Aspect
@Service("httpRequestInterceptor")
public class HttpRequestInterceptor {

    @Around("execution(public * com.deep.two..service..*.*(..))")
    public Object aroundService(ProceedingJoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();
        System.out.println(args);
        return jp.proceed(args);
    }
}
