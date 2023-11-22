package com.example.shoponline.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "mobile")
public class MobileEntity extends Product {
	private String name;
	private String shortDescription;
	@Column(columnDefinition = "text")
	private String fullDescription;
	private String brand;
	private String color;
	private Integer ram;
	private Integer diskGB;
	private Double size;
	private BigDecimal price;

}