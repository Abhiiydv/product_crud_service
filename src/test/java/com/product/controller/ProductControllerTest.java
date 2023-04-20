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
    	products.add(new Product(1L,"Laptop","Dell",20L));
    	products.add(new Product(11L,"Laptop","HP",25L));
    	when(productService.getProducts()).thenReturn(products);
        ResponseEntity<List<Product>> response = productController.fetchAllProducts();
        assertEquals(HttpStatus.FOUND, response.getStatusCode());
        assertEquals(2,response.getBody().size());
    }
    
}
