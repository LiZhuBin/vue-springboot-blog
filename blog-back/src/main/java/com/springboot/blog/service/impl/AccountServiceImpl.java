package com.springboot.blog.service.impl;

import com.springboot.blog.entity.db.Account;
import com.springboot.blog.repository.AccountRepository;
import com.springboot.blog.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> getAccountById(int id) {

        return accountRepository.findById(id);
    }

    @Override
    public Account checkAccount(String name, String password) {
        return accountRepository.findByAccountNameAndAccountPassword(name,password);
    }

    @Override
    public Boolean exists(int id) {
        return accountRepository.existsById(id);
    }
}
