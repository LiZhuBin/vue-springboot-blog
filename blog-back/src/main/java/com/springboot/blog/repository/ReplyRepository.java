package com.springboot.blog.repository;

import com.springboot.blog.entity.db.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ReplyRepository extends JpaRepository<Reply,Integer>, QuerydslPredicateExecutor<Reply> {
    List<Reply> findAllByCommentId(int commentId);
}