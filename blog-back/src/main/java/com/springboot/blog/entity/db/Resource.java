package com.springboot.blog.entity.db;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @program: vue-springboot-blog
 * @description:
 * @author: LiZhuBin
 * @create: 2020-03-16 01:46
 **/
@Entity
@Table(name = "resource", schema = "vue_springboot_blog")
public class Resource {
    private int id;
    private int accountId;
    private String url;
    private int descriptionId;
    private Boolean power;
    private Timestamp date;
    private String text;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "account_id")
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "description_id")
    public int getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(int descriptionId) {
        this.descriptionId = descriptionId;
    }

    @Basic
    @Column(name = "power")
    public Boolean getPower() {
        return power;
    }

    public void setPower(Boolean power) {
        this.power = power;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resource resource = (Resource) o;
        return id == resource.id &&
                accountId == resource.accountId &&
                descriptionId == resource.descriptionId &&
                Objects.equals(url, resource.url) &&
                Objects.equals(power, resource.power) &&
                Objects.equals(date, resource.date) &&
                Objects.equals(text, resource.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountId, url, descriptionId, power, date, text);
    }
}
