package com.springboot.blog.service;

import com.springboot.blog.entity.db.Reply;

import java.util.List;

public interface ReplyService {
    List<Integer> findNameById(int id);
    Reply insert(Reply r);
    List<Reply> byCommentId(int id);
}
