package com.example.service;


import java.util.List;

import com.example.model.User;
import com.example.model.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
  List<User> findAll();
  User save(User user);
  User findByUsername(String username);
  User findById(long id);
  Boolean existsByUsername(String username);
  void delete(User user);

  Page<User> findAllByOrderByIdAsc(Pageable pageable);

  Page<User> findUserBySearch(String search, Pageable pageable);

  UserInfo userInfo(long id);
}
