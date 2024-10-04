package com.kucw.security.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")  //equals to setAllowedOrigins()
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("執行 /hello");
        return "Hello!";
    }
}
