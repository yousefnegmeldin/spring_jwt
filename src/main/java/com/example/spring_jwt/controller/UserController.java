package com.example.spring_jwt.controller;


import com.example.spring_jwt.dto.UserDTO;
import com.example.spring_jwt.mapper.UserMapper;
import com.example.spring_jwt.model.User;
import com.example.spring_jwt.service.UserService;
import com.example.spring_jwt.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id) {
        Optional<User> userFound = userService.findById(id);
        if (userFound.isPresent()) {
            return ResponseEntity.ok(UserMapper.toUserDTO(userFound.get()));
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "User not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping
    public UserDTO createUser(@RequestBody User user){
        userService.saveUser(user);
        return UserMapper.toUserDTO(user);
    }
    @GetMapping("/username/{username}")
    public UserDTO getUserByUsername(@PathVariable String username){
        User user = userService.findUserByUsername(username);
        return UserMapper.toUserDTO(user);
    }
    @DeleteMapping("/username/{username}")
    public ResponseEntity<Object> deleteUser(@PathVariable String username){
        userService.deleteByUsername(username);
        Map<String, String> response = new HashMap<>();
        response.put("message", "deleted user "+username+" successfully");
        return ResponseEntity.ok().body(response);
    }
}
