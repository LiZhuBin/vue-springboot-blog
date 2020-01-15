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

import java.util.*;

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

        for(int i=0;i<objects.size();i++){
            JSONObject jsonObject = new JSONObject();
            Map map = articleRepository.selectArticleInfo(accountId).get(i);
            jsonObject.put("account", articleRepository.accountInfo(accountId));
            jsonObject.put("article",map);


            List<Map > labelNames =articleRepository.labelInfo((Integer) map.get("id")) ;
//            Map<String,List<String>> m = new HashMap<String, List<String>>();
//
//            m.put("label_name", labelNames);
//
            jsonObject.put("labels",labelNames);

            jsonObjects.add(jsonObject);
        }

        return jsonObjects;
    }


}
