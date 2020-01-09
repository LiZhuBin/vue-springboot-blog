package com.springboot.blog.entity.db;

import com.fasterxml.jackson.annotation.JsonView;
import com.springboot.blog.manager.AccountManager;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.web.servlet.View;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "account")
public class Account{
    private int id;
    @JsonView(AccountManager.Entity_1.class)
    private String accountHead;
    @JsonView(AccountManager.Entity_1.class)
    private String accountSign;
    @JsonView(AccountManager.Entity_1.class)
    private Integer communicationId;
    @JsonView(AccountManager.Entity_1.class)
    private String accountName;
    @JsonView(AccountManager.Entity_2.class)
    private String accountPassword;
    private String accountCreateDate;
    private String accountBirthDate;
    private String accountCompany;

    private String accountSite;

    @Id
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
}
