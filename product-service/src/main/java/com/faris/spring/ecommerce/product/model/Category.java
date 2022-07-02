package com.faris.spring.ecommerce.product.model;

import com.faris.spring.ecommerce.core.model.BaseModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "categories")
@Table(name = "categories")
@Getter
@Setter
@ToString
public class Category extends BaseModel {
    @Column(nullable = false,length = 128)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

}
