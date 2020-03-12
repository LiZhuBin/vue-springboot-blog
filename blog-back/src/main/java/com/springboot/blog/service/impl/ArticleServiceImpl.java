package com.springboot.blog.service.impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springboot.blog.entity.db.*;
import com.springboot.blog.repository.ArticleRepository;
import com.springboot.blog.service.AccountSumaryService;
import com.springboot.blog.service.ArticleService;
import com.springboot.blog.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
//@Transactional
//@CacheConfig(cacheNames = "articleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    JPAQueryFactory jpaQueryFactory;
    @Autowired
    ResourcesService resourcesService;
    @Autowired
    AccountSumaryService accountSumaryService;
    @Autowired
    MongoTemplate mongoTemplate;

    QArticle article = QArticle.article;



    @Override
    public List<Map> hotArticles(int accountId, int line) {

        return articleRepository.hotArticles(accountId, line);
    }

    @Override
    public List<Map> newArticles(int accountId, int line) {
        return articleRepository.newArticles(accountId, line);
    }




    /*通过作者id查找文章*/
    @Override
//    @Cacheable(value = "getArticlesByAccountId")
    public List<Article> getArticlesByAccountId(int id) {
        return articleRepository.findAllByAccountId(id);
    }

    /**
     * @Description:通过文章id查找文章信息
     * @Param: [id]
     * @return: com.alibaba.fastjson.JSONObject
     */
    @Override
    @CachePut(value = "article", key = "#p0")

    public Article getArticlesById(int id) {
        //点击更新阅读数


//        int num= jpaQueryFactory.select(article.articleReadCount).from(article).where(article.id.eq(id)).fetchOne();
//
//
//        jpaQueryFactory.update(article).set(article.articleReadCount,num+1).where(article.accountId.eq(id)).execute();
        Article article1 = jpaQueryFactory.select(article).from(article).where(article.id.eq(id)).fetchOne();
        return article1;
    }

    @Override
    /**
    * @Description: 通过label名和作者名得到文章信息
    * @Param: [accountId, labelName]
    * @return: java.util.List<com.springboot.blog.entity.db.Article>
    */
    public List<Article> getArticlesByLabelName(int accountId,String labelName) {
        Criteria criteria =new Criteria();
        criteria.and("account_id").is(accountId);
        criteria.and("labels").in(labelName);
        Query query = new Query(criteria);
        List<ArticleClassify> articleClassifies = mongoTemplate.find(query, ArticleClassify.class);
        List<Article> articleList= new ArrayList<>();
        for(ArticleClassify articleClassify :articleClassifies){
            articleList.add(getArticlesById(articleClassify.getArticleId()));
        }
        return articleList;

    }

    @Override
    public List<Article> getArticlesByArchive(int accountId, String year, String month) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.and(article.accountId.eq(accountId));
        StringBuffer stringBuffer =new StringBuffer();
        stringBuffer.append(year);
        stringBuffer.append('-');
        stringBuffer.append(month);
        booleanBuilder.and(article.articleCreateTime.startsWith(stringBuffer.toString()));
        return jpaQueryFactory.selectFrom(article).where(booleanBuilder).fetch();

    }

    @Override
    public List<Article> getArticlesByClassifyName(int accountId, String classifyName) {
        Criteria criteria =new Criteria();
        criteria.and("account_id").is(accountId);
        criteria.and("classify").in(classifyName);
        Query query = new Query(criteria);
        List<ArticleClassify> articleClassifies = mongoTemplate.find(query, ArticleClassify.class);
        List<Article> articleList= new ArrayList<>();
        for(ArticleClassify articleClassify :articleClassifies){
            articleList.add(getArticlesById(articleClassify.getArticleId()));
        }
        return articleList;
    }


}
