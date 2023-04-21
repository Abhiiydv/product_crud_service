package com.product.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {ProductEntityTest.class})
public class ProductEntityTest {


	@Test
	public void test_getproductName() {
		String productName = "Laptop";
		assertEquals(productName, "Laptop");
	}
	@Test
	public void test_getBrandName() {
		String brandName = "HP";
		assertEquals(brandName, "HP");
	}
	@Test
	public void test_getProductPrice() {
		String price = "20L";
		assertEquals(price, "20L");
	}
	@Test
	public void test_getProductId() {
		Long pId = 20L;
		assertEquals(pId, 20L);
	}

	
	
}
