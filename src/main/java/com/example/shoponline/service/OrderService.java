package com.example.shoponline.service;

import com.example.shoponline.dto.order.OrderDTO;
import com.example.shoponline.entity.OrderEntity;
import com.example.shoponline.entity.ProductEntity;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {
    OrderEntity createOrder(OrderDTO orderRequest);
    OrderEntity checkoutOrder(OrderDTO orderDto);
    OrderDTO mapOrderEntityToDto(OrderEntity orderEntity);
//    BigDecimal calculateTotalPrice(List<ProductEntity> products);
}
