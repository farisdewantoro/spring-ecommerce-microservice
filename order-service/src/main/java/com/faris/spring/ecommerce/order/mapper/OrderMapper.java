package com.faris.spring.ecommerce.order.mapper;

import com.faris.spring.ecommerce.order.dto.CreateOrderDto;
import com.faris.spring.ecommerce.order.dto.CreateOrderItemDto;
import com.faris.spring.ecommerce.order.dto.OrderItemDto;
import com.faris.spring.ecommerce.order.model.Order;
import com.faris.spring.ecommerce.order.model.OrderItem;

import java.time.LocalDateTime;

public interface OrderMapper {
    public static OrderItem map(final CreateOrderItemDto req, final Order order) {
        return OrderItem.builder()
                .productId(req.getProductId())
                .productName(req.getProductName())
                .quantity(req.getQuantity())
                .totalPrice(req.getUnitPrice() * req.getQuantity())
                .unitPrice(req.getUnitPrice())
                .order(order)
                .build();
    }

    public static Double totalAmount(final CreateOrderDto req) {
        return req.getOrderItems()
                .stream()
                .map(x -> x.getUnitPrice() * x.getQuantity())
                .reduce(0.0, Double::sum);
    }

    public static Order map(final CreateOrderDto req) {
        return Order.builder()
                .customerId(req.getCustomerId())
                .status(Order.OrderStatus.IN_PROGRESS)
                .orderDate(LocalDateTime.now())
                .totalAmount(OrderMapper.totalAmount(req))
                .build();
    }

    public static OrderItemDto map(final OrderItem req) {
        return OrderItemDto.builder()
                .id(req.getId())
                .orderId(req.getOrder().getId())
                .productName(req.getProductName())
                .productId(req.getProductId())
                .quantity(req.getQuantity())
                .totalPrice(req.getTotalPrice())
                .build();
    }

}
