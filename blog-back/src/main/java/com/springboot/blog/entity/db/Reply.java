package com.springboot.blog.entity.db;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @program: blog-back
 * @description:
 * @author: LiZhuBin
 * @create: 2020-03-30 13:54
 **/
@Entity
@Table(name = "reply", schema = "vue_springboot_blog")
public class Reply {
    private int id;
    private String replyContent;
    private Integer fromId;
    private Integer toId;
    private Timestamp replyTime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "reply_content")
    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    @Basic
    @Column(name = "from_id")
    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    @Basic
    @Column(name = "to_id")
    public Integer getToId() {
        return toId;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
    }

    @Basic
    @Column(name = "reply_time")
    public Timestamp getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Timestamp replyTime) {
        this.replyTime = replyTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reply reply = (Reply) o;
        return id == reply.id &&
                Objects.equals(replyContent, reply.replyContent) &&
                Objects.equals(fromId, reply.fromId) &&
                Objects.equals(toId, reply.toId) &&
                Objects.equals(replyTime, reply.replyTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, replyContent, fromId, toId, replyTime);
    }
}
