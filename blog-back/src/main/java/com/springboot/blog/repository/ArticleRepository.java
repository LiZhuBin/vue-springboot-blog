package com.springboot.blog.repository;

import com.springboot.blog.entity.db.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface ArticleRepository extends JpaRepository<Article,Integer>, QuerydslPredicateExecutor<Article> {


        public List<Article> findAllByAccountId(int id);

        //文章的详细信息

        //文章列表的信息
        @Query(nativeQuery = true,value = "select * from article where article.account_id =  :#{#accountId} ")
        List<Map> selectArticleInfo(@Param("accountId") int accountId);

        @Query(nativeQuery = true,value = "select * from article where article.account_id =  :#{#accountId} order by article_read_count desc limit :#{#line}  ")
        List<Map> hotArticles(@Param("accountId") int accountId,@Param("line") int line);
        @Query(nativeQuery = true,value = "select * from article where article.account_id =  :#{#accountId} order by article_create_time desc limit :#{#line}  ")
        List<Map> newArticles(@Param("accountId") int accountId,@Param("line") int line);

        @Query(nativeQuery = true,value = "select id,article_create_time,article_read_count,article_title from article where article.account_id =  :#{#accountId} ")
        List<Map> selectBaseArticle(@Param("accountId") int accountId);



}
