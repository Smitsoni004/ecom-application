package com.ecom.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.app.dto.OrderDto;
import com.ecom.app.entity.CartItem;
import com.ecom.app.entity.Order;
import com.ecom.app.entity.OrderItem;
import com.ecom.app.entity.Product;
import com.ecom.app.entity.User;
import com.ecom.app.mapper.OrderMapper;
import com.ecom.app.repository.CartItemRepository;
import com.ecom.app.repository.OrderRepository;
import com.ecom.app.repository.ProductRepository;
import com.ecom.app.repository.UserRepository;
import com.ecom.app.service.OrderService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public OrderDto placeOrder(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        List<CartItem> cartItems = cartItemRepository.findByUserId(userId);

        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PLACED");

        List<OrderItem> orderItems = new ArrayList<>();
        double total = 0;
        for (CartItem cartItem : cartItems) {
            Product product = cartItem.getProduct();
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPrice(product.getPrice());
            orderItem.setOrder(order);
            orderItems.add(orderItem);
            total += product.getPrice() * cartItem.getQuantity();
        }
        order.setTotalAmount(total);
        order.setOrderItems(orderItems);

        cartItemRepository.deleteAll(cartItems);
        return OrderMapper.toDto(orderRepository.save(order));
    }

    @Override
    public List<OrderDto> getUserOrders(Long userId) {
        return orderRepository.findByUserId(userId)
                .stream()
                .map(OrderMapper::toDto)
                .collect(Collectors.toList());
    }
}