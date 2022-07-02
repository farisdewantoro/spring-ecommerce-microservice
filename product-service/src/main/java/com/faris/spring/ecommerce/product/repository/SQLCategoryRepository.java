package com.faris.spring.ecommerce.product.repository;

import com.faris.spring.ecommerce.product.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SQLCategoryRepository extends JpaRepository<Category,Long> {
}
