package com.example.shoponline.repository;

import com.example.shoponline.entity.LaptopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<LaptopEntity, Long> {
//public interface LaptopRepository extends ProductRepository{
}
