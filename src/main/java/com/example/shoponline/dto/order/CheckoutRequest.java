package com.example.shoponline.dto.order;

import com.example.shoponline.dto.ProductDTO;
import com.example.shoponline.entity.ProductEntity;
import com.example.shoponline.entity.ShippingInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CheckoutRequest {
    private List<ProductEntity> products;
//    private List<ProductDTO> items;
    private ShippingInfo shippingInfo;
}
