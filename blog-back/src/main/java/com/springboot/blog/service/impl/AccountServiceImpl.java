package com.springboot.blog.service.impl;

import com.querydsl.core.BooleanBuilder;
import com.springboot.blog.entity.db.Account;
import com.springboot.blog.entity.db.QAccount;
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

    @CachePut(value = "account",key = "#p0")
    @Override
    public Account checkAccount(String name, String password) {
        return accountRepository.findByAccountNameAndAccountPassword(name,password);
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
