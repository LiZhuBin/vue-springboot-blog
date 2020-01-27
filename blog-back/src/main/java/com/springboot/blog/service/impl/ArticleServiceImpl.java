package com.springboot.blog.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springboot.blog.entity.db.Article;
import com.springboot.blog.entity.db.QArticle;
import com.springboot.blog.entity.db.QArticleToLabel;
import com.springboot.blog.entity.db.QLabel;
import com.springboot.blog.repository.ArticleRepository;
import com.springboot.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
//@CacheConfig(cacheNames = "articleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    JPAQueryFactory jpaQueryFactory;
    Pageable pageable = PageRequest.of(0, 10);
    QArticle article = QArticle.article;
    QLabel label = QLabel.label;
    QArticleToLabel articleToLabel = QArticleToLabel.articleToLabel;


    @Override
    public List<Map> hotArticles(int accountId, int line) {
//        QArticle article = QArticle.article;
//        OrderSpecifier<Integer> order = new OrderSpecifier<Integer>(Order.DESC, article.articleReadCount);
//
//        BooleanBuilder booleanBuilder = new BooleanBuilder();
//        booleanBuilder.and(article.accountId.eq(accountId));
        return articleRepository.hotArticles(accountId,line);
     //   return jpaQueryFactory.select(article).from(article).where(article.accountId.eq(accountId)).orderBy(article.articleReadCount.asc()).limit(line).fetch();
    }

    @Override
    public List<Map> newArticles(int accountId, int line) {
       return articleRepository.newArticles(accountId,line);
    }

//    @CacheEvict(value = "getAllArticles")
//    public void clearAllArticles(){
//
//    }



    /*通过作者id查找文章*/
    @Override
//    @Cacheable(value = "getArticlesByAccountId")
    public List<Article> getArticlesByAccountId(int id) {
        return articleRepository.findAllByAccountId(id);
    }

    /*通过文章id查找文章信息*/
    @Override
//    @Cacheable(value = "article",key = "#p0")
    public JSONObject getArticlesById(int id) {
        JSONObject jsonObject = new JSONObject();
        QArticle article = QArticle.article;
        Article article1 = jpaQueryFactory.select(article).where(article.id.eq(id)).fetchOne();

        jsonObject.put("article",article1);
        jsonObject.put("account",articleRepository.accountInfo(article1.getId()));
        jsonObject.put("labels",articleRepository.labelInfo(id));
        return jsonObject;
    }

    @Override
    public List<Article> getArticlesByLabelId(int labelId) {
        List<Integer> articlesId = jpaQueryFactory.select(articleToLabel.labelId)
                .from(articleToLabel)
                .innerJoin(article)
                .on(article.id.eq(articleToLabel.articleId))
                .where(articleToLabel.id.eq(labelId))
                .fetch();
        return jpaQueryFactory.select(article)
                .from(article)
                .where(article.id.in(articlesId))
                .orderBy(article.articleCreateTime.asc())
                .fetch();
    }


    @Override
//    @Cacheable(value = "selectArticlesList")
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
