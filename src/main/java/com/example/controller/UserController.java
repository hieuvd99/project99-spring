package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

  @Autowired
  private UserService userService;

/*  @RequestMapping("/")
  public String home(Model model) {
    String username = "admin";
    String password = "admin";
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String encodedPassword = passwordEncoder.encode(password);

    if(!userService.existsByUsername(username))  {

      User user = new User();
      user.setId(1L);
      user.setUsername(username);
      user.setPassword(encodedPassword);
      user.setEmail("admin@gmail.com");
      userService.save(user);
      System.out.println("====================password: " + encodedPassword);
    }
    return "home";
  }*/

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public List<User> listUser(){
    List<User> user = userService.findAll();
    return user;
  }
}
