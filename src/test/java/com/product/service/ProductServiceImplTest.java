package com.product.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.product.entity.Product;
import com.product.repository.ProductRepository;

@SpringBootTest(classes = { ProductServiceImplTest.class })
class ProductServiceImplTest {

	@Mock
	ProductRepository productRepository;

	@InjectMocks
	ProductServiceImpl productServiceImpl;

	public List<Product> products;

	@Test
	@DisplayName(value = "Get all products")
	public void test_getAllProducts() {

		List<Product> products = new ArrayList<>();
		products.add(new Product(1L, "Mobile", "Apple", 20L));
		when(productRepository.findAll()).thenReturn(products);
		assertEquals(1, productServiceImpl.getProducts().size());
	}

	@Test
	@DisplayName(value = "Get product by id")
	public void test_getProductById() {

		Optional<Product> product = Optional.ofNullable(new Product(2L,"Laptop","Apple",20L));
		when(productRepository.findById(2L)).thenReturn(product);
		assertEquals("Laptop", productServiceImpl.getProduct(2L).getProductName());
	}
	
	@Test
	@DisplayName(value = "Save product")
	public void test_saveProduct() {
		Product product = new Product(10L,"Laptop","Acer",20L);
		when(productRepository.save(product)).thenReturn(product);
		assertEquals("Acer", productServiceImpl.addProduct(product).getBrandName());
	}

	
}
