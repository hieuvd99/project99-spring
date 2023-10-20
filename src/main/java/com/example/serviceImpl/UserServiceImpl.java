package com.example.serviceImpl;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

}
