package com.springboot.blogback.entity.db;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Conmment {

    private int id;
    private Integer acrticleId;
    private String commentContent;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "acrticle_id", nullable = true)
    public Integer getAcrticleId() {
        return acrticleId;
    }

    public void setAcrticleId(Integer acrticleId) {
        this.acrticleId = acrticleId;
    }

    @Basic
    @Column(name = "comment_content", nullable = true, length = 255)
    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conmment conmment = (Conmment) o;
        return id == conmment.id &&
                Objects.equals(acrticleId, conmment.acrticleId) &&
                Objects.equals(commentContent, conmment.commentContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, acrticleId, commentContent);
    }
}
