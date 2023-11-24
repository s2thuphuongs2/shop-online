package com.example.shoponline.service.impl;

import com.example.shoponline.customenum.Category;
import com.example.shoponline.entity.Product;
import com.example.shoponline.entity.ProductEntity;
import com.example.shoponline.repository.ProductRepository;
import com.example.shoponline.service.ProductService;
import com.example.shoponline.util.ProductFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	private final ProductFactory productFactory;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<? extends Product> getProducts(String type) {
		Category category = Category.valueOf(type);
		JpaRepository<? extends Product, Long> repository = productFactory.getRepository(category);
		return repository.findAll();
	}

//	@Override
//	public List<? extends Product> getProductsByName(String name) {
//		// TODO: tim laptop bang ten
//		// Assuming you have a method named findByName in your repository
////		List<? extends Product> products = LaptopRepository.findByName(name);
////		return products;
//		return null;
//	}



	//	@SuppressWarnings("unchecked")
	@Override
	public Boolean insertProduct(Object object, String type) {
		Category category = Category.valueOf(type);
		JpaRepository repository = productFactory.getRepository(category);
		Product product = productFactory.getEntity(object, category);
		repository.save(product);
		return true;
	}

//	public List<Product> getProductsByName(String name) {
//		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//		CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
//		Root<Product> root = criteriaQuery.from(Product.class);
//
//		List<Predicate> predicates = new ArrayList<>();
//		predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
//
//		criteriaQuery.where(predicates.toArray(new Predicate[0]));
//
//		return entityManager.createQuery(criteriaQuery).getResultList();
//	}

	//TODO: search by price, brand, color
	@Override
	public List<? extends Product> getProductsByName(String name) {
		return productRepository.findByName(name);
	}

	@Override
	public List<? extends Product> getProductsByPrice(BigDecimal price) {
		return productRepository.findByPrice(price);
	}

	@Override
	public List<? extends Product> getProductsByBrand(String brand) {
		return productRepository.findByBrand(brand);
	}

	@Override
	public List<? extends Product> getProductsByColor(String color) {
		return productRepository.findByColor(color);
	}

}
