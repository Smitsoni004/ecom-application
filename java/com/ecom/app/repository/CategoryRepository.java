package com.ecom.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.app.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}