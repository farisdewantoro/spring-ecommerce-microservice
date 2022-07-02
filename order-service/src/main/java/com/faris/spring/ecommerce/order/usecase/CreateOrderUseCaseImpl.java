package com.faris.spring.ecommerce.order.usecase;

import com.faris.spring.ecommerce.core.constant.KafkaTopicConstant;
import com.faris.spring.ecommerce.order.dto.CreateOrderDto;
import com.faris.spring.ecommerce.order.dto.CreateOrderItemDto;
import com.faris.spring.ecommerce.order.dto.OrderItemDto;
import com.faris.spring.ecommerce.order.mapper.OrderMapper;
import com.faris.spring.ecommerce.order.model.Order;
import com.faris.spring.ecommerce.order.model.OrderItem;
import com.faris.spring.ecommerce.order.repository.SqlOrderItemRepository;
import com.faris.spring.ecommerce.order.repository.SqlOrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
@Transactional
public class CreateOrderUseCaseImpl implements CreateOrderUseCase {

    private SqlOrderRepository orderRepository;
    private SqlOrderItemRepository orderItemRepository;

    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public List<OrderItemDto> execute(CreateOrderDto req) {
        log.info("Creating order...");
        Order order = this.orderRepository.save(OrderMapper.map(req));

        return req.getOrderItems()
                .stream()
                .map(item -> this.createOrder(item, order))
                .collect(Collectors.toList());
    }

    private OrderItemDto createOrder(CreateOrderItemDto item, Order order) {
        log.info("Creating order item...");
        OrderItem orderItem = this.orderItemRepository.save(OrderMapper.map(item, order));
        log.info("dispatch event order item created");
        OrderItemDto orderItemDto = OrderMapper.map(orderItem);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.kafkaTemplate.send(KafkaTopicConstant.ORDER_CREATED, orderItem.getId().toString(), objectMapper.writeValueAsString(orderItemDto));

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return orderItemDto;
    }
}
