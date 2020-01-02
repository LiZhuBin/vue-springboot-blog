package com.springboot.blogback.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1")
@RestController
public class controller {

    @GetMapping("/hello")
    @ResponseBody
    public ResponseEntity<String> hello(){

        return ResponseEntity.ok().body("ff");
    }
}
