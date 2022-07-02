package com.faris.spring.ecommerce.order.repository;

import com.faris.spring.ecommerce.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SqlOrderRepository extends JpaRepository<Order,Long> {
}
