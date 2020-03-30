package com.springboot.blog.repository;

import com.springboot.blog.entity.db.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface LabelRepository extends JpaRepository<Label,Integer> , QuerydslPredicateExecutor<Label> {

    public List<Label> findAllByArticleId(int articleId);
    List<Label> findAllByLabelName(String labelName);
}
