package com.springboot.blogback.entity.db;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Tag {
    private int id;
    private String avatar;
    private String tagname;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "avatar", nullable = true, length = 255)
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Basic
    @Column(name = "tagname", nullable = true, length = 255)
    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return id == tag.id &&
                Objects.equals(avatar, tag.avatar) &&
                Objects.equals(tagname, tag.tagname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, avatar, tagname);
    }
}
