package com.example.dao.repository;

import com.example.dao.BaseSQL;
import com.example.model.User;
import com.example.model.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  List<User> findAllByOrderByIdAsc();
  User findByUsername(String username);
  User findById(long user_id);
  Boolean existsByUsername(String username);
  Boolean existsByEmail(String email);
  void delete(User user);

  @Query(value= BaseSQL.S0001, nativeQuery = true)
  UserInfo userInfo(@Param("id") long id);

  @Query(value= BaseSQL.S0003, nativeQuery = true)
  Page<User> findUserBySearch(@Param("search") String search, Pageable pageable);

  Page<User> findAllByOrderByIdAsc(Pageable pageable);


}