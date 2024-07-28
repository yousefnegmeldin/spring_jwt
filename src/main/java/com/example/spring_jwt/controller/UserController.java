package com.example.spring_jwt.controller;


import com.example.spring_jwt.dto.UserDTO;
import com.example.spring_jwt.model.User;
import com.example.spring_jwt.service.UserService;
import com.example.spring_jwt.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        User userFound = userService.findById(id).get();
        return userService.convertToDTO(userFound);
    }

    @PostMapping
    public UserDTO createUser(@RequestBody User user){
        User savedUser = userService.saveUser(user);
        return userService.convertToDTO(savedUser);
    }

}
