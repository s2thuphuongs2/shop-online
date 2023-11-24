package com.example.shoponline.util;

import com.example.shoponline.customenum.Category;
import com.example.shoponline.customenum.PriceRange;
import com.example.shoponline.entity.*;
import com.example.shoponline.repository.LaptopRepository;
import com.example.shoponline.repository.MobileRepository;
import com.example.shoponline.repository.MonitorRepository;
import com.example.shoponline.repository.ProductRepository;
import com.example.shoponline.service.CRUDService;
import com.example.shoponline.service.LaptopService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class ProductFactory {
	private final LaptopRepository laptopRepository;
	private final MobileRepository mobileRepository;
	private final MonitorRepository monitorRepository;
	private final ProductRepository productRepository;
	private final LaptopService laptopService;
	private final ObjectMapper objectMapper;

	public JpaRepository<? extends Product, Long> getRepository(Category category) {
		switch (category) {
			case LAPTOP: {
				return laptopRepository;
			}
			case MOBILE: {
				return mobileRepository;
			}
			case MONITOR: {
				return monitorRepository;
			}
			case RAM: {

			}
			default: {
				// todo: add Repository
				return productRepository;
//				return null;
			}
		}
	}

	public Class<? extends Product> getClass(Category category) {
		switch (category) {
			case LAPTOP: {
				return LaptopEntity.class;
			}
			case MOBILE: {
				return MobileEntity.class;
			}
			case MONITOR: {
				return MonitorEntity.class;
			}
			default: {
				return ProductEntity.class;
//				return null;
			}
		}
	}

	public Product getEntity(Object object, Category category) {
		switch (category) {
			case LAPTOP: {
				return objectMapper.convertValue(object, LaptopEntity.class);
			}
			case MOBILE: {
				return objectMapper.convertValue(object, MobileEntity.class);
			}
			case MONITOR: {
				return objectMapper.convertValue(object, MonitorEntity.class);
			}
			default: {
//				return null;
				return objectMapper.convertValue(object, ProductEntity.class);
			}
		}
	}

	public CRUDService<? extends Product> getService(Category category) {
		switch (category) {
			case LAPTOP: {
				return laptopService;
			}
			default: {
				return null;
			}
		}
	}

	//TODO: thêm getPriceRange
	public PriceRange getPriceRange(BigDecimal price) {
		if (price.compareTo(BigDecimal.valueOf(1)) >= 0 && price.compareTo(BigDecimal.valueOf(100)) <= 0) {
			return PriceRange.LOW;
		} else if (price.compareTo(BigDecimal.valueOf(101)) >= 0 && price.compareTo(BigDecimal.valueOf(500)) <= 0) {
			return PriceRange.MEDIUM;
		} else if (price.compareTo(BigDecimal.valueOf(501)) >= 0 && price.compareTo(BigDecimal.valueOf(900)) <= 0) {
			return PriceRange.HIGH;
		} else {
			return PriceRange.VERY_HIGH;
		}
	}

}
