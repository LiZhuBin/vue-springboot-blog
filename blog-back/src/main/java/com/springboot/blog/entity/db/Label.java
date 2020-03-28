package com.springboot.blog.entity.db;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "label")
public class Label implements Serializable {
    private int id;
    private String labelName;
    private int articleId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "label_name")
    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Label label = (Label) o;
        return id == label.id &&
                Objects.equals(labelName, label.labelName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, labelName);
    }

    @Basic
    @Column(name = "article_id")
    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }
}
