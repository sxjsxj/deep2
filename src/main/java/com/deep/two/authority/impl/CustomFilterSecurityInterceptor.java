package com.deep.two.authority.impl;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.Assert;

public class CustomFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {

    /**
     * 框架会把验证元数据内容通过 set 方法传入 securityMetadataSource
     */
    private FilterInvocationSecurityMetadataSource securityMetadataSource;
    /**
     * 无特别含义，只要不是null即可。框架中使用。
     */

    private static final String FILTER_APPLIED = "__spring_security_filterSecurityInterceptor_filterApplied";

    /**
     * 框架使用，没有特别含义。按照FilterSecurityInterceptor类写的，如果使用默认方式，则可以在配置文件中设置
     * <beans:property name="observeOncePerRequest" value="false" />
     * 每次请求都进行检查，如果设为true，则只第一次检查,默认为true
     */
    private boolean observeOncePerRequest = true;

    /**
     * 
     * isObserveOncePerRequest:每次请求检查一次 <br/>
     * 
     * @return 标识的值 <br/>
     */
    public boolean isObserveOncePerRequest() {
        return observeOncePerRequest;
    }

    /**
     * 
     * setObserveOncePerRequest:设置每次检查的标识值 <br/>
     * 
     * @param observeOncePerRequest
     *            需要设置的值 <br/>
     */
    public void setObserveOncePerRequest(boolean observeOncePerRequest) {
        this.observeOncePerRequest = observeOncePerRequest;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        Assert.notNull(request, "AirtisFilterSecurityInterceptor - doFilter -request");
        Assert.notNull(response, "AirtisFilterSecurityInterceptor - doFilter -response");
        Assert.notNull(chain, "AirtisFilterSecurityInterceptor - doFilter -chain");
        FilterInvocation fi = new FilterInvocation(request, response, chain);
        invoke(fi);
    }

    /**
     * 
     * getSecurityMetadataSource:获得类的内部属性的方法 Description <br/>
     * 
     * @return FilterInvocationSecurityMetadataSource 获得的属性 <br/>
     */
    public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
        return this.securityMetadataSource;
    }

    /**
     * 
     * getSecureObjectClass:AbstractSecurityInterceptor抽象类定义的方法，<br/>
     * 此方法会通过判断相关处理类是否支持处理这个Filter类来决定是否使用此类。<br/>
     * 代码可以参考 AbstractSecurityInterceptor 类的 afterPropertiesSet方法。<br/>
     * 
     * @return Class 返回此类代表的Fileter类<br/>
     */
    @Override
    public Class<? extends Object> getSecureObjectClass() {
        return FilterInvocation.class;
    }

    /**
     * 
     * invoke:Filter的具体业务操作 <br/>
     * 如果是第一次登陆的话应该是调用父类的几个方法来进行权限管理。<br/>
     * 
     * @param fi
     *            将request respones 保存在一个数据对象中进行处理
     * @throws IOException
     *             doFilter方法定义的异常<br/>
     * @throws ServletException
     *             doFilter方法定义的异常<br/>
     */
    private void invoke(FilterInvocation fi) throws IOException, ServletException {
        if ((fi.getRequest() != null) && (fi.getRequest().getAttribute(FILTER_APPLIED) != null)
                && observeOncePerRequest) {
            // filter already applied to this request and user wants us to
            // observe
            // once-per-request handling, so don't re-do security checking
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        } else {
            // first time this request being called, so perform security
            // checking
            if (fi.getRequest() != null) {
                fi.getRequest().setAttribute(FILTER_APPLIED, Boolean.TRUE);
            }

            InterceptorStatusToken token = super.beforeInvocation(fi);

            try {
                fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
            } finally {
                super.finallyInvocation(token);
            }

            super.afterInvocation(token, null);
        }
    }

    /**
     * 
     * 无用，标准的get方法，在AbstractSecurityInterceptor使用它获得securityMetadataSource <br/>
     * 
     * @return 返回要get的值
     * @see org.springframework.security.access.intercept.
     *      AbstractSecurityInterceptor#obtainSecurityMetadataSource() <br/>
     */
    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return this.securityMetadataSource;
    }

    /**
     * 
     * setSecurityMetadataSource:标准的set方法<br/>
     * 
     * @param securityMetadataSource
     *            需要set的值，跟本类的属性想对应。<br/>
     */
    public void setSecurityMetadataSource(FilterInvocationSecurityMetadataSource securityMetadataSource) {
        this.securityMetadataSource = securityMetadataSource;
    }

    /**
     * 
     * 无用，Filter定义的方法 <br/>
     * 
     * @see javax.servlet.Filter#destroy() <br/>
     */
    public void destroy() {
        // 无用，Filter定义的方法
    }

    /**
     * 
     * 无用，Filter定义的方法 <br/>
     * 
     * @param filterconfig
     *            过滤器配置
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig) <br/>
     * @throws ServletException
     *             servlet异常
     */
    public void init(FilterConfig filterconfig) throws ServletException {
        // 无用，Filter定义的方法
    }
}
