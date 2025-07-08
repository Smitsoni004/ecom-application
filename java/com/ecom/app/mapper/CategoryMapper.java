package com.ecom.app.mapper;

import com.ecom.app.dto.CategoryDto;
import com.ecom.app.entity.Category;

public class CategoryMapper {
    public static CategoryDto toDto(Category entity) {
        return new CategoryDto(entity.getId(), entity.getName());
    }

    public static Category toEntity(CategoryDto dto) {
        Category c = new Category();
        c.setId(dto.getId());
        c.setName(dto.getName());
        return c;
    }
}