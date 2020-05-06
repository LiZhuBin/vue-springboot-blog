package com.springboot.blog.controller;

import com.alibaba.druid.sql.visitor.functions.Left;
import com.springboot.blog.entity.criteria.MessageCriteria;
import com.springboot.blog.entity.db.LeftMessage;
import com.springboot.blog.repository.MessageRep;
import com.springboot.blog.service.MessageSer;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Logger;

/**
 * @program: blog-back
 * @description:
 * @author: LiZhuBin
 * @create: 2020-04-13 01:25
 **/
@RestController

@RequestMapping(value = "/v1/messages")
public class MessageCtr {
    @Autowired
    MessageSer messageSer;
    @Autowired
    MessageRep messageRep;
    @GetMapping("")
    public List<LeftMessage> allMessage(@RequestParam(value = "accountId") int accountId,
                                        @RequestParam(value = "power",required = false,defaultValue = "true") boolean power,
                                        @RequestParam(value = "fromId",required = false,defaultValue = "0") int fromId){
        LeftMessage l = new LeftMessage.Builder().toId(accountId).messagePower(power).fromId(fromId).build();

        return messageSer.allMsg(l);
    }

    @PostMapping("")
    public LeftMessage insertMsg(@RequestBody LeftMessage msg){
        msg.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return messageSer.add(msg);
    }
    @DeleteMapping("{id}")
    public void deleteMsg(@PathVariable("id") int id){
        messageSer.delete(id);
    }

}
