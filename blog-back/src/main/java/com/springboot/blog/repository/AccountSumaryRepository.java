package com.springboot.blog.repository;

import com.springboot.blog.entity.db.AccountSumary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountSumaryRepository  extends MongoRepository<AccountSumary,String> {

}
