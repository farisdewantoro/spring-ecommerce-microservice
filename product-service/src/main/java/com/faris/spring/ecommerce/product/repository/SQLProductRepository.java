package com.faris.spring.ecommerce.product.repository;

import com.faris.spring.ecommerce.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SQLProductRepository extends JpaRepository<Product,Long> {
}
