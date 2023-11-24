package com.example.shoponline.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class ShippingInfo {
    private String recipientName;
    private String address;
    private String phoneNumber;
}
