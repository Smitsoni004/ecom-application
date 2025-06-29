package com.ecom.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.app.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}