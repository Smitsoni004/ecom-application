package com.ecom.app.dto;

import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private UUID userId;
    private LocalDateTime orderDate;
    private double totalAmount;
    private String status;
    private List<OrderItemDto> items;
}