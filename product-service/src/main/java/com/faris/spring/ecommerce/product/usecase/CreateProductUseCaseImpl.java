package com.faris.spring.ecommerce.product.usecase;

import com.faris.spring.ecommerce.product.dto.CreateProductDto;
import com.faris.spring.ecommerce.product.mapper.CreateProductMapper;
import com.faris.spring.ecommerce.product.model.Category;
import com.faris.spring.ecommerce.product.model.Product;
import com.faris.spring.ecommerce.product.repository.SQLCategoryRepository;
import com.faris.spring.ecommerce.product.repository.SQLProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;


@Slf4j
@Service
@AllArgsConstructor
public class CreateProductUseCaseImpl implements CreateProductUseCase {
    private SQLProductRepository productRepository;
    private SQLCategoryRepository categoryRepository;

    @Override
    public void execute(CreateProductDto req){
        log.debug("Handling a createProductUseCase {}", req.toString());

        if (req.getCategoryId() == null){
            log.info("category is empty");
            return;
        }

        Optional<Category> category = categoryRepository.findById(req.getCategoryId());

        if (category.isEmpty()){
            return;
        }

        Product product = CreateProductMapper.toModel(req);
        product.setCategory(category.get());
        productRepository.save(product);

    }
}
