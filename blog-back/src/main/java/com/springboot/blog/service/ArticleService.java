package com.springboot.blog.service;

import com.springboot.blog.entity.db.Article;

import java.util.List;
import java.util.Map;

public interface ArticleService {

    List<Map> hotArticles(int accountId, int line);
    List<Map> newArticles(int accountId,int line);
    List<Article> getArticlesByAccountId(int id);
    Article getArticlesById(int id);
    List<Article> getArticlesByLabelName(int accountId,String labelName);
    List<Article> getArticlesByArchive(int accountId,String year,String month);
    List<Article> getArticlesByClassifyName(int accountId,String classifyName);
}
