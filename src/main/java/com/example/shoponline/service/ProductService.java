package com.example.shoponline.service;

import com.example.shoponline.customenum.PriceRange;
import com.example.shoponline.entity.Product;
import com.example.shoponline.entity.ProductEntity;

import java.math.BigDecimal;
import java.util.List;

/**
 * The interface Product service.
 */
public interface ProductService {
    List<? extends Product> getProductsById(Iterable<Long> id);

    /**
     * Gets products.
     *
     * @param type the type
     * @return the products
     */
    List<? extends Product> getProducts(String type);

    /**
     * Gets products by name.
     *
     * @param name the name of products
     * @return the products
     */
    // DONE: tim san pham theo ten
    // DONE: tim san pham theo price, brand, color
    List<? extends Product> getProductsByName(String name);

    List<? extends Product> getProductsByPrice(BigDecimal price);

    List<? extends Product> getProductsByBrand(String brand);

    List<? extends Product> getProductsByColor(String color);

    List<? extends Product> getProductsByPriceRange(BigDecimal price);

    /**
     * Insert product boolean.
     *
     * @param object the object
     * @param type   the type
     * @return the boolean
     */
    Boolean insertProduct(Object object, String type);


}
