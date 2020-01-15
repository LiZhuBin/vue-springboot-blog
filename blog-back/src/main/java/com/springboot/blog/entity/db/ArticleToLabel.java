package com.springboot.blog.entity.db;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "article_to_label", schema = "vue_springboot_blog", catalog = "")
public class ArticleToLabel {
    private int id;
    private Integer articleId;
    private Integer labelId;

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
    @Column(name = "label_id")
    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleToLabel that = (ArticleToLabel) o;
        return id == that.id &&
                Objects.equals(articleId, that.articleId) &&
                Objects.equals(labelId, that.labelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, articleId, labelId);
    }
}
