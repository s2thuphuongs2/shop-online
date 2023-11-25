package com.example.shoponline.dto.order;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
// DONE - DTO
public class OrderDTO {
    private Long userId;
    //private String userName;
    private Iterable<Long> productIds;
    private ShippingInfo shippingInfo;
    private LocalDateTime orderDate;
    private BigDecimal totalAmount;
    private String paymentMethod;
    private String deliveryNote;
}
