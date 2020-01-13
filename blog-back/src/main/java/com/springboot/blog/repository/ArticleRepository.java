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
        @Query(nativeQuery = true,value = "select label.label_name from label where label.id = :#{#articleId};")
        List<Map> LabelInfo(@Param("articleId") int articleId);

}
