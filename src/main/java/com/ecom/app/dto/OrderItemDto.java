package com.ecom.app.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {
    private Long productId;
    private int quantity;
    private double price;
}