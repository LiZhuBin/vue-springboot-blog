package com.springboot.blog.entity.db;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "communication")
public class Communication implements Serializable {
    private int id;
    private String communicationPhone;
    private String communicationEmail;
    private String communicationQq;
    private String communicationGithub;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "communication_phone")
    public String getCommunicationPhone() {
        return communicationPhone;
    }

    public void setCommunicationPhone(String communicationPhone) {
        this.communicationPhone = communicationPhone;
    }

    @Basic
    @Column(name = "communication_email")
    public String getCommunicationEmail() {
        return communicationEmail;
    }

    public void setCommunicationEmail(String communicationEmail) {
        this.communicationEmail = communicationEmail;
    }

    @Basic
    @Column(name = "communication_qq")
    public String getCommunicationQq() {
        return communicationQq;
    }

    public void setCommunicationQq(String communicationQq) {
        this.communicationQq = communicationQq;
    }

    @Basic
    @Column(name = "communication_github")
    public String getCommunicationGithub() {
        return communicationGithub;
    }

    public void setCommunicationGithub(String communicationGithub) {
        this.communicationGithub = communicationGithub;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Communication that = (Communication) o;
        return id == that.id &&
                Objects.equals(communicationPhone, that.communicationPhone) &&
                Objects.equals(communicationEmail, that.communicationEmail) &&
                Objects.equals(communicationQq, that.communicationQq) &&
                Objects.equals(communicationGithub, that.communicationGithub);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, communicationPhone, communicationEmail, communicationQq, communicationGithub);
    }
}
