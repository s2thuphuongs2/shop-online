package com.example.shoponline.controller;


import com.example.shoponline.dto.api.ResponseDto;
import com.example.shoponline.entity.Product;
import com.example.shoponline.service.CartService;
import com.example.shoponline.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	//TODO: Tim laptop = ten
//	@GetMapping("/{name}")
//	public ResponseDto<List<? extends Product>> getProductsByName(@PathVariable String name) {
//		return ResponseDto.ok(productService.getProducts(name));
//	}

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

}