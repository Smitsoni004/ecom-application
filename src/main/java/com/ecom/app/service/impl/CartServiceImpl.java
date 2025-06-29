package com.ecom.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.app.dto.CartItemDto;
import com.ecom.app.entity.CartItem;
import com.ecom.app.entity.Product;
import com.ecom.app.entity.User;
import com.ecom.app.mapper.CartItemMapper;
import com.ecom.app.repository.CartItemRepository;
import com.ecom.app.repository.ProductRepository;
import com.ecom.app.repository.UserRepository;
import com.ecom.app.service.CartService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public CartItemDto addToCart(Long userId, CartItemDto dto) {
        User user = userRepository.findById(userId).orElseThrow();
        Product product = productRepository.findById(dto.getProductId()).orElseThrow();

        CartItem item = new CartItem();
        item.setUser(user);
        item.setProduct(product);
        item.setQuantity(dto.getQuantity());
        return CartItemMapper.toDto(cartItemRepository.save(item));
    }

    @Override
    public List<CartItemDto> getUserCart(Long userId) {
        return cartItemRepository.findByUserId(userId)
                .stream()
                .map(CartItemMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void removeCartItem(Long userId, Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }
}