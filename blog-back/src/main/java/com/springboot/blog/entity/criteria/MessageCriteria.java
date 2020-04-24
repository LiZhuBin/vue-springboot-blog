package com.springboot.blog.entity.criteria;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

/**
 * @program: blog-back
 * @description:
 * @author: LiZhuBin
 * @create: 2020-04-13 16:34
 **/
public class MessageCriteria {
    private int id;
    private int fromId;
    private int toId;
    private String fromName;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp createTime;

    public MessageCriteria() {
    }

    private String messageContent;
    private Boolean messagePower;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFromId() {
        return fromId;
    }

    public void setFromId(int fromId) {
        this.fromId = fromId;
    }

    public int getToId() {
        return toId;
    }

    public void setToId(int toId) {
        this.toId = toId;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Boolean getMessagePower() {
        return messagePower;
    }

    public void setMessagePower(Boolean messagePower) {
        this.messagePower = messagePower;
    }
}
