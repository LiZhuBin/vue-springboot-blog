package com.springboot.blogback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
//    List<User> findAllBy(int id);
}
