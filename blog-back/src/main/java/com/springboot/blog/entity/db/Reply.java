package com.springboot.blog.entity.db;

import javax.persistence.*;
import java.util.Objects;

/**
 * @program: vue-springboot-blog
 * @description:
 * @author: LiZhuBin
 * @create: 2020-02-27 22:55
 **/
@Entity
@Table(name = "reply", schema = "vue_springboot_blog")
public class Reply {
    private int id;
    private int commentId;
    private String content;
    private int fromId;
    private int toId;
    private String createTime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "comment_id")
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
    @Column(name = "create_time")
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reply reply = (Reply) o;
        return id == reply.id &&
                commentId == reply.commentId &&
                fromId == reply.fromId &&
                toId == reply.toId &&
                Objects.equals(content, reply.content) &&
                Objects.equals(createTime, reply.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, commentId, content, fromId, toId, createTime);
    }
}
