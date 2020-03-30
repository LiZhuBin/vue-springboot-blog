package com.springboot.blog.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonView;
import com.springboot.blog.entity.db.Article;
import com.springboot.blog.manager.ArticleViews;
import com.springboot.blog.repository.ArticleRepository;
import com.springboot.blog.service.AccountService;
import com.springboot.blog.service.ArticleService;
import com.springboot.blog.service.LabelService;
import com.springboot.blog.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController

@RequestMapping(value = "/v1/articles")
@ResponseBody
public class ArticleController {
    @Autowired
    private  ArticleService articleService;
    @Autowired
    private AccountService accountService;

    @Autowired
    private LabelService labelService;
    @Autowired
    private ResourcesService resourcesService;
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("{id}")
    @JsonView(ArticleViews.DetailView.class)
        /**
        * @Description: 通过文章id查找文章详细信息
        * @Param: [id]
        * @return: com.alibaba.fastjson.JSONObject
        */
    public JSONObject GetArticlaeById(@PathVariable(value = "id") int id){
        JSONObject jsonObject = new JSONObject();
        Article article = articleService.getArticlesById(id);
        article.setArticlePicture(resourcesService.randomImage());
        jsonObject.put("article",article);
        jsonObject.put("account", JSON.toJSON((accountService.otherViewAccountById(id))));
        jsonObject.put("labels", JSON.toJSON(labelService.getArticleLabels(article.getId())));
        return jsonObject;
    }

    @JsonView(ArticleViews.ListView.class)
    @GetMapping("account-id/{id}")
        /**
        * @Description: 文章列表数据
        * @Param: [id]
        * @return: java.util.List<com.alibaba.fastjson.JSONObject>
        */
    public List<JSONObject> GetArticleByAccountId(@PathVariable(value = "id") int id){
        List<JSONObject> jsonObjects = new ArrayList<>();
        List<Article> articleList = articleService.getArticlesByAccountId(id);
        for(Article article :articleList){
            JSONObject jsonObject = new JSONObject();
            article.setArticlePicture(resourcesService.randomImage());
            jsonObject.put("article", JSON.toJSON(article));
            jsonObject.put("account", JSON.toJSON(accountService.otherViewAccountById(id)));
            jsonObject.put("labels", labelService.getArticleLabels(id));
            jsonObjects.add(jsonObject);
        }
        return jsonObjects;
    }
    @PostMapping("")
    public List<Article> getArticles(@RequestBody Article article){
        return articleRepository.findAllByAccountId(article.getId());
    }
    @GetMapping("_classify")
    public Set<String> getClassify(@RequestParam("accountId") int accountId){
        return articleService.classifiesByAccountId(accountId);
    }
    @PostMapping("_classify/{classifyName}")
    public List<Article> getArticlesByClassifyName(@RequestParam("accountId") int accountId, @PathVariable(value = "classifyName") String name){
        return articleService.getArticlesByClassifyName(accountId,name);
    }

}
