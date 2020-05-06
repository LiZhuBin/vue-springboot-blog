package com.springboot.blog.repository;

import com.springboot.blog.entity.db.Article;
import com.springboot.blog.entity.db.Classify;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @program: blog-back
 * @description:
 * @author: LiZhuBin
 * @create: 2020-05-06 23:27
 **/
public interface ClassifyRepository extends JpaRepository<Classify,Integer>, QuerydslPredicateExecutor<Classify> {
    public Classify findByTypeAndName(String type,String name);
}
