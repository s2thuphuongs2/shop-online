package com.example.shoponline.repository;

import com.example.shoponline.entity.LaptopEntity;
import com.example.shoponline.entity.MonitorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MonitorRepository extends JpaRepository<MonitorEntity, Long> {
//public interface MonitorRepository extends ProductRepository{
}
