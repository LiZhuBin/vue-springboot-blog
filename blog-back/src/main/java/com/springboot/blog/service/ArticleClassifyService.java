package com.springboot.blog.service;

import com.springboot.blog.entity.db.ArticleClassify;

import java.util.List;

public interface ArticleClassifyService {
   // public List<String> clssifiesByArticleId(int articleId);
    List<ArticleClassify> findAll();

}
