package com.faris.spring.ecommerce.core.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data

public class CreateOrderItemDto {
    private Long productId;

    private String productName;

    private int quantity;

    private Double unitPrice;
}
