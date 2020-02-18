package com.springboot.blog.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.springboot.blog.entity.db.Article;
import com.springboot.blog.manager.ArticleViews;
import com.springboot.blog.service.ArticleService;
import com.springboot.blog.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping(value = "/v1")
@ResponseBody
public class LabelController  {
    @Autowired
    private LabelService labelService;
    @Autowired
    private ArticleService articleService;
//    @PostMapping("labels")
//    public List<Map> getLabelsByArticleId(@RequestParam("way") String param, @RequestParam("id") int id){
//        if(param.equals("article"))
//            return labelService.getArticleLabels(id);
//        else if (param.equals("account"))
//            return labelService.getAccountLabels(id);
//        return null;
//    }

    @PostMapping("labels/{labelName}")
    @JsonView(ArticleViews.ListView.class)
    public List<Article> GetArticlesByLabelId(@RequestParam("accountId") int accountId,@PathVariable(value = "labelName") String labelName){

        return articleService.getArticlesByLabelName(accountId,labelName);
    }



}
