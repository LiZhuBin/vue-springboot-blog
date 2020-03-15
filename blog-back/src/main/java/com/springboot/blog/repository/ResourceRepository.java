package com.springboot.blog.repository;

import com.springboot.blog.entity.db.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource,Integer>, QuerydslPredicateExecutor<Resource> {
}
