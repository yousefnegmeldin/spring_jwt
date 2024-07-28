package com.example.spring_jwt.service;

import com.example.spring_jwt.dto.UserDTO;
import com.example.spring_jwt.model.User;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    void deleteByUserId(Long userId);
    User updateUser(User user);
    List<User> getAllUsers();
//    @Query(value = "SELECT * FROM User WHERE username = :username", nativeQuery = true)
//    Optional<User> findByUsername(String username);
    String getSecret(User user);
    Optional<User> findById(Long id);
    UserDTO convertToDTO(User user);
}
