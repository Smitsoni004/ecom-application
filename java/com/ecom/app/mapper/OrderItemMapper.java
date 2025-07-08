package com.ecom.app.mapper;

import com.ecom.app.dto.OrderItemDto;
import com.ecom.app.entity.OrderItem;

public class OrderItemMapper {
    public static OrderItemDto toDto(OrderItem entity) {
        return new OrderItemDto(
            entity.getProduct().getId(),
            entity.getQuantity(),
            entity.getPrice()
        );
    }
}