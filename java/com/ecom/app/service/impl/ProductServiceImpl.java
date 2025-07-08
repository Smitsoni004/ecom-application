package com.ecom.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.app.dto.ProductDto;
import com.ecom.app.entity.Product;
import com.ecom.app.mapper.ProductMapper;
import com.ecom.app.repository.ProductRepository;
import com.ecom.app.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDto createProduct(ProductDto dto) {
        Product product = ProductMapper.toEntity(dto);
        return ProductMapper.toDto(productRepository.save(product));
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(Long id) {
        return productRepository.findById(id)
                .map(ProductMapper::toDto)
                .orElse(null);
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto dto) {
        return productRepository.findById(id)
                .map(existing -> {
                    existing.setName(dto.getName());
                    existing.setDescription(dto.getDescription());
                    existing.setPrice(dto.getPrice());
                    existing.setQuantity(dto.getQuantity());
                    existing.setImageUrl(dto.getImageUrl());
                    return ProductMapper.toDto(productRepository.save(existing));
                }).orElse(null);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}