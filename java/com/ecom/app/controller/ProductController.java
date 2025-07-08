package com.ecom.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecom.app.dto.ProductDto;
import com.ecom.app.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductDto create(@RequestBody ProductDto dto) {
        return productService.createProduct(dto);
    }

    @GetMapping
    public List<ProductDto> list() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDto get(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public ProductDto update(@PathVariable Long id, @RequestBody ProductDto dto) {
        return productService.updateProduct(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}