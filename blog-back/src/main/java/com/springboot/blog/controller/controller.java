package com.springboot.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1")
@RestController
public class controller {
    @Autowired
    MongoTemplate mongoTemplate;
    @GetMapping("/hello")
    @ResponseBody
    public ResponseEntity<String> hello() {

        return ResponseEntity.ok().body("ff");
    }
    @GetMapping("/test")
    @ResponseBody
    public Object test(){
       return null;
    }

}
