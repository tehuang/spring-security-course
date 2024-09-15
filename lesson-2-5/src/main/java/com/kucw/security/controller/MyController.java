package com.kucw.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class MyController {

    @GetMapping("/hello")
    public String hello(Authentication authentication)
    {   //Get user's account
        String username=authentication.getName();
        //Get user's authorities
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        return "Hello! "+username+" !";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome!";
    }
}
