package com.springboot.blog.service.impl;

import com.springboot.blog.entity.db.Article;
import com.springboot.blog.repository.ArticleRepository;
import com.springboot.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleRepository articleRepository;
    Pageable pageable = PageRequest.of(0, 10);
    @Override
    public List<Article> getArticles() {
        return articleRepository.findAll(pageable).getContent();
    }

    @Override
    public List<Article> getArticlesByAccountId(int id) {
        return articleRepository.findAllByAccountId(id);
    }

    @Override
    public Optional<Article> getArticlesById(int id) {
        return articleRepository.findById(id);
    }
}
