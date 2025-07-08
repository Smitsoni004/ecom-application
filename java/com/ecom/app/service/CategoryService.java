package com.ecom.app.service;

import java.util.List;

import com.ecom.app.dto.CategoryDto;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto dto);
    List<CategoryDto> getAllCategories();
    CategoryDto getCategoryById(Long id);
    void deleteCategory(Long id);
}