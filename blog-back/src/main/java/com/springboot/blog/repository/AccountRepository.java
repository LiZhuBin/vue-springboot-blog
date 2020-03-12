package com.springboot.blog.repository;

import com.springboot.blog.entity.db.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AccountRepository extends JpaRepository<Account, Integer> , QuerydslPredicateExecutor<Account> {
    //文章关联的读者信息
//    @Query(nativeQuery = true,value = "select account.account_head,account.account_name from account  where account.id = :#{#accountId}  ")
//    Map accountInfo(@Param("accountId") int accountId);

    Account findByAccountNameAndAccountPassword(String name, String password);
    Account findByAccountName(String name);

}
