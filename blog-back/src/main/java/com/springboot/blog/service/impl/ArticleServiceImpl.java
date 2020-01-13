package com.springboot.blog.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.springboot.blog.entity.db.Article;
import com.springboot.blog.repository.ArticleRepository;
import com.springboot.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

    @Override
    public List<JSONObject> selectArticlesList(int accountId) {
        List<JSONObject> jsonObjects = new ArrayList<>();;
        List<Map> objects = articleRepository.selectArticleInfo(accountId);
        JSONObject jsonObject = new JSONObject();
        for(int i=0;i<objects.size();i++){
            Map map = articleRepository.selectArticleInfo(accountId).get(i);
            jsonObject.put("accounts", articleRepository.accountInfo(accountId));
            jsonObject.put("articles",map);
//            jsonObject.put("labels",articleRepository.LabelInfo((Integer) map.get("label_id")));
            jsonObjects.add(jsonObject);
        }

        return jsonObjects;
    }


}
