package com.example.spring_jwt.service;


import com.example.spring_jwt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final List<User> users = new ArrayList<>();

    @Override
    public User saveUser(User user) {
        user.setId((long) users.size());
        users.add(user);
        return user;
    }

    @Override
    public void deleteByUserId(Long userId) {
        users.removeIf(user -> user.getId().equals(userId));
    }

    @Override
    public User updateUser(User user) {
        int index = -1;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(user.getId())) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            users.set(index, user);
            return user;
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    @Override
    public String getSecret(User user) {
        // Implement this method
        return "";
    }

    @Override
    public Optional<User> findById(Long userId) {
        return users.stream().filter(user -> user.getId().equals(userId)).findFirst();
    }
}
