package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.UserDTO;
import com.tweteroo.api.model.UserModel;
import com.tweteroo.api.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/auth/sign-up")
public class UserController {

  @Autowired
  private UserService service;

  @PostMapping
  public void createUser(@RequestBody @Valid UserDTO req) {
    service.createUser(req);
  }

  @GetMapping
  public List<UserModel> getAllUsers() {
    return service.getAllUsers();
  }
}
