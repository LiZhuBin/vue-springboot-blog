package com.springboot.blog.entity.db;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @program: blog-back
 * @description:
 * @author: LiZhuBin
 * @create: 2020-04-13 00:52
 **/
@Entity
@Table(name = "left_message", schema = "vue_springboot_blog", catalog = "")
public class LeftMessage {
    private int id;
    private int fromId;
    private int toId;
    private String fromName;
    private String fromHead;
    private Timestamp createTime;
    private String messageContent;
    private Boolean messagePower;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "from_id")
    public int getFromId() {
        return fromId;
    }

    public void setFromId(int fromId) {
        this.fromId = fromId;
    }

    @Basic
    @Column(name = "to_id")
    public int getToId() {
        return toId;
    }

    public void setToId(int toId) {
        this.toId = toId;
    }

    @Basic
    @Column(name = "from_name")
    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    @Basic
    @Column(name = "from_head")
    public String getFromHead() {
        return fromHead;
    }

    public void setFromHead(String fromHead) {
        this.fromHead = fromHead;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "message_content")
    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    @Basic
    @Column(name = "message_power")
    public Boolean getMessagePower() {
        return messagePower;
    }

    public void setMessagePower(Boolean messagePower) {
        this.messagePower = messagePower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeftMessage that = (LeftMessage) o;
        return id == that.id &&
                fromId == that.fromId &&
                toId == that.toId &&
                Objects.equals(fromName, that.fromName) &&
                Objects.equals(fromHead, that.fromHead) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(messageContent, that.messageContent) &&
                Objects.equals(messagePower, that.messagePower);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fromId, toId, fromName, fromHead, createTime, messageContent, messagePower);
    }
}
