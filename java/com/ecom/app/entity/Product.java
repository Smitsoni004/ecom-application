package com.ecom.app.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double price;
    private int quantity;
    private String imageUrl;
    
    @ManyToOne
    @JoinColumn(name = "category_id") // this creates a foreign key column
    private Category category;
}
