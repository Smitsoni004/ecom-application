package com.ecom.app.service;

import java.util.List;
import java.util.UUID;

import com.ecom.app.dto.OrderDto;

public interface OrderService {
    OrderDto placeOrder(UUID userId);
    List<OrderDto> getUserOrders(UUID userId);
}