package com.example.spring_jwt.controller;


import com.example.spring_jwt.model.User;
import com.example.spring_jwt.service.UserService;
import com.example.spring_jwt.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {
        return userService.findById(userId)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))   // User found, return 200 OK
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); // User not found, return 404 NOT FOUND
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(userService.saveUser(user),HttpStatus.OK);
    }
}
