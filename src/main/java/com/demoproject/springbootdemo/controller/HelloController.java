package com.demoproject.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @Value("${env_name}")
    private String env_name;
    // @RequestMapping(value = "/",method = RequestMethod.GET)
    @GetMapping("/")
    public String helloWorld(){
        return "hello bro, hows everything in "+this.env_name;
    }
}
