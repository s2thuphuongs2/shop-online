package com.example.shoponline.service;

import com.example.shoponline.entity.Product;

import java.util.List;

/**
 * The interface Product service.
 */
public interface ProductService {
	/**
	 * Gets products.
	 *
	 * @param type the type
	 * @return the products
	 */
	List<? extends Product> getProducts(String type);
	List<? extends Product> getProductByName(String name);

	/**
	 * Insert product boolean.
	 *
	 * @param object the object
	 * @param type   the type
	 * @return the boolean
	 */
	Boolean insertProduct(Object object, String type);

}
