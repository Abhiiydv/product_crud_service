package com.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;
	
	@NotBlank(message = "Product name is mandatory")
	private String productName;
	
	@NotBlank(message = "Brand name is mandatory")
	private String brandName;
	
	@Min(value = 10, message = "Too low")
    @Max(value = 100, message = "Too high")
	private Long productPrice;
	
	
	
}
