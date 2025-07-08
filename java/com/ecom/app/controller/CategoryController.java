package com.ecom.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecom.app.dto.CategoryDto;
import com.ecom.app.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public CategoryDto create(@RequestBody CategoryDto dto) {
        return categoryService.createCategory(dto);
    }

    @GetMapping
    public List<CategoryDto> list() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public CategoryDto get(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}