package com.ecom.app.mapper;

import com.ecom.app.dto.ProductDto;
import com.ecom.app.entity.Category;
import com.ecom.app.entity.Product;

public class ProductMapper {
    
    public static Product toEntity(ProductDto dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        product.setImageUrl(dto.getImageUrl());

        // Set category only if ID is present
        if (dto.getCategoryId() != null) {
            Category category = new Category();
            category.setId(dto.getCategoryId());
            product.setCategory(category);
        }

        return product;
    }

    public static ProductDto toDto(Product entity) {
        return new ProductDto(
            entity.getId(),
            entity.getName(),
            entity.getDescription(),
            entity.getPrice(),
            entity.getQuantity(),
            entity.getImageUrl(),
            entity.getCategory() != null ? entity.getCategory().getId() : null
        );
    }
}
