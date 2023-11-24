package com.example.shoponline.controller;


import com.example.shoponline.dto.api.ResponseDto;
import com.example.shoponline.entity.Product;
import com.example.shoponline.entity.ProductEntity;
import com.example.shoponline.service.CartService;
import com.example.shoponline.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;
	private final CartService cartService;

	@GetMapping("/{type}")
	public ResponseDto<List<? extends Product>> getProducts(@PathVariable String type) {
		return ResponseDto.ok(productService.getProducts(type));
	}
	@PostMapping("/{type}")
	public ResponseDto<Boolean> insertProduct(@PathVariable String type, @RequestBody Object object) {
		return ResponseDto.ok(productService.insertProduct(object, type));
	}
	//TODO: Tim san pham bang Price


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
	//DONE: Tim san pham = ten
	@GetMapping("/search")
	public ResponseEntity<List<? extends Product>> searchProductsByName(@RequestParam String name) {
		List<? extends Product> products = productService.getProductsByName(name);
		return ResponseEntity.ok(products);
	}
	//TODO: tim san pham bang price, brand, color
	@GetMapping("/search-by-price")
	public ResponseEntity<List<? extends Product>> searchProductsByPrice(@RequestParam BigDecimal price) {
		List<? extends Product> products = productService.getProductsByPrice(price);
		return ResponseEntity.ok(products);
	}

	@GetMapping("/search-by-brand")
	public ResponseEntity<List<? extends Product>> searchProductsByBrand(@RequestParam String brand) {
		List<? extends Product> products = productService.getProductsByBrand(brand);
		return ResponseEntity.ok(products);
	}

	@GetMapping("/search-by-color")
	public ResponseEntity<List<? extends Product>> searchProductsByColor(@RequestParam String color) {
		List<? extends Product> products = productService.getProductsByColor(color);
		return ResponseEntity.ok(products);
	}

}
