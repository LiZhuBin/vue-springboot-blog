package com.springboot.blog.service;



import com.springboot.blog.entity.db.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<Account> getAccounts();

    Optional<Account> getAccountById(int id);
    Account checkAccount(String name,String password);
    Boolean exists(int id);
}
