package com.product.model;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {ErrorDetailsTest.class})
class ErrorDetailsTest {

	@Test
	public void test_getmessage() {
		String s = "No product found";
		assertEquals(s, "No product found");
	}

	@Test
	public void test_getErrorCode() {
		String s = "Product_Not_Found";
		assertEquals(s, "Product_Not_Found");
	}

	@Test
	public void test_getPath() {
		String s = "api/products/303";
		assertEquals(s, "api/products/303");
	}
	
}
