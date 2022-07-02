package com.faris.spring.ecommerce.product.model;

import com.faris.spring.ecommerce.core.model.BaseModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "products")
@Table(name = "products")
@Getter
@Setter
@ToString
public class Product extends BaseModel {
    @Column(nullable = false,columnDefinition = "TEXT")
    private String name;

    private double price;

    private int quantity;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;

}
