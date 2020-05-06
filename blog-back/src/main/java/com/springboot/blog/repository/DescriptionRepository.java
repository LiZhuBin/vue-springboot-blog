package com.springboot.blog.repository;

import com.springboot.blog.entity.db.Comment;
import com.springboot.blog.entity.db.Description;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface DescriptionRepository extends JpaRepository<Description,Integer>, QuerydslPredicateExecutor<Description> {
    public Description findByName(String name);
}
