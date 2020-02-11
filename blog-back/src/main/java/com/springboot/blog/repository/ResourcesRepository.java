package com.springboot.blog.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourcesRepository extends MongoRepository<Repository,String> {
}
