package com.product.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorDetails {

	
	    private LocalDateTime timestamp;
	    private String message;
	    private String path;
	    private String errorCode;
	
}
