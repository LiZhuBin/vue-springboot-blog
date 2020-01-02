package com.springboot.blogback.entity.db;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "article_tag", schema = "vue_springboot_blog", catalog = "")
public class ArticleTag {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }
}
