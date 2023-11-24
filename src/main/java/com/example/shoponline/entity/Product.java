package com.example.shoponline.entity;

import com.example.shoponline.customenum.PriceRange;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@MappedSuperclass
public abstract class Product extends SuperEntity {
    private String name;
    private String shortDescription;
    @Column(columnDefinition = "text")
    private String fullDescription;
    private String brand;
    private String color;
    private Double size;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private PriceRange priceRange;

    // Phương thức tự động thiết lập PriceRange
    @PrePersist
    public void setPriceRange() {
        if (getPrice() != null) {
            // Tùy thuộc vào yêu cầu, bạn có thể thiết lập giá trị PriceRange dựa trên giá của sản phẩm
            // Ví dụ: Nếu giá nhỏ hơn 100, thiết lập là LOW; nếu giá lớn hơn 900, thiết lập là HIGH, ngược lại là MEDIUM
            //  TODO: Đổi sang hằng số
            if (getPrice().compareTo(BigDecimal.valueOf(100)) < 0) {
                this.priceRange = PriceRange.LOW;
            } else if (price.compareTo(BigDecimal.valueOf(101)) >= 0 && price.compareTo(BigDecimal.valueOf(500)) <= 0) {
                this.priceRange = PriceRange.MEDIUM;
            } else if (price.compareTo(BigDecimal.valueOf(501)) >= 0 && price.compareTo(BigDecimal.valueOf(900)) <= 0) {
                this.priceRange = PriceRange.HIGH;
            } else {
                this.priceRange = PriceRange.VERY_HIGH;
            }
        }
        else {
            this.priceRange = null;
        }
    }
}