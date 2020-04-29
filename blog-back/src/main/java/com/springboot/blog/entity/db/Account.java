package com.springboot.blog.entity.db;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.annotation.JsonView;
import com.springboot.blog.manager.AccountViews;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "account")
public class Account implements Serializable {


//    private Set<Article> articles = new HashSet<>();
//
//    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
//    @JoinColumn(name = "account_id",referencedColumnName = "id")
//    public Set<Article> getArticles() {
//        return articles;
//    }
//
//    public void setArticles(Set<Article> articles) {
//        this.articles = articles;
//    }

    @JsonView(AccountViews.BaseView.class)
    private int id;
    @JsonView(AccountViews.BaseView.class)
    private String accountName;
    @JsonView(AccountViews.OthersView.class)
    private String accountHead;
    @JsonView(AccountViews.OthersView.class)
    private String accountSign;
    @JsonView(AccountViews.OthersView.class)
    private Integer communicationId;
    @JsonView(AccountViews.OthersView.class)
    private String accountCompany;
    @JsonView(AccountViews.OthersView.class)
    private String accountSite;
    @JsonView(AccountViews.SelfView.class)
    private String accountCreateDate;
    @JsonView(AccountViews.SelfView.class)
    private String accountBirthDate;
    private String accountPassword;
    @JsonView(AccountViews.OthersView.class)
    private Boolean accountAdmin;

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
    @Column(name = "account_head")
    public String getAccountHead() {
        return accountHead;
    }

    public void setAccountHead(String accountHead) {
        this.accountHead = accountHead;
    }

    @Basic
    @Column(name = "account_sign")
    public String getAccountSign() {
        return accountSign;
    }

    public void setAccountSign(String accountSign) {
        this.accountSign = accountSign;
    }

    @Basic
    @Column(name = "communication_id")
    public Integer getCommunicationId() {
        return communicationId;
    }

    public void setCommunicationId(Integer communicationId) {
        this.communicationId = communicationId;
    }

    @Basic
    @Column(name = "account_name")
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Basic
    @Column(name = "account_password")
    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    @Basic
    @Column(name = "account_create_date")
    public String getAccountCreateDate() {
        return accountCreateDate;
    }

    public void setAccountCreateDate(String accountCreateDate) {
        this.accountCreateDate = accountCreateDate;
    }

    @Basic
    @Column(name = "account_birth_date")
    public String getAccountBirthDate() {
        return accountBirthDate;
    }

    public void setAccountBirthDate(String accountBirthDate) {
        this.accountBirthDate = accountBirthDate;
    }

    @Basic
    @Column(name = "account_company")
    public String getAccountCompany() {
        return accountCompany;
    }

    public void setAccountCompany(String accountCompany) {
        this.accountCompany = accountCompany;
    }

    @Basic
    @Column(name = "account_site")
    public String getAccountSite() {
        return accountSite;
    }

    public void setAccountSite(String accountSite) {
        this.accountSite = accountSite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id &&
                Objects.equals(accountHead, account.accountHead) &&
                Objects.equals(accountSign, account.accountSign) &&
                Objects.equals(communicationId, account.communicationId) &&
                Objects.equals(accountName, account.accountName) &&
                Objects.equals(accountPassword, account.accountPassword) &&
                Objects.equals(accountCreateDate, account.accountCreateDate) &&
                Objects.equals(accountBirthDate, account.accountBirthDate) &&
                Objects.equals(accountCompany, account.accountCompany) &&
                Objects.equals(accountSite, account.accountSite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountHead, accountSign, communicationId, accountName, accountPassword, accountCreateDate, accountBirthDate, accountCompany, accountSite);
    }

    @Basic
    @Column(name = "account_admin")
    public Boolean getAccountAdmin() {
        return accountAdmin;
    }

    public void setAccountAdmin(Boolean accountAdmin) {
        this.accountAdmin = accountAdmin;
    }


}
