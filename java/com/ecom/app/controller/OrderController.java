package com.ecom.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecom.app.dto.OrderDto;
import com.ecom.app.service.OrderService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/{userId}")
    public OrderDto placeOrder(@PathVariable UUID userId) {
        return orderService.placeOrder(userId);
    }

    @GetMapping("/{userId}")
    public List<OrderDto> getUserOrders(@PathVariable UUID userId) {
        return orderService.getUserOrders(userId);
    }
}
