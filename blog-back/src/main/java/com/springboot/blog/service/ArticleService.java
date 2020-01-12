package com.springboot.blog.service;

import com.springboot.blog.entity.db.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    List<Article> getArticles();
    List<Article> getArticlesByAccountId(int id);
    Optional<Article> getArticlesById(int id);

}