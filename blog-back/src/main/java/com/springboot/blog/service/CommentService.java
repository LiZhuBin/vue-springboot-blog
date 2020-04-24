package com.springboot.blog.service;

import com.springboot.blog.entity.db.Comment;

import java.util.List;
import java.util.Map;

public interface CommentService {
    List<Map<String, Object>> getCommentByArticleId(String type,int articleId);
    List<Comment> byArticleId(String type,int articleId);
    Comment insertComment(Comment comment);
}
