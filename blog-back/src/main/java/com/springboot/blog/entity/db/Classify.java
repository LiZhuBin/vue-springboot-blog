package com.springboot.blog.entity.db;

import javax.persistence.*;
import java.util.Objects;

/**
 * @program: vue-springboot-blog
 * @description:
 * @author: LiZhuBin
 * @create: 2020-03-16 01:46
 **/
@Entity
@Table(name = "classify", schema = "vue_springboot_blog")
public class Classify {
    private int id;
    private Integer view;
    private boolean power;
    private String type;
    private String name;
    private String text;
    private int accountId;

    public Classify() {
        this.view = 0;
        this.text = "";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "view")
    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    @Basic
    @Column(name = "power")
    public boolean isPower() {
        return power;
    }

    public void setPower(boolean power) {
        this.power = power;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        Classify classify = (Classify) o;
        return id == classify.id &&
                power == classify.power &&
                Objects.equals(view, classify.view) &&
                Objects.equals(type, classify.type) &&
                Objects.equals(name, classify.name) &&
                Objects.equals(text, classify.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, view, power, type, name, text);
    }

    @Basic
    @Column(name = "account_id")
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

}
