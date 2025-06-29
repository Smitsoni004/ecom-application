package com.ecom.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.app.entity.CartItem;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUserId(Long userId);
}