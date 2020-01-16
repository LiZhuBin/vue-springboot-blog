package com.springboot.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonView;
import com.springboot.blog.entity.db.Article;
import com.springboot.blog.manager.ArticleViews;
import com.springboot.blog.service.AccountService;
import com.springboot.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping(value = "/v1")
@ResponseBody
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private AccountService accountService;


    /*获得所有文章信息*/
    @GetMapping("articles")
    public List<Article> getAllArticles(@PageableDefault(page=2,size=17,sort="username,asc") Pageable pageable){
        return articleService.getArticles();
    }
    /*通过文章id查找文章详细信息*/
    @GetMapping("articles/{id}")
    @JsonView(ArticleViews.DetailView.class)
    public JSONObject GetArticleById(@PathVariable(value = "id") int id){
        return articleService.getArticlesById(id);
    }

    /*通过作者id查找文章列表的粗略信息*/
    @JsonView(ArticleViews.baseView.class)
    @GetMapping("articles/account-id/{id}")
    public List<JSONObject> GetArticleByAccountId(@PathVariable(value = "id") int id){

//        JSONObject articleInfo = new JSONObject();
//        for(Article article :articleService.getArticlesByAccountId(id)){
//            Optional<Account> accountInfo = accountService.getAccountById(article.getAccountId());
//            articleInfo.put("article-info",article);
//            articleInfo.put("author-info",JSON.toJSON(accountInfo));
//        }


        return articleService.selectArticlesList(id);
    }

//    @GetMapping("articles/actions/")
}
