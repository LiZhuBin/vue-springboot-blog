package com.spring.blog.blogback.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class controller {
    @GetMapping("/hello")
    public String hello(){
        return "fdddd";
    }
}
