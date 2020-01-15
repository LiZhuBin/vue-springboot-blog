package com.springboot.blog.repository;

import com.springboot.blog.entity.db.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface ArticleRepository extends JpaRepository<Article,Integer> {
        public List<Article> findAllByAccountId(int id);
        //文章关联的读者信息
        @Query(nativeQuery = true,value = "select account.account_head,account.account_name from account  where account.id = :#{#accountId}  ")
        Map accountInfo(@Param("accountId") int accountId);
        //文章列表的信息
        @Query(nativeQuery = true,value = "select * from article where article.account_id =  :#{#accountId} ")
        List<Map> selectArticleInfo(@Param("accountId") int accountId);
        //文章关联的标签信息
        @Query(nativeQuery = true,value = "select label.label_name,label.id from label where label.id = any(select article_to_label.label_id from article_to_label where article_to_label.article_id = :#{#labelId})")
        List<Map> labelInfo(@Param("labelId") int labelId);

}
