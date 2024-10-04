package com.kucw.security.security;

import jakarta.servlet.*;

import java.io.IOException;

public class MyFilter1 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Execute MyFilter 1");
        //Pass request and response to next filter
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
