package com.springboot.blog.controller;

import com.springboot.blog.entity.db.ArticleClassify;
import com.springboot.blog.service.ArticleClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping(value = "/v1")
@ResponseBody
public class ArticleClassifyController {

    @Autowired
    ArticleClassifyService articleClassifyService;
    @GetMapping("/classifies")
    public List<ArticleClassify> byArticleId(){
        return articleClassifyService.findAll();
    }
}
