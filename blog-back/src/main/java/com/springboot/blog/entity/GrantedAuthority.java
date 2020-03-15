package com.springboot.blog.entity;

/**
 * @program: vue-springboot-blog
 * @description:
 * @author: LiZhuBin
 * @create: 2020-03-13 00:45
 **/
class GrantedAuthority {
    private String authority;

    public GrantedAuthority(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }


    public String getAuthority() {
        return this.authority;
    }
}