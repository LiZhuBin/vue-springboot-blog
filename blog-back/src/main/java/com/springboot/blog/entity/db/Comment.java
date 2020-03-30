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
@Table(name = "comment", schema = "vue_springboot_blog")
public class Comment {
    private int id;
    private Integer articleId;
    private String commentContent;
    private Integer fromId;
    private Timestamp commentTime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "article_id")
    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id == comment.id &&
                Objects.equals(articleId, comment.articleId) &&
                Objects.equals(commentContent, comment.commentContent) &&
                Objects.equals(fromId, comment.fromId) &&
                Objects.equals(commentTime, comment.commentTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, articleId, commentContent, fromId, commentTime);
    }
}
