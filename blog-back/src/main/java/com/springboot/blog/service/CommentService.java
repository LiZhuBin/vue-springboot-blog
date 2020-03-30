package com.springboot.blog.service;

import com.springboot.blog.entity.db.Comment;

import java.util.List;
import java.util.Map;

public interface CommentService {
    List<Map<String, Object>> getCommentByArticleId(int articleId);
    List<Comment> byArticleId(int articleId);
}
