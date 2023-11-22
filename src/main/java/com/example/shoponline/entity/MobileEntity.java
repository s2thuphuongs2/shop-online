package com.example.shoponline.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "mobile")
public class MobileEntity extends Product {
	private Integer ram;
	private Integer diskGB;
}