package com.deep.two.authority.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResloveSecurityHoleFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest rqt, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) rqt;
		//添加X-XSS-Protection header
		HttpServletResponse resp=(HttpServletResponse)response;
		resp.setHeader("Set-Cookie", "name=value; HttpOnly");
		resp.addHeader("X-Content-Type-Options", "nosniff");
		resp.addHeader("X-XSS-Protection", "1;mode=block");
		resp.addHeader("X-Frame-Options", "SAMEORIGIN");
		//resp.addHeader("Content-Security-Policy", "default-src *; style-src http: 'unsafe-inline'");


		boolean flag = false;
        if (!flag) {
			chain.doFilter(request, response);
		} else { // 错误定向
		    
		}
	}

    @Override
    public void destroy() {
    }
}