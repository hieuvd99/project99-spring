package com.example.controller;

import com.example.form.request.UserInfoRequest;
import com.example.model.Address;
import com.example.model.User;
import com.example.model.UserInfo;
import com.example.form.response.MessageResponse;
import com.example.dao.repository.AddressRepository;
import com.example.dao.repository.UserRepository;
import com.example.service.AddressService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/admin")
public class AdminController {

  @Autowired
  AddressService addressService;

  @Autowired
  UserService userService;

  @GetMapping("/all-user")
  public Page<User> getAllUser(@RequestParam("p") Optional<Integer> p){
    Pageable pageable = (Pageable) PageRequest.of(p.orElse(0), 8);
    return userService.findAllByOrderByIdAsc(pageable);
  }

  @GetMapping("/search")
  public Page<User>  searchUser(@RequestParam(name = "search") String search, @RequestParam("p") Optional<Integer> p){
    Pageable pageable = (Pageable) PageRequest.of(p.orElse(0), 8);
    Page<User> user = userService.findUserBySearch(search, pageable);
    if (user == null) {
      ResponseEntity.badRequest().body(new MessageResponse("Error: Cant find user!"));
    }
    return user;
  }

  @GetMapping("/user/{user_id}")
  public UserInfo userInfo(@PathVariable long user_id){
    UserInfo userInfo = userService.userInfo(user_id);
    if (userInfo == null) {
      ResponseEntity.badRequest().body(new MessageResponse("Error: Cant find user!"));
    }
    return userInfo;
  }

  @PostMapping("/update-user/{user_id}")
  public ResponseEntity<?> updateEmployee(@PathVariable long user_id, @RequestBody UserInfoRequest userInfoRequest) {
    User user = userService.findById(user_id);
    if (user == null) {
      ResponseEntity.badRequest().body(new MessageResponse("Error: Cant find user!"));
    } else {
      user.setUsername(userInfoRequest.getUsername());
      user.setEmail(userInfoRequest.getEmail());
      user.setRole(userInfoRequest.getRole());
      userService.save(user);
    }
    Address address = addressService.addressByUserID(user_id);
    if (address == null) {
      ResponseEntity.badRequest().body(new MessageResponse("Error: Cant find address!"));
    } else {
      address.setCity(userInfoRequest.getCity());
      address.setCountry(userInfoRequest.getCountry());
      addressService.save(address);
    }

    return ResponseEntity.ok(new MessageResponse("Update successfully!"));
  }

  @GetMapping("/delete-user/{user_id}")
  public ResponseEntity<?> deleteUser(@RequestBody @PathVariable long user_id) {
    User user = userService.findById(user_id);
    if (user == null) {
      ResponseEntity.badRequest().body(new MessageResponse("Error: Cant find user!"));
    }
    userService.delete(user);
    return ResponseEntity.ok(new MessageResponse("Delete successfully!"));
  }


}
