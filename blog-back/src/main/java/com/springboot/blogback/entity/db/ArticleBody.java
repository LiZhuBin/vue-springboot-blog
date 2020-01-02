package com.springboot.blogback.entity.db;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "article_body", schema = "vue_springboot_blog", catalog = "")
public class ArticleBody {
    private long id;
    private String content;
    private String contentHtml;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "content", nullable = true, length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "content_html", nullable = true, length = -1)
    public String getContentHtml() {
        return contentHtml;
    }

    public void setContentHtml(String contentHtml) {
        this.contentHtml = contentHtml;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleBody that = (ArticleBody) o;
        return id == that.id &&
                Objects.equals(content, that.content) &&
                Objects.equals(contentHtml, that.contentHtml);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, contentHtml);
    }
}
