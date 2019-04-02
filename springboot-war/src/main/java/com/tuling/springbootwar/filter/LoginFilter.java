package com.tuling.springbootwar.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author jizy
 * @create 2019/3/31
 * @since 1.0.0
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
