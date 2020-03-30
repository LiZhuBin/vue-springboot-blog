package com.springboot.blog.service.impl;

import com.springboot.blog.entity.db.ArticleClassify;
import com.springboot.blog.repository.ArticleClassifyRepository;
import com.springboot.blog.service.ArticleClassifyService;
import com.springboot.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleClassifyServiceImpl implements ArticleClassifyService {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    ArticleClassifyRepository articleClassifyRepository;
@Autowired
private ArticleService articleService;

    @Override
    public List<ArticleClassify> findAll() {

        return articleClassifyRepository.findAll();
    }

//    @Override
//    public List<String> clssifiesByArticleId(int articleId) {
////       Query query = new Query(Criteria.where("article_id").is(articleId));
////        ArticleClassify articleClassify =mongoTemplate.findOne(query, ArticleClassify.class);
////        assert articleClassify != null;
////        return articleClassify.getClassify();
//        ArticleClassify one = articleClassifyRepository.findAll();
//        return one.getClassify();
//    }
}
