package com.example.spring_jwt.mapper;

import com.example.spring_jwt.dto.UserDTO;
import com.example.spring_jwt.model.User;

public class UserMapper {

    // Converts User entity to UserDTO
    public static UserDTO toUserDTO(User user) {
        if (user == null) {
            return null;
        }
        return new UserDTO(user.getName(), user.getUsername(), user.getEmail());
    }

    // Converts UserDTO to User entity
    public static User toUser(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        return new User(null, userDTO.name(), userDTO.username(), userDTO.email());
    }
}
