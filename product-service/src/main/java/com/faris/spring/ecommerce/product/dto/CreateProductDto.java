package com.faris.spring.ecommerce.product.dto;

import lombok.Data;

@Data
public class CreateProductDto {
    private String name;
    private double price;
    private int quantity;
    private String description;
    private Long categoryId;
}
