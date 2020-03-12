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
@Table(name = "comment", schema = "vue_springboot_blog")
public class Comment {
    private int id;
    private int topicId;
    private Integer topicType;
    private String content;
    private Integer fromId;
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
    @Column(name = "topic_id")
    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    @Basic
    @Column(name = "topic_type")
    public Integer getTopicType() {
        return topicType;
    }

    public void setTopicType(Integer topicType) {
        this.topicType = topicType;
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
    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
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
        Comment comment = (Comment) o;
        return id == comment.id &&
                topicId == comment.topicId &&
                Objects.equals(topicType, comment.topicType) &&
                Objects.equals(content, comment.content) &&
                Objects.equals(fromId, comment.fromId) &&
                Objects.equals(createTime, comment.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, topicId, topicType, content, fromId, createTime);
    }
}
