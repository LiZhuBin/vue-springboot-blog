package com.springboot.blog.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.springboot.blog.entity.db.Article;
import com.springboot.blog.entity.db.Label;
import com.springboot.blog.manager.ArticleViews;
import com.springboot.blog.service.ArticleService;
import com.springboot.blog.service.LabelService;
import org.bson.LazyBSONList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController

@RequestMapping(value = "/v1/labels")
@ResponseBody
public class LabelController  {
    @Autowired
    private LabelService labelService;
    @Autowired
    private ArticleService articleService;


    @PostMapping("{labelName}")
    @JsonView(ArticleViews.ListView.class)
    public List<Article> GetArticlesByLabelId(@RequestParam("accountId") int accountId,@PathVariable(value = "labelName") String labelName){
//
//        return articleService.getArticlesByLabelName(accountId,labelName);
        List<Article> articleList = new ArrayList<>();
        for(Label l:labelService.byLabelName(labelName)){
            articleList.add(articleService.getArticlesById(l.getArticleId()));
        }
        return articleList ;
    }
    @GetMapping("")
    public Set<String> getLabels(@RequestParam("accountId") int accountId){
        List<Article> articles = articleService.getArticlesByAccountId(accountId);
        Set<String > s = new HashSet<>();
        for(Article article:articles){
            s.addAll(labelService.getArticleLabels(article.getId()));
        }
        return s;
    }
    @RequestMapping(value = "",method = {RequestMethod.POST})
    public void insertLabels(@RequestParam("articleId") int articleId,@RequestParam("labelsName") List<String> labelsName){
        List<Label> labels = new ArrayList<>();
        for(String name :labelsName){
            labels.add(new Label(name,articleId));
        }
       // List<Label> labels = labelsName.stream().map((name)->new Label(name,articleId)).collect(Collectors.toList());
        labelService.insertLabels(labels);
    }

}
