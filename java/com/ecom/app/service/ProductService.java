package com.ecom.app.service;

import java.util.List;

import com.ecom.app.dto.ProductDto;

public interface ProductService {
    ProductDto createProduct(ProductDto dto);
    List<ProductDto> getAllProducts();
    ProductDto getProductById(Long id);
    ProductDto updateProduct(Long id, ProductDto dto);
    void deleteProduct(Long id);
}