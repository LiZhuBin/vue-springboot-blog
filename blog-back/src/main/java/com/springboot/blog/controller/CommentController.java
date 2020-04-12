package com.springboot.blog.controller;

import com.springboot.blog.service.CommentService;
import com.springboot.blog.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @program: vue-springboot-blog
 * @description: 评论控制类
 * @author: LiZhuBin
 * @create: 2020-02-27 16:28
 **/
@RestController

@RequestMapping(value = "/v1/comments/")
@ResponseBody
public class CommentController {
    @Autowired
    CommentService commentService;
    @Autowired
    ReplyService replyService;

    @GetMapping("{id}")
    public List<Map<String, Object>> comments (@RequestParam(value = "type") String type,@PathVariable(value = "id") int id){
        return commentService.getCommentByArticleId(type,id);
    }
}
