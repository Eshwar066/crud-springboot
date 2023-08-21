package com.example.demo.service;

import com.example.demo.models.User;
import java.util.Optional;

public interface UserService {
    User createUser(User user);
    Optional<User> getUserByUsername(String username);
    User updateUserPassword(String username, String newPassword);
    void deleteUser(String username);
}
