package com.faris.spring.ecommerce.order.usecase;

import com.faris.spring.ecommerce.order.dto.CreateOrderDto;
import com.faris.spring.ecommerce.order.dto.OrderItemDto;

import java.util.List;

public interface CreateOrderUseCase {
    List<OrderItemDto> execute(CreateOrderDto req);
}
