package com.example.controller;

import com.example.dao.repository.AddressRepository;
import com.example.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/profile")
public class UserController {

  @Autowired
  UserRepository userRepository;

  @Autowired
  private AddressRepository addressRepository;

//  @PostMapping("/address")
//  public ResponseEntity<?> updateAddress( @RequestBody Address address) {
//
//    User user = userRepository.findById();
//    address.setUser(user);
//    addressRepository.save(address);
//
//    return ResponseEntity.ok(new MessageResponse("Update address successfully!"));
//  }

//  @GetMapping("/test/{user_id}")
//  public UserInfo test(@PathVariable long user_id) {
//
//    UserInfo abc = userRepository.userInfo(user_id);
//
//    return abc;
//  }


}
