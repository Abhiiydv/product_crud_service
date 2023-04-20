package com.product.service;

import java.util.List;

import com.product.entity.Product;

public interface ProductService {

	Product addProduct(Product product);
	
	Product getProduct(long productId);
	
	List<Product> getProducts();
	
	String deleteProduct(long productId);
	
	Product updateProduct(Product product, long productId);
}
