package com.springboot.blog.service.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springboot.blog.entity.db.QReply;
import com.springboot.blog.repository.ReplyRepository;
import com.springboot.blog.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: vue-springboot-blog
 * @description: 回复模块功能实现
 * @author: LiZhuBin
 * @create: 2020-02-27 14:02
 **/
@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    ReplyRepository replyRepository;
    @Autowired
    JPAQueryFactory jpaQueryFactory;
    QReply reply = QReply.reply;

    @Override
    public List<Integer> findNameById(int id) {
        return jpaQueryFactory.select(reply.fromId).from(reply).where(reply.id.eq(id)).fetch();
    }
}
