package com.springboot.blog.service.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springboot.blog.entity.db.Account;
import com.springboot.blog.entity.db.Comment;
import com.springboot.blog.entity.db.QComment;
import com.springboot.blog.entity.db.Reply;
import com.springboot.blog.repository.CommentRepository;
import com.springboot.blog.repository.ReplyRepository;
import com.springboot.blog.service.AccountService;
import com.springboot.blog.service.CommentService;
import com.springboot.blog.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    JPAQueryFactory jpaQueryFactory;
    @Autowired
    ReplyRepository repository;
    @Autowired
    ReplyService replyService;
    @Autowired
    AccountService accountService;
    QComment qcomment = QComment.comment;
    @Override
    public List<Map<String, Object>> getCommentByArticleId(int articleId) {
        List<Comment> comments=r.findAllByToId(articleId);
        List<Map<String, Object>> newComments = new ArrayList<>();
        List<Map<String, Object>> newReplys;
        Map<String, Object> map;
        Map<String, Object> replymap;
        for(Comment comment:comments){
            map=new HashMap<>();
            map.put("id",comment.getId());
            List<Reply> replys=replyService.byCommentId(comment.getId());
            newReplys = new ArrayList<>();
            if(replys!=null){
                for(Reply reply:replys){
                    replymap=new HashMap<>();
                    Account account = accountService.getAccountById(reply.getFromId()).get();
                    replymap.put("replyName",account.getAccountName());
                    replymap.put("replyContent",reply.getReplyContent());
                    replymap.put("replyImgUrl",account.getAccountHead());
                    replymap.put("replyTime",reply.getReplyTime());

                    newReplys.add(replymap);
                }
                map.put("Replys",newReplys);
            }
            map.put("commentContent",comment.getCommentContent());
            map.put("fromUId",comment.getFromId());
            Account user=accountService.getAccountById(comment.getFromId()).get();
            map.put("username",user.getAccountName());
            map.put("avatarImgUrl",user.getAccountHead());
            map.put("commentTime",comment.getCommentTime());
            newComments.add(map);
        }

        return newComments;
    }

    @Override
    public List<Comment> byArticleId(String type,int articleId) {

        return null;
    }

    @Override
    public Comment insertComment(Comment comment) {
        comment.setCommentTime(new Timestamp(System.currentTimeMillis()));
        return r.save(comment);
    }
}
