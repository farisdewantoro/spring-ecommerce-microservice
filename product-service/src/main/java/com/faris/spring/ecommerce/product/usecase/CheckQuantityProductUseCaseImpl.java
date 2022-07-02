package com.faris.spring.ecommerce.product.usecase;

import com.faris.spring.ecommerce.core.constant.KafkaTopicConstant;
import com.faris.spring.ecommerce.product.dto.OrderItemDto;
import com.faris.spring.ecommerce.product.repository.SQLProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
@Slf4j
public class CheckQuantityProductUseCaseImpl {
    private SQLProductRepository productRepository;

    public void execute() {

    }

    @KafkaListener(topics = KafkaTopicConstant.ORDER_CREATED, groupId = "product-service-3", containerFactory = "kafkaListenerContainerFactory")
    public void onOrderCreated(String message) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            OrderItemDto orderItemDto = objectMapper.readValue(message, OrderItemDto.class);
            log.info("Topic [Order] Received message from {} with {} PLN ", orderItemDto.getProductName(), orderItemDto.getOrderId());

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }

}
