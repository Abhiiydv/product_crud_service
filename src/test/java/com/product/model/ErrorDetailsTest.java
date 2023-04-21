package com.product.model;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {ErrorDetailsTest.class})
class ErrorDetailsTest {

	
	@Test
    public void testGettersAndSetters() {
        // Set up test data
        String e = "Not Found";
        String m = "Not Found";
        String p = "Not Found";
        LocalDateTime dateTime = LocalDateTime.parse("2023-04-21T15:30:45");
        
        // Create a new ErrorResponse object
        ErrorDetails errorResponse = new ErrorDetails();

        // Set the values using setters
        errorResponse.setErrorCode(e);
        errorResponse.setMessage(m);
        errorResponse.setPath(p);
        errorResponse.setTimestamp(dateTime);

        // Verify that the values were set correctly using getters
        assertEquals(e, errorResponse.getErrorCode());
        assertEquals(m, errorResponse.getMessage());
        assertEquals(p, errorResponse.getPath());
        assertEquals(dateTime, errorResponse.getTimestamp());
    }
}
