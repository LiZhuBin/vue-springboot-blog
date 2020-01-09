package com.springboot.blog.repository;

import com.springboot.blog.entity.db.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByAccountNameAndAccountPassword(String name, String password);
}
