package com.springboot.blog.service;



import com.springboot.blog.entity.db.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    public List<Account> getAccounts();

    public Optional<Account> getAccountById(int id);
    public Account checkAccount(String name,String password);
}
