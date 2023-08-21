package com.example.demo.repositary;

import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositary extends JpaRepository<User,String> {
   Optional<User> findByUsername(String username);
}
