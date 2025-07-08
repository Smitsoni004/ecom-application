package com.ecom.app.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.app.entity.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUsername(String username);
    User findByUserId(UUID userId);
}