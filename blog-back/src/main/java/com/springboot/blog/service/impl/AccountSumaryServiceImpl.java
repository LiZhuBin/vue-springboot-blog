package com.springboot.blog.service.impl;

import com.springboot.blog.entity.db.AccountSumary;
import com.springboot.blog.repository.AccountSumaryRepository;
import com.springboot.blog.service.AccountSumaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountSumaryServiceImpl implements AccountSumaryService {

    @Autowired
    AccountSumaryRepository accountSumaryRepository;
    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public AccountSumary findAllByAccountId(int AccountId) {


        Query query = new Query(Criteria.where("account_id").is(AccountId));
        return mongoTemplate.findOne(query,AccountSumary.class);
    }

    @Override
    public List<AccountSumary> findAll() {
        return accountSumaryRepository.findAll();
    }
}
