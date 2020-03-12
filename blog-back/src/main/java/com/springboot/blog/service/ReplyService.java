package com.springboot.blog.service;

import com.springboot.blog.entity.db.Reply;

import java.util.List;

public interface ReplyService {
    List<Reply> byCommentIdAndToId(int toId);
}
