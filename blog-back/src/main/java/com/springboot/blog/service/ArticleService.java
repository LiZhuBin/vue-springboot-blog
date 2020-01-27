package com.springboot.blog.service;

import com.alibaba.fastjson.JSONObject;
import com.springboot.blog.entity.db.Article;

import java.util.List;
import java.util.Map;

public interface ArticleService {

    List<Map> hotArticles(int accountId, int line);
    List<Map> newArticles(int accountId,int line);
    List<Article> getArticlesByAccountId(int id);
    JSONObject getArticlesById(int id);
    List<Article> getArticlesByLabelId(int labelId);
    List<JSONObject> selectArticlesList(int accountId);
}
