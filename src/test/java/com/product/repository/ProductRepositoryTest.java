package com.product.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.product.entity.Product;

@SpringBootTest(classes= {ProductRepositoryTest.class})
class ProductRepositoryTest {

	@Mock
	private ProductRepository productRepository;

	@Test
	public void testFindById() {
		Product p = new Product();
		p.setProductId(1L);
		p.setProductName("Laptop");
		p.setBrandName("HP");
		p.setProductPrice(20L);

		when(productRepository.findById(1L)).thenReturn(Optional.of(p));

	
		Optional<Product> result = productRepository.findById(1L);
		assertTrue(result.isPresent());
		assertEquals(p, result.get());
	}
	
	@Test
	public void testFindAll() {
		List<Product> products = new ArrayList<>();
		products.add(new Product(2L,"Mobile","Apple",30L));

		when(productRepository.findAll()).thenReturn(products);

		
		List<Product> result = productRepository.findAll();
		assertFalse(result.isEmpty());
		assertEquals(1, result.size());
	}
	@Test
	public void testDeleteById() {
		Long id = 1L;
		productRepository.deleteById(id);
        Mockito.verify(productRepository).deleteById(id);
	}
	@Test
	public void testDeleteAll() {
	
		productRepository.deleteAll();
        Mockito.verify(productRepository).deleteAll();
	}

	
}
