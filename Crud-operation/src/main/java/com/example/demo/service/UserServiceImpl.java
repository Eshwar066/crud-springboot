package com.example.demo.service;

import com.example.demo.models.User;
import com.example.demo.repositary.UserRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepositary userRepositary;

    @Autowired
    public UserServiceImpl(UserRepositary userRepositary) {
        this.userRepositary = userRepositary;
    }

    @Override
    public User createUser(User user) {
        return userRepositary.save(user);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepositary.findByUsername(username);
    }

    @Override
    public User updateUserPassword(String username, String newPassword) {
        Optional<User> optionalUser = userRepositary.findByUsername(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setPassword(newPassword);
            return userRepositary.save(user);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public void deleteUser(String username) {
        Optional<User> optionalUser = userRepositary.findByUsername(username);
        if (optionalUser.isPresent()) {
            userRepositary.delete(optionalUser.get());
        } else {
            throw new RuntimeException("User not found");
        }
    }
}
