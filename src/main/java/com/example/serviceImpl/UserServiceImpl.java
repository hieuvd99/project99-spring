package com.example.serviceImpl;

import com.example.model.User;
import com.example.dao.repository.UserRepository;
import com.example.model.UserInfo;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public List<User> findAll() {
    // TODO Auto-generated method stub
    return userRepository.findAll();
  }

  @Override
  public User save(User user) {
    // TODO Auto-generated method stub
    return userRepository.save(user);
  }

  @Override
  public User findByUsername(String username) {
    // TODO Auto-generated method stub
    return userRepository.findByUsername(username);
  }

  @Override
  public User findById(long id) {
    return userRepository.findById(id);
  }

  @Override
  public Boolean existsByUsername(String username) {
    // TODO Auto-generated method stub
    return userRepository.existsByUsername(username);
  }

  @Override
  public void delete(User user) {
    userRepository.delete(user);
  }

  @Override
  public Page<User> findAllByOrderByIdAsc(Pageable pageable) {
    return userRepository.findAllByOrderByIdAsc(pageable);
  }

  @Override
  public Page<User> findUserBySearch(String search, Pageable pageable) {
    return userRepository.findUserBySearch(search, pageable);
  }

  @Override
  public UserInfo userInfo(long id) {
    return userRepository.userInfo(id);
  }

}
