package com.example.controller;

import com.example.form.request.UserInfoRequest;
import com.example.model.Address;
import com.example.model.User;
import com.example.model.UserInfo;
import com.example.form.response.MessageResponse;
import com.example.repository.AddressRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/admin")
public class AdminController {

  @Autowired
  UserRepository userRepository;

  @Autowired
  AddressRepository addressRepository;

  @GetMapping("/all-user")
  public List<User> getAllUser(){
    return userRepository.findAllByOrderByIdAsc();
  }

  @GetMapping("/user/{user_id}")
  public UserInfo userInfo(@PathVariable long user_id){
    UserInfo userInfo = userRepository.userInfo(user_id);
    if (userInfo == null) {
      ResponseEntity.badRequest().body(new MessageResponse("Error: Cant find user!"));
    }
    return userInfo;
  }

  @PostMapping("/update-user/{user_id}")
  public ResponseEntity<?> updateEmployee(@PathVariable long user_id, @RequestBody UserInfoRequest userInfoRequest) {
    User user = userRepository.findById(user_id);
    if (user == null) {
      ResponseEntity.badRequest().body(new MessageResponse("Error: Cant find user!"));
    } else {
      user.setUsername(userInfoRequest.getUsername());
      user.setEmail(userInfoRequest.getEmail());
      user.setRole(userInfoRequest.getRole());
      userRepository.save(user);
    }
    Address address = addressRepository.addressByUserID(user_id);
    if (address == null) {
      ResponseEntity.badRequest().body(new MessageResponse("Error: Cant find address!"));
    } else {
      address.setCity(userInfoRequest.getCity());
      address.setCountry(userInfoRequest.getCountry());
      addressRepository.save(address);
    }

    return ResponseEntity.ok(new MessageResponse("Update successfully!"));
  }

  @GetMapping("/delete-user/{user_id}")
  public ResponseEntity<?> deleteUser(@RequestBody @PathVariable long user_id) {
    User user = userRepository.findById(user_id);
    if (user == null) {
      ResponseEntity.badRequest().body(new MessageResponse("Error: Cant find user!"));
    }
    userRepository.delete(user);
    return ResponseEntity.ok(new MessageResponse("Detele successfully!"));
  }

}
