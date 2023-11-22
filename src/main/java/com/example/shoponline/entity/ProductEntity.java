package com.example.shoponline.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "product")  // Tên bảng trong cơ sở dữ liệu
public class ProductEntity extends Product {

}
