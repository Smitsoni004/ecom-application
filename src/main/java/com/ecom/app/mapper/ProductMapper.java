package com.ecom.app.mapper;

import com.ecom.app.dto.ProductDto;
import com.ecom.app.entity.Product;

public class ProductMapper {
    public static Product toEntity(ProductDto dto) {
        return new Product(
            dto.getId(),
            dto.getName(),
            dto.getDescription(),
            dto.getPrice(),
            dto.getQuantity(),
            dto.getImageUrl()
        );
    }

    public static ProductDto toDto(Product entity) {
        return new ProductDto(
            entity.getId(),
            entity.getName(),
            entity.getDescription(),
            entity.getPrice(),
            entity.getQuantity(),
            entity.getImageUrl()
        );
    }
}