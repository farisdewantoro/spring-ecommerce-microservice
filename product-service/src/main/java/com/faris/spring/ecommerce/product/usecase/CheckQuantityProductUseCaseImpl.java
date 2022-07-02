package com.faris.spring.ecommerce.product.usecase;

import com.faris.spring.ecommerce.core.constant.KafkaTopicConstant;
import com.faris.spring.ecommerce.core.dto.OrderItemDto;
import com.faris.spring.ecommerce.product.repository.SQLProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
@Slf4j
public class CheckQuantityProductUseCaseImpl {
    private SQLProductRepository productRepository;

    public void execute() {

    }

    @KafkaListener(topics = KafkaTopicConstant.ORDER_CREATED, groupId = "product-service2", containerFactory = "kafkaListenerContainerFactory")
    public void onOrderCreated(OrderItemDto orderItemDto) {
        log.info("Topic [Order] Received message from {} with {} PLN ", orderItemDto.getProductName(), orderItemDto.getOrderId());
    }

}
