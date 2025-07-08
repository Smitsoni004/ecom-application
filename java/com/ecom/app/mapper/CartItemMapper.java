package com.ecom.app.mapper;

import com.ecom.app.dto.CartItemDto;
import com.ecom.app.entity.CartItem;

public class CartItemMapper {
    public static CartItemDto toDto(CartItem entity) {
        return new CartItemDto(
            entity.getId(),
            entity.getProduct().getId(),
            entity.getQuantity()
        );
    }
}