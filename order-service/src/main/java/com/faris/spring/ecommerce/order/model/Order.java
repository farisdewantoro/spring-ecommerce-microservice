package com.faris.spring.ecommerce.order.model;

import com.faris.spring.ecommerce.core.model.BaseModel;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "orders")
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Order extends BaseModel {

    private Long customerId;

    @Column(name = "order_date", columnDefinition = "timestamp")
    private LocalDateTime orderDate;

    @Column(name = "total_amount", columnDefinition = "decimal")
    private Double totalAmount;
    private OrderStatus status;

    @OneToMany(mappedBy = "order")
    private Set<OrderItem> orderItems;

    public enum OrderStatus {
        IN_PROGRESS,
        PENDING_PAYMENT,
        PAYMENT_RECEIVED,
        PAYMENT_FAILED,
        COMPLETED,
        CLOSED,
        CANCELED,
    }
}


