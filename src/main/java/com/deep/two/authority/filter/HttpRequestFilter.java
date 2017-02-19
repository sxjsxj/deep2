package com.deep.two.authority.filter;

import java.io.IOException;
import java.util.regex.Pattern;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sunxijin
 * 过滤http请求中的参数
 */
public class HttpRequestFilter implements Filter {
	private static String reg = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|"  
            + "(\\b(select|update|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|into|drop|execute)\\b)";  
	private static Pattern sqlPattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);  

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
        
        String qurystr = httpRequest.getQueryString()==null?"": httpRequest.getQueryString();  
        if (!qurystr.equals("")) {  
            try {  
            	qurystr = java.net.URLDecoder.decode(qurystr, "UTF-8");  
            } catch (Exception e1) {  
            	qurystr = httpRequest.getRequestURI();  
            }
            if (sqlPattern.matcher(qurystr).find()) {  
                throw new IOException("请求参数中包含非法字符。");
            }  
        }  
    	chain.doFilter(request, response);  
    }  
}