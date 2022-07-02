package com.faris.spring.ecommerce.product.usecase;

import com.faris.spring.ecommerce.product.dto.CreateProductDto;

public interface CreateProductUseCase {
    void execute(CreateProductDto req);
}
