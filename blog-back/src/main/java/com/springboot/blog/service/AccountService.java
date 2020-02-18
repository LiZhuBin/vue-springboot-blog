package com.springboot.blog.service;


import com.springboot.blog.entity.db.Account;

import java.util.Optional;

public interface AccountService {

    Optional<Account> getAccountById(int id);
    Account otherViewAccountById(int id);
    Account checkAccount(String name,String password);
    Boolean exists(int id);

}
