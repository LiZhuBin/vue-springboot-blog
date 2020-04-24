package com.springboot.blog.service;

import com.springboot.blog.entity.db.LeftMessage;

import java.util.List;

/**
 * @program: blog-back
 * @description:
 * @author: LiZhuBin
 * @create: 2020-04-13 01:11
 **/
public interface MessageSer {
    List<LeftMessage> allMsg(LeftMessage l);
    LeftMessage add(LeftMessage leftMessage);
}
