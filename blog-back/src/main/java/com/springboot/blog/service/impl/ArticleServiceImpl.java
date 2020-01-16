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

    /*通过作者id查找文章*/
    @Override
    public List<Article> getArticlesByAccountId(int id) {
        return articleRepository.findAllByAccountId(id);
    }

    /*通过文章id查找文章信息*/
    @Override
    public JSONObject getArticlesById(int id) {
        JSONObject jsonObject = new JSONObject();
        Optional<Article> o = articleRepository.findById(id);
        jsonObject.put("article",o);
        jsonObject.put("account",articleRepository.accountInfo(o.get().getId()));
        jsonObject.put("labels",articleRepository.labelInfo(id));
        return jsonObject;
    }


    @Override
    public List<JSONObject> selectArticlesList(int accountId) { /*通过作者id查找文章*/
        List<JSONObject> jsonObjects = new ArrayList<>();
        ;
        List<Map> objects = articleRepository.selectArticleInfo(accountId);

        for (int i = 0; i < objects.size(); i++) {
            JSONObject jsonObject = new JSONObject();
            Map map = articleRepository.selectArticleInfo(accountId).get(i);
            jsonObject.put("account", articleRepository.accountInfo(accountId));
            jsonObject.put("article", map);
            List<Map> labelNames = articleRepository.labelInfo((Integer) map.get("id"));

            jsonObject.put("labels", labelNames);

            jsonObjects.add(jsonObject);
        }

        return jsonObjects;
    }


}
