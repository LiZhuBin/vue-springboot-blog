package com.springboot.blog.repository;

import com.springboot.blog.entity.db.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article,Integer> {
        public List<Article> findAllByAccountId(int id);
}
