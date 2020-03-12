package com.springboot.blog.service.impl;

import com.springboot.blog.entity.db.Comment;
import com.springboot.blog.repository.CommentRepository;
import com.springboot.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: vue-springboot-blog
 * @description: 评论模块功能实现
 * @author: LiZhuBin
 * @create: 2020-02-27 14:00
 **/
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository r;
    @Override
    public List<Comment> byTopicId(int topicId) {

        return r.findAllByTopicId(topicId);
    }
}
