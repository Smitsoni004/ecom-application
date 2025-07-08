package com.ecom.app.mapper;

import java.util.stream.Collectors;

import com.ecom.app.dto.OrderDto;
import com.ecom.app.entity.Order;

public class OrderMapper {
    public static OrderDto toDto(Order entity) {
        return new OrderDto(
            entity.getId(),
            entity.getUser().getId(),
            entity.getOrderDate(),
            entity.getTotalAmount(),
            entity.getStatus(),
            entity.getOrderItems().stream()
                .map(OrderItemMapper::toDto)
                .collect(Collectors.toList())
        );
    }
}