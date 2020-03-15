package com.springboot.blog.controller;

import com.springboot.blog.entity.db.Article;
import com.springboot.blog.entity.db.ArticleClassify;
import com.springboot.blog.service.ArticleClassifyService;
import com.springboot.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping(value = "/v1/classifies")
@ResponseBody
public class ClassifyController {

    @Autowired
    ArticleClassifyService articleClassifyService;
    @Autowired
    ArticleService articleService;
    @GetMapping("")
    public List<ArticleClassify> byArticleId(){
        return articleClassifyService.findAll();
    }

    @PostMapping("{classifyName}")
    public List<Article> getArticlesByClassifyName(@RequestParam("accountId") int accountId, @PathVariable(value = "classifyName") String name){
        return articleService.getArticlesByClassifyName(accountId,name);
    }
}
