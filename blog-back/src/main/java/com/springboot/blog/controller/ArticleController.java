package com.springboot.blog.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonView;
import com.springboot.blog.annotation.PassToken;
import com.springboot.blog.entity.db.Article;
import com.springboot.blog.manager.ArticleViews;
import com.springboot.blog.repository.ArticleRepository;
import com.springboot.blog.service.AccountService;
import com.springboot.blog.service.ArticleService;
import com.springboot.blog.service.LabelService;
import com.springboot.blog.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
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


    @GetMapping("{id}")
    @PassToken
    @JsonView(ArticleViews.DetailView.class)
    public Article getArticles(@PathVariable(value = "id") int id,@RequestParam(value = "orderby",required = false) String orderBy,@RequestParam(value = "sort",required = false) String sort){

        return articleService.getArticlesById(id);
    }
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void delecteArticlesById(@PathVariable(value = "id") int id){
            articleService.delete(id);
    }



        /**
        * @Description: 文章列表数据
        * @Param: [id]
        * @return: java.util.List<com.alibaba.fastjson.JSONObject>
        */
        @JsonView(ArticleViews.ListView.class)
        @GetMapping("account-id/{id}")
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
    public Article getArticles(HttpServletRequest request){
        int accountId = Integer.parseInt(request.getParameter("accountId"));
        int articleId = Integer.parseInt(request.getParameter("articleId"));
        System.out.println(articleId);
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String classify = request.getParameter("classify");
     //   String[] tags = request.getParameterValues("tags");
        Timestamp creatTime = new Timestamp(System.currentTimeMillis());
        Article a ;
        if(articleId!=0){

            a = articleService.getArticlesById(articleId);
            if(a==null){
                a = new Article();
            }
        }else{
            a = new Article();
        }
        a.setAccountId(accountId);
        a.setArticleTitle(title);
        a.setArticleDetail(content);
        a.setArticleClassify(classify);
        a.setArticleCreateTime(creatTime);


       Article article = articleService.insertArticle(a);

        return article;
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
