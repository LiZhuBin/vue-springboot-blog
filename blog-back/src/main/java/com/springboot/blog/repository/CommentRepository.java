package com.springboot.blog.repository;

import com.springboot.blog.entity.db.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

/**
 * @program: vue-springboot-blog
 * @description: 评论
 * @author: LiZhuBin
 * @create: 2020-02-27 13:57
 **/
public interface CommentRepository  extends JpaRepository<Comment,Integer>, QuerydslPredicateExecutor<Comment> {
    List<Comment> findAllByTopicId(int topicId);
}
