package com.faris.spring.ecommerce.product.controller;

import com.faris.spring.ecommerce.core.http.ApiResponse;
import com.faris.spring.ecommerce.product.dto.CreateProductDto;
import com.faris.spring.ecommerce.product.usecase.CreateProductUseCase;
import io.swagger.v3.oas.annotations.OpenAPI30;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductController {
    private CreateProductUseCase createProductUseCase;

    @PostMapping
    public ResponseEntity<?> Create(@RequestBody CreateProductDto req) {
        createProductUseCase.execute(req);
      
        return ResponseEntity.ok(new ApiResponse<String>(
                HttpStatus.ACCEPTED,
                "create product successfully...",
                ""
        ));
    }
}
