package com.example.shoponline.service.impl;

import com.example.shoponline.customenum.Category;
import com.example.shoponline.entity.LaptopEntity;
import com.example.shoponline.entity.Product;
import com.example.shoponline.repository.LaptopRepository;
import com.example.shoponline.service.ProductService;
import com.example.shoponline.util.ProductFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	private final ProductFactory productFactory;

	@Override
	public List<? extends Product> getProducts(String type) {
		Category category = Category.valueOf(type);
		JpaRepository<? extends Product, Long> repository = productFactory.getRepository(category);
		return repository.findAll();
	}

	@Override
	public List<? extends Product> getProductByName(String name) {
		// TODO: tim laptop bang ten
		// Assuming you have a method named findByName in your repository
//		List<? extends Product> products = LaptopRepository.findByName(name);
//		return products;
		return null;
	}



//	@SuppressWarnings("unchecked")
	@Override
	public Boolean insertProduct(Object object, String type) {
		Category category = Category.valueOf(type);
		JpaRepository repository = productFactory.getRepository(category);
		Product product = productFactory.getEntity(object, category);
		repository.save(product);
		return true;
	}

}
