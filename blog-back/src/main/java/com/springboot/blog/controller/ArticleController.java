package com.springboot.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonView;
import com.springboot.blog.entity.db.Article;
import com.springboot.blog.manager.ArticleViews;
import com.springboot.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping(value = "/v1")
@ResponseBody
public class ArticleController {
    @Autowired
    private ArticleService articleService;
//    @Autowired
//    private ArticleRepository articleRepository;
//
//    /*获得所有文章信息*/
//    @GetMapping("articles")
//    public List<Article> getAllArticles(@PageableDefault(page=2,size=17,sort="username,asc") Pageable pageable){
//        return articleRepository.findByAccountId_Id(1);
//    }
    /*通过文章id查找文章详细信息*/
    @GetMapping("articles/{id}")
    @JsonView(ArticleViews.DetailView.class)
    public JSONObject GetArticleById(@PathVariable(value = "id") int id){
        return articleService.getArticlesById(id);
    }

    @JsonView(ArticleViews.ListView.class)
    @GetMapping("articles/account-id/{id}")
    public List<JSONObject> GetArticleByAccountId(@PathVariable(value = "id") int id){

        return articleService.selectArticlesList(id);
    }

    @GetMapping("labels/{id}")
    @JsonView(ArticleViews.ListView.class)
    public List<Article> GetArticlesByLabelId(@PathVariable(value = "id") int id){
        return articleService.getArticlesByLabelId(id);
    }
}
