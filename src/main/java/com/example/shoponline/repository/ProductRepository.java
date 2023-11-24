package com.example.shoponline.repository;

import com.example.shoponline.entity.Product;
import com.example.shoponline.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<? extends Product> findByName(String name);
    List<? extends Product> findByPrice(BigDecimal price);
    List<? extends Product> findByBrand(String brand);
    List<? extends Product> findByColor(String color);
}
