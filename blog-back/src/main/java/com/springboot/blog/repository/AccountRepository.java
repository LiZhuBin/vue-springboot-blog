package com.springboot.blog.repository;

import com.springboot.blog.entity.db.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AccountRepository extends JpaRepository<Account, Integer> , QuerydslPredicateExecutor<Account> {
    Account findByAccountNameAndAccountPassword(String name, String password);


}
