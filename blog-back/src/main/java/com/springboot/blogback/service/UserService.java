package com.springboot.blogback.service;

import com.springboot.blogback.entity.db.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
}
