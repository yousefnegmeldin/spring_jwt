package com.example.spring_jwt.service;


import com.example.spring_jwt.model.User;
import com.example.spring_jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserServiceRepository(UserRepository userServiceRepository) {
        this.userRepository = userServiceRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public void deleteByUserId(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>)userRepository.findAll();
    }


    @Override
    public String getSecret(User user) {
        return user.getSecret();
    }

    @Override
    public Optional<User> findById(Long id) {
        Optional<User> opt = Optional.of(userRepository.getReferenceById(id));
        return opt;
    }
}
