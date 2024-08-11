package com.example.spring_jwt.controller;

import com.example.spring_jwt.dto.LoginResponseDTO;
import com.example.spring_jwt.dto.LoginUserDTO;
import com.example.spring_jwt.dto.RegisterUserDTO;
import com.example.spring_jwt.dto.UserDTO;
import com.example.spring_jwt.mapper.UserMapper;
import com.example.spring_jwt.model.User;
import com.example.spring_jwt.service.AuthenticationService;
import com.example.spring_jwt.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthController(JwtService jwtService, AuthenticationService authenticationService){
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> register(@RequestBody RegisterUserDTO registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);
        return ResponseEntity.ok(UserMapper.toUserDTO(registeredUser));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> authenticate(@RequestBody LoginUserDTO loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponseDTO loginResponse = new LoginResponseDTO(jwtToken,jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }

}
