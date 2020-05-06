package com.springboot.blog.entity.db;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @program: blog-back
 * @description:
 * @author: LiZhuBin
 * @create: 2020-05-06 10:15
 **/
@Entity
@Table(name = "comment", schema = "vue_springboot_blog")
public class Comment {
    private int id;
    private String commentContent;
    private Integer fromId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp commentTime;
    private Integer toId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "comment_content")
    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
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
    @Column(name = "comment_time")
    public Timestamp getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Timestamp commentTime) {
        this.commentTime = commentTime;
    }

    @Basic
    @Column(name = "to_id")
    public Integer getToId() {
        return toId;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id == comment.id &&
                Objects.equals(commentContent, comment.commentContent) &&
                Objects.equals(fromId, comment.fromId) &&
                Objects.equals(commentTime, comment.commentTime) &&
                Objects.equals(toId, comment.toId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, commentContent, fromId, commentTime, toId);
    }
}
