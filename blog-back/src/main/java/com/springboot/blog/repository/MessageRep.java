package com.springboot.blog.repository;

import com.springboot.blog.entity.db.Label;
import com.springboot.blog.entity.db.LeftMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

/**
 * @program: blog-back
 * @description:
 * @author: LiZhuBin
 * @create: 2020-04-13 01:14
 **/
public interface MessageRep  extends JpaRepository<LeftMessage,Integer>, QuerydslPredicateExecutor<LeftMessage> {
    List<LeftMessage> findAllByToIdAndAndMessagePowerAndFromId(int accountId,boolean power,int fromId);
    List<LeftMessage> findAllByToId(int accountId);

}
