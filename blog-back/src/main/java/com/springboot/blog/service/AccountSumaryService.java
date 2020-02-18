package com.springboot.blog.service;

import com.springboot.blog.entity.db.AccountSumary;

import java.util.List;

public interface AccountSumaryService {
    public AccountSumary findAllByAccountId(int AccountId);
    public List<AccountSumary> findAll();
}
