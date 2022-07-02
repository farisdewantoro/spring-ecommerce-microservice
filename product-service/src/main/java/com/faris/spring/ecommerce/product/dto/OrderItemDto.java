package com.faris.spring.ecommerce.product.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@Builder
@ToString
public class OrderItemDto implements Serializable {

    private Long id;

    private Long productId;

    private String productName;

    private int quantity;

    private Double totalPrice;

    private Long orderId;
}
