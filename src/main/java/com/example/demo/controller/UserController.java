package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserMapper userMapper;

    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping
    public List<User> list() {
        return userMapper.findAll();
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        userMapper.insert(user);
        return ResponseEntity.ok(user);
    }
}

