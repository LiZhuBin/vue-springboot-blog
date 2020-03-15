package com.springboot.blog.service.impl;

import com.fasterxml.jackson.annotation.JsonView;
import com.querydsl.core.BooleanBuilder;
import com.springboot.blog.entity.db.Account;
import com.springboot.blog.entity.db.QAccount;
import com.springboot.blog.manager.AccountViews;
import com.springboot.blog.repository.AccountRepository;
import com.springboot.blog.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@CacheConfig(cacheNames = "accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;



    /*通过作者id查找用户信息*/
    @CachePut(value = "account", key = "#p0")
    @JsonView(AccountViews.SelfView.class)
    @Override
    public Optional<Account> getAccountById(int id) {


        QAccount account = QAccount.account;
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(account.id.eq(id));
        return accountRepository.findOne(builder);
//        QAccount account = QAccount.account;
//        return jpaQuery
//                .select()
//                .from(account)
//                .where(account.id.eq(id))
//                .fetchOne();

    }

    @Override
    @JsonView(AccountViews.OthersView.class)
    public Account otherViewAccountById(int id) {
        return accountRepository.findById(id).get();
    }
    @CachePut(value = "account",key = "#p0")
    @Override
    public Account checkAccount(String name, String password) {
        return accountRepository.findByAccountNameAndAccountPassword(name,password);
    }

    @Override
    public Account byName(String name) {
        return accountRepository.findByAccountName(name);
    }

    @CacheEvict(value = "account")
    public void clearAccountCache(Integer pId)
    {

    }
    @Override
    public Boolean exists(int id) {
        return accountRepository.existsById(id);
    }


}
