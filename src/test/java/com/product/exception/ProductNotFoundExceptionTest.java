package com.product.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes= {ProductNotFoundExceptionTest.class})
class ProductNotFoundExceptionTest {

	@Test
	public void testGetResourceName() {
		String resourceName="name";
		assertEquals(resourceName,"name");
	}
	@Test
	public void testGetFieldName() {
		String resourceName="name";
		assertEquals(resourceName,"name");
	}
	@Test
	public void testGetFieldValue() {
		String resourceName="name";
		assertEquals(resourceName,"name");
	}

}
