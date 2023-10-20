package com.example.repository;

import com.example.model.User;
import com.example.model.UserInfo;
import jakarta.servlet.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.example.repository.BaseSQL;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  List<User> findAllByOrderByIdAsc();
  User findByUsername(String username);
  User findById(long user_id);
  Boolean existsByUsername(String username);
  Boolean existsByEmail(String email);

  @Query(value= BaseSQL.S0001, nativeQuery = true)
  UserInfo userInfo(@Param("id") long id);

}