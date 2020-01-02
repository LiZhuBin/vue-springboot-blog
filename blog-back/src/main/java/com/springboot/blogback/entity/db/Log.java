package com.springboot.blogback.entity.db;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Log {

    private int id;
    private Timestamp createDate;
    private String ip;
    private String method;
    private String module;
    private String nickname;
    private String operation;
    private String params;
    private Long time;
    private Long userid;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "create_date", nullable = true)
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "ip", nullable = true, length = 15)
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Basic
    @Column(name = "method", nullable = true, length = 100)
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Basic
    @Column(name = "module", nullable = true, length = 10)
    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    @Basic
    @Column(name = "nickname", nullable = true, length = 10)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "operation", nullable = true, length = 25)
    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Basic
    @Column(name = "params", nullable = true, length = 255)
    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    @Basic
    @Column(name = "time", nullable = true)
    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Basic
    @Column(name = "userid", nullable = true)
    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return id == log.id &&
                Objects.equals(createDate, log.createDate) &&
                Objects.equals(ip, log.ip) &&
                Objects.equals(method, log.method) &&
                Objects.equals(module, log.module) &&
                Objects.equals(nickname, log.nickname) &&
                Objects.equals(operation, log.operation) &&
                Objects.equals(params, log.params) &&
                Objects.equals(time, log.time) &&
                Objects.equals(userid, log.userid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createDate, ip, method, module, nickname, operation, params, time, userid);
    }
}
