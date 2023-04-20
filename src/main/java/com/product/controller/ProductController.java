package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Product;
import com.product.service.ProductService;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	// Save Product
	@PostMapping("/create")
	public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product) {
        
		Product savedProduct = productService.addProduct(product);
		return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Product> fetchProductById(@PathVariable("id") Long id) {
		Product savedProduct = productService.getProduct(id);
		return new ResponseEntity<>(savedProduct, HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<Product>> fetchAllProducts() {
		List<Product> listOfProducts = productService.getProducts();
		if(!listOfProducts.isEmpty()) {
			return new ResponseEntity<>(listOfProducts, HttpStatus.FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
		productService.deleteProduct(id);
		return new ResponseEntity<String>("Product deleted", HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody @Valid Product product, @PathVariable("id") Long id) {
		Product updatedProduct = productService.updateProduct(product, id);
		return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/all")
	public ResponseEntity<String> deleteAllProducts(){
		productService.deleteAll();
		return new ResponseEntity<String>("Deleted",HttpStatus.OK);
	}

}
