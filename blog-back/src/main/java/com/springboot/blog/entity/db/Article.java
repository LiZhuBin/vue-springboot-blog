package com.springboot.blog.entity.db;

import com.fasterxml.jackson.annotation.JsonView;
import com.springboot.blog.manager.ArticleViews;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "article")
public class Article implements Serializable {
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "account_id",referencedColumnName = "id",insertable = false, updatable = false)
//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }
//
//    private Account account;

    @JsonView(ArticleViews.BaseView.class)
    private int id;
    @JsonView(ArticleViews.BaseView.class)
    private String articleCreateTime;

    @JsonView(ArticleViews.BaseView.class)
    private Integer articleReadCount;

    @JsonView(ArticleViews.ListView.class)
    private String articleTitle;
    @JsonView(ArticleViews.ListView.class)
    private String articlePicture;
    @JsonView(ArticleViews.ListView.class)

    private int accountId;
    @JsonView(ArticleViews.DetailView.class)
    private String articleDetail;
    @JsonView(ArticleViews.DetailView.class)
    private Integer articleDetailType;


    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "article_detail")
    public String getArticleDetail() {
        return articleDetail;
    }

    public void setArticleDetail(String articleDetail) {
        this.articleDetail = articleDetail;
    }



    @Basic
    @Column(name = "article_read_count")
    public Integer getArticleReadCount() {
        return articleReadCount;
    }

    public void setArticleReadCount(Integer articleReadCount) {
        this.articleReadCount = articleReadCount;
    }

    @Basic
    @Column(name = "article_create_time")
    public String getArticleCreateTime() {
        return articleCreateTime;
    }

    public void setArticleCreateTime(String articleCreateTime) {
        this.articleCreateTime = articleCreateTime;
    }

    @Basic
    @Column(name = "article_title")
    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    @Basic
    @Column(name = "article_picture")
    public String getArticlePicture() {
        return articlePicture;
    }

    public void setArticlePicture(String articlePicture) {
        this.articlePicture = articlePicture;
    }

    @Basic
    @Column(name = "article_detail_type")
    public Integer getArticleDetailType() {
        return articleDetailType;
    }

    public void setArticleDetailType(Integer articleDetailType) {
        this.articleDetailType = articleDetailType;
    }

    @Basic
    @Column(name = "account_id",insertable=false,updatable=false)
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return id == article.id &&
                accountId == article.accountId &&
                Objects.equals(articleDetail, article.articleDetail) &&

                Objects.equals(articleReadCount, article.articleReadCount) &&
                Objects.equals(articleCreateTime, article.articleCreateTime) &&
                Objects.equals(articleTitle, article.articleTitle) &&
                Objects.equals(articlePicture, article.articlePicture) &&
                Objects.equals(articleDetailType, article.articleDetailType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, articleDetail, articleReadCount, articleCreateTime, articleTitle, articlePicture, articleDetailType, accountId);
    }
}
