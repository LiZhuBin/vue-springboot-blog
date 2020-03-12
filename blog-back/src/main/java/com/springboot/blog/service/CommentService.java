package com.springboot.blog.service;

import com.springboot.blog.entity.db.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> byTopicId(int topicId);
}
