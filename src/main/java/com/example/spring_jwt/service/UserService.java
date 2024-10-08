package com.example.spring_jwt.service;

import com.example.spring_jwt.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    Optional<User> findUserByUsername(String username);

    void deleteByUserId(Long userId);

    void deleteByUsername(String username);

    User updateUser(User user);

    List<User> getAllUsers();

    String getSecret(User user);

    Optional<User> findById(Long id);
}
