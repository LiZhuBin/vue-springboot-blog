package com.springboot.blog.repository;

import com.springboot.blog.entity.db.ArticleClassify;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleClassifyRepository extends MongoRepository<ArticleClassify, String> {

}
