package com.springboot.blog.controller;

import com.springboot.blog.entity.db.Reply;
import com.springboot.blog.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: blog-back
 * @description:
 * @author: LiZhuBin
 * @create: 2020-04-16 00:47
 **/
@RestController

@RequestMapping(value = "/v1/replies")
@ResponseBody
public class ReplyCtr {
    @Autowired
    ReplyService replyService;
    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<Reply> getReply(@RequestParam (value = "commentId",required = true) int commentId){
        return replyService.byCommentId(commentId);
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public Reply insertReply(@RequestBody Reply r){
        return replyService.insert(r);
    }
}
