package com.example.service;

import java.util.List;

import com.example.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
  List<User> findAll();
  User save(User user);
  User findByUsername(String username);
  User findById(long id);
  Boolean existsByUsername(String username);
}
