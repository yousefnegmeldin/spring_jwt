package com.example.spring_jwt.dto;

public record LoginResponseDTO(String token, long expiresIn) {
}
