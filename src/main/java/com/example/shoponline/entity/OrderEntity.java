package com.example.shoponline.entity;

import com.example.shoponline.customenum.OrderStatus;
import com.example.shoponline.dto.order.ShippingInfo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

// OrderEntity.java
@Entity
@Setter @Getter
@Table(name = "orders")
public class OrderEntity extends SuperEntity {
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToMany
    @JoinTable(name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<ProductEntity> products;

    @Embedded
    private ShippingInfo shippingInfo;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    // Các trường thông tin khác của đơn hàng:
    private String paymentMethod;
    private String deliveryNote;
    // ...

    // Getters và setters
}

