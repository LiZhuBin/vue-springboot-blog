package com.springboot.blog.entity.db;

import com.fasterxml.jackson.annotation.JsonFormat;

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
@Table(name = "comment", schema = "vue_springboot_blog")
public class Comment {
    private int id;

    private String commentContent;
    private Integer fromId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp commentTime;
    private String commentType;
    private Integer typeId;

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
    @Column(name = "comment_content",nullable = false)
    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    @Basic
    @Column(name = "from_id",nullable = false)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id == comment.id &&
                Objects.equals(typeId, comment.typeId) &&
                Objects.equals(commentContent, comment.commentContent) &&
                Objects.equals(fromId, comment.fromId) &&
                Objects.equals(commentTime, comment.commentTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,commentType, commentContent, fromId, commentTime);
    }

    @Basic
    @Column(name = "comment_type",nullable = false)
    public String getCommentType() {
        return commentType;
    }

    public void setCommentType(String commentType) {
        this.commentType = commentType;
    }

    @Basic
    @Column(name = "type_id")
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}
