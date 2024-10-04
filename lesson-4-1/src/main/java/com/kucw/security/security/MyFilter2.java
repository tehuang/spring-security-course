package com.kucw.security.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class MyFilter2 extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("Execute Filter 2");
        String url = request.getRequestURI();

        if(url.equals("/hello")){
            System.out.println("Request to the path /hello are able to pass through");
            //Pass request and response to next filter
            filterChain.doFilter(request,response);
        }else{
            System.out.println("Not allow to pass through");
            //Set up a response to frontend
            response.setStatus(500);
        }
    }
}
