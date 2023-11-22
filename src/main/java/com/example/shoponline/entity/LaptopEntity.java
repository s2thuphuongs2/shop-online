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
@Table(name = "laptop")
public class LaptopEntity extends Product {
	private Integer ram;
	private Integer diskGB;
	private String diskType;
}
