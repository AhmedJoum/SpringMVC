package com.example.demo.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRep extends JpaRepository<User, Long> {
    @Query(value = "select * from user where user_name = ?1 and password = ?2 LIMIT 1", nativeQuery = true)
    User login(String user_name, String password);
}