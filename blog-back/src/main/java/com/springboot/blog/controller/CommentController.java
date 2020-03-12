package com.springboot.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.springboot.blog.entity.db.Comment;
import com.springboot.blog.service.CommentService;
import com.springboot.blog.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: vue-springboot-blog
 * @description: 评论控制类
 * @author: LiZhuBin
 * @create: 2020-02-27 16:28
 **/
@RestController

@RequestMapping(value = "/v1")
@ResponseBody
public class CommentController {
    @Autowired
    CommentService commentService;
    @Autowired
    ReplyService replyService;
    @GetMapping("comment/{topicId}")
    JSONObject byComment(@PathVariable(value = "topicId") int id){
        JSONObject jsonObject = new JSONObject();
        List<Comment> comments = commentService.byTopicId(id);
//        for(Comment comment:comments){
//
//        }
        jsonObject.put("comment",comments);
//        jsonObject.put("reply",replyService.byCommentIdAndToId())
        return jsonObject;
    }
}
