package com.faris.spring.ecommerce.order.dto;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto implements Serializable {

    private Long id;

    private Long productId;

    private String productName;

    private int quantity;

    private Double totalPrice;

    private Long orderId;
}
