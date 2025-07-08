package com.ecom.app.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ecom.app.dto.CartItemDto;

@Service
public interface CartService {
    CartItemDto addToCart(UUID userId, CartItemDto dto);
    List<CartItemDto> getUserCart(UUID userId);
    void removeCartItem(UUID userId, Long cartItemId);
}