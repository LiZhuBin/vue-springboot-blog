package com.springboot.blog.service;

import com.alibaba.fastjson.JSONObject;
import com.springboot.blog.entity.db.Article;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ArticleService {

    List<Map> hotArticles(int accountId, int line);
    List<Map> newArticles(int accountId,int line);
    List<Article> getArticlesByAccountId(int id);
    Article getArticlesById(int id);
    Article insertArticle(Article article);
    List<Article> getArticlesByLabelName(int accountId,String labelName);
    List<Article> getArticlesByArchive(int accountId,String year,String month);
    List<Article> getArticlesByClassifyName(int accountId,String classifyName);
    Set<String> classifiesByAccountId(int accountId);
    List<JSONObject> timeClassifyByAccountId(int accountId);
    void deleteBatch(List<Integer> ids);
    void delete(int id);
}
