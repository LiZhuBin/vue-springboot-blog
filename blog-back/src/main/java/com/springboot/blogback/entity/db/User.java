package com.springboot.blogback.entity.db;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class User {
    private long id;
    private String account;
    private Boolean admin;
    private String avatar;
    private Timestamp createDate;
    private Boolean deleted;
    private String email;
    private Timestamp lastLogin;
    private String mobilePhoneNumber;
    private String nickname;
    private String password;
    private String salt;
    private String status;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "account", nullable = true, length = 64)
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Basic
    @Column(name = "admin", nullable = true)
    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
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
    @Column(name = "create_date", nullable = true)
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "deleted", nullable = true)
    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 128)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "last_login", nullable = true)
    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Basic
    @Column(name = "mobile_phone_number", nullable = true, length = 20)
    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    @Basic
    @Column(name = "nickname", nullable = true, length = 255)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 64)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "salt", nullable = true, length = 255)
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 255)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(account, user.account) &&
                Objects.equals(admin, user.admin) &&
                Objects.equals(avatar, user.avatar) &&
                Objects.equals(createDate, user.createDate) &&
                Objects.equals(deleted, user.deleted) &&
                Objects.equals(email, user.email) &&
                Objects.equals(lastLogin, user.lastLogin) &&
                Objects.equals(mobilePhoneNumber, user.mobilePhoneNumber) &&
                Objects.equals(nickname, user.nickname) &&
                Objects.equals(password, user.password) &&
                Objects.equals(salt, user.salt) &&
                Objects.equals(status, user.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, admin, avatar, createDate, deleted, email, lastLogin, mobilePhoneNumber, nickname, password, salt, status);
    }

    public static final class UserBuilder {
        private long id;
        private String account;
        private Boolean admin;
        private String avatar;
        private Timestamp createDate;
        private Boolean deleted;
        private String email;
        private Timestamp lastLogin;
        private String mobilePhoneNumber;
        private String nickname;
        private String password;
        private String salt;
        private String status;

        public UserBuilder() {
        }

        public static UserBuilder anUser() {
            return new UserBuilder();
        }

        public UserBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public UserBuilder withAccount(String account) {
            this.account = account;
            return this;
        }

        public UserBuilder withAdmin(Boolean admin) {
            this.admin = admin;
            return this;
        }

        public UserBuilder withAvatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

        public UserBuilder withCreateDate(Timestamp createDate) {
            this.createDate = createDate;
            return this;
        }

        public UserBuilder withDeleted(Boolean deleted) {
            this.deleted = deleted;
            return this;
        }

        public UserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder withLastLogin(Timestamp lastLogin) {
            this.lastLogin = lastLogin;
            return this;
        }

        public UserBuilder withMobilePhoneNumber(String mobilePhoneNumber) {
            this.mobilePhoneNumber = mobilePhoneNumber;
            return this;
        }

        public UserBuilder withNickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public UserBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder withSalt(String salt) {
            this.salt = salt;
            return this;
        }

        public UserBuilder withStatus(String status) {
            this.status = status;
            return this;
        }

        public User build() {
            User user = new User();
            user.setId(id);
            user.setAccount(account);
            user.setAdmin(admin);
            user.setAvatar(avatar);
            user.setCreateDate(createDate);
            user.setDeleted(deleted);
            user.setEmail(email);
            user.setLastLogin(lastLogin);
            user.setMobilePhoneNumber(mobilePhoneNumber);
            user.setNickname(nickname);
            user.setPassword(password);
            user.setSalt(salt);
            user.setStatus(status);
            return user;
        }
    }
}
