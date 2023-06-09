package com.product.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.product.entity.Product;
import com.product.exception.ProductNotFoundException;
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

		Optional<Product> product = Optional.ofNullable(new Product(2L, "Laptop", "Apple", 20L));
		when(productRepository.findById(2L)).thenReturn(product);
		assertEquals("Laptop", productServiceImpl.getProduct(2L).getProductName());
	}

	@Test
	@DisplayName(value = "Get product by fail id")
	public void test_getProductByIdFail() throws ProductNotFoundException {

		Optional<Product> product = Optional.ofNullable(new Product(2L, "Laptop", "Apple", 20L));
		when(productRepository.findById(2L)).thenReturn(product);
		Assertions.assertThrows(ProductNotFoundException.class, () -> productServiceImpl.getProduct(15L));

	}

	@Test
	@DisplayName(value = "Save product")
	public void test_saveProduct() {
		Product product = new Product(10L, "Laptop", "Acer", 20L);
		when(productRepository.save(product)).thenReturn(product);
		assertEquals("Acer", productServiceImpl.addProduct(product).getBrandName());
	}

	@Test
	@DisplayName(value = "Update product by id")
	public void test_updateProduct() {
		Optional<Product> product = Optional.ofNullable(new Product(10L, "Laptop", "Acer", 20L));
		when(productRepository.save(product.get())).thenReturn(product.get());
		when(productRepository.findById(10L)).thenReturn(product);
		assertEquals(10L, productServiceImpl.updateProduct(product.get(), 10L).getProductId());
	}

	@Test
	@DisplayName(value = "Update product by id failure")
	public void test_updateProductFail() throws ProductNotFoundException {
		Optional<Product> product = Optional.ofNullable(new Product(10L, "Laptop", "Acer", 20L));
		when(productRepository.save(product.get())).thenReturn(product.get());
		when(productRepository.findById(10L)).thenReturn(product);
		Assertions.assertThrows(ProductNotFoundException.class,
				() -> productServiceImpl.updateProduct(product.get(), 25L));
	}

	@Test
	@DisplayName(value = "Delete product by id")
	public void test_DeleteProductById() {
		Product product = new Product(10L, "Laptop", "Acer", 20L);
		when(productRepository.findById(10L)).thenReturn(Optional.of(product));
		when(productRepository.existsById(product.getProductId())).thenReturn(false);
		assertEquals("Deleted", productServiceImpl.deleteProduct(10L));
	}

	@Test
	@DisplayName(value = "Delete product by id failure")
	public void test_DeleteProductByIdFail() throws ProductNotFoundException {
		Assertions.assertThrows(ProductNotFoundException.class, () ->

		{
			when(productRepository.findById(10L)).thenThrow(new ProductNotFoundException("Product", "id", 10L));
			productServiceImpl.deleteProduct(10L);
		});
	}

}
