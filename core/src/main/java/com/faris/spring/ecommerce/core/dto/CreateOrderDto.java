package com.faris.spring.ecommerce.core.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class CreateOrderDto {

    private LocalDateTime orderDate;

    private Long customerId;

    private List<CreateOrderItemDto> orderItems;
}
