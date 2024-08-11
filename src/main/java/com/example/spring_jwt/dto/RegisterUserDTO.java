package com.example.spring_jwt.dto;

import com.example.spring_jwt.model.UserRoleEnums;

public record RegisterUserDTO(String username, String password, String name, UserRoleEnums role) {
}
