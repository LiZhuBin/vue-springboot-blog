package com.springboot.blog.entity.db;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.regex.Pattern;

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

    public LeftMessage() {
    }

    private int fromId;
    private int toId;
    private String fromName;
    private String fromHead;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp createTime;
    private String messageContent;
    private Boolean messagePower;

    public LeftMessage(Builder builder) {
        setId(builder.id);
        setFromId(builder.fromId);
        setToId(builder.toId);
        setFromName(builder.fromName);
        setFromHead(builder.fromHead);
        setCreateTime(builder.createTime);
        setMessageContent(builder.messageContent);
        setMessagePower(builder.messagePower);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "from_id" , nullable = false)
    public int getFromId() {
        return fromId;
    }

    public void setFromId(int fromId) {
        this.fromId = fromId;
    }

    @Basic
    @Column(name = "to_id",nullable = false)
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

    public static final class Builder {
        private int id;
        private int fromId;
        private int toId;
        private String fromName;
        private String fromHead;
        private Timestamp createTime;
        private String messageContent;
        private Boolean messagePower;

        public Builder() {
        }

        public Builder id(int val) {
            id = val;
            return this;
        }

        public Builder fromId(int val) {
            fromId = val;
            return this;
        }

        public Builder toId(int val) {
            toId = val;
            return this;
        }

        public Builder fromName(String val) {
            fromName = val;
            return this;
        }

        public Builder fromHead(String val) {
            fromHead = val;
            return this;
        }

        public Builder createTime(Timestamp val) {
            createTime = val;
            return this;
        }

        public Builder messageContent(String val) {
            messageContent = val;
            return this;
        }

        public Builder messagePower(Boolean val) {
            messagePower = val;
            return this;
        }

        public LeftMessage build() {
            return new LeftMessage(this);
        }
    }
}
