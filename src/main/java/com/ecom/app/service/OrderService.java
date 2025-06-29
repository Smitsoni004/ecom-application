package com.ecom.app.service;

import java.util.List;

import com.ecom.app.dto.OrderDto;

public interface OrderService {
    OrderDto placeOrder(Long userId);
    List<OrderDto> getUserOrders(Long userId);
}