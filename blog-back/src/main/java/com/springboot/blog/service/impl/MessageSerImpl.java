package com.springboot.blog.service.impl;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springboot.blog.entity.db.Account;
import com.springboot.blog.entity.db.LeftMessage;
import com.springboot.blog.entity.db.QLeftMessage;
import com.springboot.blog.repository.MessageRep;
import com.springboot.blog.service.MessageSer;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @program: blog-back
 * @description:
 * @author: LiZhuBin
 * @create: 2020-04-13 01:13
 **/
@Service
public class MessageSerImpl implements MessageSer {
    @Autowired
    MessageRep messageRep;
    @Autowired
    JPAQueryFactory jpaQueryFactory;
    QLeftMessage leftMessage = QLeftMessage.leftMessage;

    @Override
    public List<LeftMessage> allMsg(LeftMessage l) {
        JPAQuery<LeftMessage> query = jpaQueryFactory.selectFrom(leftMessage);
        if(l.getMessagePower()){
            query.where(leftMessage.messagePower.eq(l.getMessagePower()));
        }
        if(0 != l.getFromId()){
            query.where(leftMessage.fromId.eq(l.getFromId()));
        }

        return  query.fetch();
    }

    @Override
    public LeftMessage add(LeftMessage leftMessage) {

        return messageRep.save(leftMessage);
    }
}
