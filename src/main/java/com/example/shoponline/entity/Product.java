package com.example.shoponline.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;

@Getter
@Setter
@MappedSuperclass
public abstract class Product extends SuperEntity {
    private String name;
    private String shortDescription;
    @Column(columnDefinition = "text")
    private String fullDescription;
    private String brand;
    private String color;
    private Double size;
    private BigDecimal price;
}