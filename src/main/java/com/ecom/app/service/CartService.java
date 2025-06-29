package com.ecom.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecom.app.dto.CartItemDto;

@Service
public interface CartService {
    CartItemDto addToCart(Long userId, CartItemDto dto);
    List<CartItemDto> getUserCart(Long userId);
    void removeCartItem(Long userId, Long cartItemId);
}