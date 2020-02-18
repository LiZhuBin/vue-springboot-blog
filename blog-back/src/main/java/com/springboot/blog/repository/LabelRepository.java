package com.springboot.blog.repository;

import com.springboot.blog.entity.db.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface LabelRepository extends JpaRepository<Label,Integer> , QuerydslPredicateExecutor<Label> {

//    @Query(nativeQuery = true,value = "select label.label_name,label.id from label where label.id = any(select article_to_label.label_id from article_to_label where article_to_label.article_id = :#{#articleId})")
//    List<Map> getLabelsByArticleId(@Param("articleId") int articleId);
//
//    @Query(nativeQuery = true,value = "select label.label_name,label.id from label where label.id = any(select article_to_label.label_id from article_to_label where article_to_label.article_id = any(select article.id from article where article.account_id=:#{#accountId}))")
//    List<Map> getLabelsByAccountId(@Param("accountId") int accountId);

}
