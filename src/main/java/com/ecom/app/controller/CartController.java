package com.ecom.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecom.app.dto.CartItemDto;
import com.ecom.app.service.CartService;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/{userId}")
    public CartItemDto addToCart(@PathVariable Long userId, @RequestBody CartItemDto dto) {
        return cartService.addToCart(userId, dto);
    }

    @GetMapping("/{userId}")
    public List<CartItemDto> getCart(@PathVariable Long userId) {
        return cartService.getUserCart(userId);
    }

    @DeleteMapping("/{userId}/{itemId}")
    public void removeCartItem(@PathVariable Long userId, @PathVariable Long itemId) {
        cartService.removeCartItem(userId, itemId);
    }
}