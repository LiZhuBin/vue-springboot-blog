package com.springboot.blog.service.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springboot.blog.entity.db.*;
import com.springboot.blog.repository.ArticleRepository;
import com.springboot.blog.service.AccountSumaryService;
import com.springboot.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    AccountSumaryService accountSumaryService;
    @Autowired
    MongoTemplate mongoTemplate;

    Pageable pageable = PageRequest.of(0, 10);
    QArticle article = QArticle.article;
    QLabel label = QLabel.label;
    QArticleToLabel articleToLabel = QArticleToLabel.articleToLabel;


    @Override
    public List<Map> hotArticles(int accountId, int line) {

        return articleRepository.hotArticles(accountId, line);
    }

    @Override
    public List<Map> newArticles(int accountId, int line) {
        return articleRepository.newArticles(accountId, line);
    }

//    @Override
//    @CachePut(value = "article-date-classify",key = "#p0")
//    public List<AccountSumary> articleDateClassify(int accountId) {
//        return accountSumaryService.findAllByAccountId(accountId);

//        Set<String> dateClassifies = new HashSet<>();
//        List<String> fetches = (List<String>) jpaQueryFactory.select(article.articleCreateTime).from(article).where(article.accountId.eq(accountId)).orderBy(article.articleCreateTime.asc()).fetch();
//        for (String fetch :fetches) {
//            ArticleDateClassify dateClassify = new ArticleDateClassify(fetch.substring(0,4),fetch.substring(5,7));
//
//            dateClassifies.add( dateClassify.toString());
//        }
//        JSONObject jsonObject = new JSONObject();
//        List<JSONObject> jsonObjectList = new ArrayList<JSONObject>();
//        Map map = new HashMap<String,String>();
//        for (Iterator<String> it = dateClassifies.iterator(); it.hasNext(); ) {
//            String date = it.next();
//            jsonObject.put("year",date.substring(0,4));
//            jsonObject.put("month",date.substring(4,6));
//            jsonObjectList.add(jsonObject);
//        }
//        return jsonObjectList;
//    }

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
    public List<Article> getArticlesByLabelName(int accountId,String labelName) {
//        List<Integer> articlesId = jpaQueryFactory.select(article.id)
//                .from(article)
//                .where(article.accountId.eq(accountId))
//                .fetch();
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

//        return jpaQueryFactory.select(article)
//                .from(article)
//                .where(article.id.in(articlesId))
//                .orderBy(article.articleCreateTime.asc())
//                .fetch();
    }





}
