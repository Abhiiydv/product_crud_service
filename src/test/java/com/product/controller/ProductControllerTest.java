package com.product.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.product.entity.Product;
import com.product.service.ProductService;

@SpringBootTest(classes = { ProductControllerTest.class })
class ProductControllerTest {

	@Mock
	ProductService productService;

	@InjectMocks
	ProductController productController;

	List<Product> products;

	Product product;

	@Test
	public void test_getAllProducts() {
		products = new ArrayList<>();
		products.add(new Product(1L, "Laptop", "Dell", 20L));
		products.add(new Product(11L, "Laptop", "HP", 25L));
		when(productService.getProducts()).thenReturn(products);
		ResponseEntity<List<Product>> response = productController.fetchAllProducts();
		assertEquals(HttpStatus.FOUND, response.getStatusCode());
		assertEquals(2, response.getBody().size());
	}

	@Test
	public void test_getAllProductsFail() {
		products = new ArrayList<>();
		when(productService.getProducts()).thenReturn(products);
		ResponseEntity<List<Product>> response = productController.fetchAllProducts();
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

	}

	@Test
	public void test_getProductById() {
		Product p = new Product(15L, "Monitor", "HP", 30L);
		when(productService.getProduct(15L)).thenReturn(p);
		ResponseEntity<Product> response = productController.fetchProductById(15L);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("HP", response.getBody().getBrandName());
	}

	@Test
	public void test_createProduct() {
		Product p = new Product(15L, "Monitor", "HP", 30L);
		when(productService.addProduct(p)).thenReturn(p);
		ResponseEntity<Product> response = productController.saveProduct(p);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals("Monitor", response.getBody().getProductName());
	}

	@Test
	public void test_deleteProduct() {
		Product p = new Product(15L, "Monitor", "HP", 30L);
		when(productService.deleteProduct(15L)).thenReturn("Deleted");
		ResponseEntity<String> response = productController.deleteProduct(15L);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Deleted", response.getBody());
	}

	@Test
	public void test_updateProduct() {
		Product p = new Product(15L, "Monitor", "HP", 30L);
		when(productService.updateProduct(p, 15L)).thenReturn(p);
		ResponseEntity<Product> response = productController.updateProduct(p, 15L);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(p, response.getBody());
	}

}
