package com.faris.spring.ecommerce.product.mapper;

import com.faris.spring.ecommerce.product.dto.CreateProductDto;
import com.faris.spring.ecommerce.product.model.Product;

public class CreateProductMapper {
    public static Product toModel(CreateProductDto req){
        Product product = new Product();
        product.setName(req.getName());
        product.setPrice(req.getPrice());
        product.setQuantity(req.getQuantity());
        product.setDescription(req.getDescription());
        return product;
    }
}
