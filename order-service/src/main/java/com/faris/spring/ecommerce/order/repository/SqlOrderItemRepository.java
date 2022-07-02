package com.faris.spring.ecommerce.order.repository;

import com.faris.spring.ecommerce.order.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SqlOrderItemRepository  extends JpaRepository<OrderItem,Long> {
}
