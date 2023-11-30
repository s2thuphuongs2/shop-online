package com.example.shoponline.controller;


import com.example.shoponline.customenum.PriceRange;
import com.example.shoponline.dto.api.ResponseDto;
import com.example.shoponline.entity.Product;
import com.example.shoponline.entity.ProductEntity;
import com.example.shoponline.service.CartService;
import com.example.shoponline.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

//@RestController
@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;
	private final CartService cartService;

	// DONE: search products by category
	@GetMapping("/{type}")
	public ResponseDto<List<? extends Product>> getProducts(@PathVariable String type) {
		return ResponseDto.ok(productService.getProducts(type));
	}
	@PostMapping("/{type}")
	public ResponseDto<Boolean> insertProduct(@PathVariable String type, @RequestBody Object object) {
		return ResponseDto.ok(productService.insertProduct(object, type));
	}

	// DONE: search products by name
	@GetMapping("/search")
	public ResponseDto<List<? extends Product>> searchProductsByName(@RequestParam String name) {
		List<? extends Product> products = productService.getProductsByName(name);
		return ResponseDto.ok(products);
	}
	//DONE: tim san pham bang price, brand, color
//	@GetMapping("/search-by-price")
//	public ResponseDto<List<? extends Product>> searchProductsByPrice(@RequestParam BigDecimal price) {
//		List<? extends Product> products = productService.getProductsByPrice(price);
//		return ResponseDto.ok(products);
//	}
	@GetMapping("/search-by-price-range")
	public ResponseDto<List<? extends Product>> searchProductsByPriceRange(@RequestParam BigDecimal price) {
		List<? extends Product> products = productService.getProductsByPriceRange(price);
		return ResponseDto.ok(products);
	}

	@GetMapping("/search-by-brand")
	public ResponseDto<List<? extends Product>> searchProductsByBrand(@RequestParam String brand) {
		List<? extends Product> products = productService.getProductsByBrand(brand);
		return ResponseDto.ok(products);
	}

	@GetMapping("/search-by-color")
	public ResponseDto<List<? extends Product>> searchProductsByColor(@RequestParam String color) {
		List<? extends Product> products = productService.getProductsByColor(color);
		return ResponseDto.ok(products);
	}


	//DONE: add product to shoping cart
	@GetMapping("/get-cart")

	public ResponseDto<?> viewProductInCart() {
		return ResponseDto.ok(cartService.viewProductInCart());
	}


	@PostMapping("/add-to-cart/{id}")

	public ResponseDto<?> addProductToCart(@PathVariable String id) {
		return ResponseDto.ok(cartService.addProductToCart(id));
	}

	@PostMapping("/remove-from-cart/{id}")
	public ResponseDto<?> removeProductFromCart(@PathVariable String id) {
		return ResponseDto.ok(cartService.removeProductFromCart(id));
	}

	//DONE: check out the order

}
