package com.GargAbhishek.RESTful.Web.Services.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {
    @GetMapping(path = "/welcome")
    public String welcomeMessage(){
        return "Welcome to Spring Boot";
    }
}
