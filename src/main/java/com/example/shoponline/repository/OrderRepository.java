package com.example.shoponline.repository;

import com.example.shoponline.entity.OrderEntity;
import com.google.common.collect.Lists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Order;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    OrderEntity save(OrderEntity entity);

}
