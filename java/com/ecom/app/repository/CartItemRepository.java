package com.ecom.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.app.entity.CartItem;

import java.util.List;
import java.util.UUID;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUserId(UUID userId);
}