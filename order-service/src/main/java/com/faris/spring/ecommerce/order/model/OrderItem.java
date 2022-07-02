package com.faris.spring.ecommerce.order.model;

import com.faris.spring.ecommerce.core.model.BaseModel;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "order_items")
@Table(name = "order_items")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrderItem extends BaseModel {

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false, columnDefinition = "decimal")
    private Double unitPrice;

    @Column(unique = false, columnDefinition = "decimal")
    private Double totalPrice;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id")
    private Order order;

}
