package com.faris.spring.ecommerce.order.controller;

import com.faris.spring.ecommerce.core.http.ApiResponse;
import com.faris.spring.ecommerce.core.dto.CreateOrderDto;
import com.faris.spring.ecommerce.core.dto.OrderItemDto;
import com.faris.spring.ecommerce.order.usecase.CreateOrderUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@AllArgsConstructor
public class OrderController {

    private CreateOrderUseCase createOrderUseCase;

    @PostMapping
    public ResponseEntity<?> Create(@RequestBody CreateOrderDto req) {

        final var result = createOrderUseCase.execute(req);


        if (result.isEmpty()) {
            return ResponseEntity.unprocessableEntity().body(new ApiResponse<String>(
                    HttpStatus.UNPROCESSABLE_ENTITY,
                    "failed to create order",
                    "null"
            ));
        }
        return ResponseEntity.ok(new ApiResponse<List<OrderItemDto>>(
                HttpStatus.ACCEPTED,
                "order successfully created",
                result
        ));
    }
}
