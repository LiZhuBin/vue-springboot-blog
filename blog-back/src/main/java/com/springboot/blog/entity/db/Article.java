package com.springboot.blog.entity.db;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.springboot.blog.manager.ArticleViews;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@DynamicInsert
@DynamicUpdate
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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @JsonView(ArticleViews.BaseView.class)
    private Timestamp articleCreateTime;
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
    @JsonView(ArticleViews.BaseView.class)
    private String articleClassify;
    private Article(Builder builder) {
        setId(builder.id);
        setArticleCreateTime(builder.articleCreateTime);
        setArticleReadCount(builder.articleReadCount);
        setArticleTitle(builder.articleTitle);
        setArticlePicture(builder.articlePicture);
        setAccountId(builder.accountId);
        setArticleDetail(builder.articleDetail);
        setArticleDetailType(builder.articleDetailType);
        setArticleClassify(builder.articleClassify);
    }
    public Article() {
        this.articleDetailType = 0;
        this.articleReadCount = 0;
        this.articlePicture = "https://bingos-1258635419.cos.ap-guangzhou.myqcloud.com/vue_springboot_blog/1/images/%E5%8A%A8%E6%BC%AB/%E4%B8%9C%E4%BA%AC%E9%A3%9F%E5%B0%B8%E9%AC%BC/969352.jpg";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    public Timestamp getArticleCreateTime() {
        return articleCreateTime;
    }

    public void setArticleCreateTime(Timestamp articleCreateTime) {
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

    @Column(name = "article_picture",columnDefinition = "DEFAULT 'dd'")
    public String getArticlePicture() {
        return articlePicture;
    }

    public void setArticlePicture(String articlePicture) {
        this.articlePicture = articlePicture;
    }

    @Basic
    @Column(name = "article_detail_type",columnDefinition = "default '0'")
    public Integer getArticleDetailType() {
        return articleDetailType;
    }

    public void setArticleDetailType(Integer articleDetailType) {
        this.articleDetailType = articleDetailType;
    }

    @Basic
    @Column(name = "account_id")
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
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

    @Basic
    @Column(name = "article_classify")
    public String getArticleClassify() {
        return articleClassify;
    }

    public void setArticleClassify(String articleClassify) {
        this.articleClassify = articleClassify;
    }

    public static final class Builder {
        private int id;
        private Timestamp articleCreateTime;
        private Integer articleReadCount;
        private String articleTitle;
        private String articlePicture;
        private int accountId;
        private String articleDetail;
        private Integer articleDetailType;
        private String articleClassify;

        public Builder(int id, Timestamp articleCreateTime, Integer articleReadCount, String articleTitle, String articlePicture, int accountId, String articleDetail, Integer articleDetailType, String articleClassify) {
            this.id = id;
            this.articleCreateTime = articleCreateTime;
            this.articleReadCount = articleReadCount;
            this.articleTitle = articleTitle;
            this.articlePicture = articlePicture;
            this.accountId = accountId;
            this.articleDetail = articleDetail;
            this.articleDetailType = articleDetailType;
            this.articleClassify = articleClassify;
        }

        public Builder() {
        }

        public Builder id(int val) {
            id = val;
            return this;
        }

        public Builder articleCreateTime(Timestamp val) {
            articleCreateTime = val;
            return this;
        }

        public Builder articleReadCount(Integer val) {
            articleReadCount = val;
            return this;
        }

        public Builder articleTitle(String val) {
            articleTitle = val;
            return this;
        }

        public Builder articlePicture(String val) {
            articlePicture = val;
            return this;
        }

        public Builder accountId(int val) {
            accountId = val;
            return this;
        }

        public Builder articleDetail(String val) {
            articleDetail = val;
            return this;
        }

        public Builder articleDetailType(Integer val) {
            articleDetailType = val;
            return this;
        }

        public Builder articleClassify(String val) {
            articleClassify = val;
            return this;
        }

        public Article build() {
            return new Article(this);
        }
    }
}
