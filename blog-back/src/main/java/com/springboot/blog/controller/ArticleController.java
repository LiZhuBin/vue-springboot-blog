package com.springboot.blog.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonView;
import com.springboot.blog.entity.db.Account;
import com.springboot.blog.entity.db.Article;
import com.springboot.blog.manager.ArticleViews;
import com.springboot.blog.service.AccountService;
import com.springboot.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController

@RequestMapping(value = "/v1")
@ResponseBody
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private AccountService accountService;


    @GetMapping("articles")

    public List<Article> getAllArticles(@PageableDefault(page=2,size=17,sort="username,asc") Pageable pageable){
        return articleService.getArticles();
    }
    @GetMapping("articles/{id}")
    @JsonView(ArticleViews.DetailView.class)
    public Optional<Article> GetArticleById(@PathVariable(value = "id") int id){
        return articleService.getArticlesById(id);
    }

    @JsonView(ArticleViews.baseView.class)

    @GetMapping("articles/account-id/{id}")
    public JSONObject GetArticleByAccountId(@PathVariable(value = "id") int id){

        JSONObject articleInfo = new JSONObject();
        for(Article article :articleService.getArticlesByAccountId(id)){
            Optional<Account> accountInfo = accountService.getAccountById(article.getAccountId());
            articleInfo.put("article-info",article);
            articleInfo.put("author-info",JSON.toJSON(accountInfo));
        }


        return articleInfo;
    }
//    @GetMapping("articles/actions/")
}
