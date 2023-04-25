package com.product.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourceName;
    private String fieldName;
    private Long filedValue;

    public ProductNotFoundException(String resourceName,String fieldName,Long filedValue){
        super(String.format("%s not found with %s : '%s'",resourceName,fieldName,filedValue));
        this.resourceName = resourceName;
        this.fieldName=fieldName;
        this.filedValue=filedValue;
    }
}
