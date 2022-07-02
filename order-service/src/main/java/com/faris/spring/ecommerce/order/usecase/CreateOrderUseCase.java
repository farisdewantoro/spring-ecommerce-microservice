package com.faris.spring.ecommerce.order.usecase;

import com.faris.spring.ecommerce.core.dto.CreateOrderDto;
import com.faris.spring.ecommerce.core.dto.OrderItemDto;

import java.util.List;

public interface CreateOrderUseCase {
    List<OrderItemDto> execute(CreateOrderDto req);
}
