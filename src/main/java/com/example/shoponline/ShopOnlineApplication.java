package com.example.shoponline;

import com.example.shoponline.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.example.shoponline.repository")
//public class ShopOnlineApplication implements CommandLineRunner {
public class ShopOnlineApplication {


	@Autowired
	private ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(ShopOnlineApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		// Insert product
//		productService.insertProduct("MOBILE", "Mobile Product 1");
//		productService.insertProduct("LAPTOP", "Laptop Product 1");
//	}

}
