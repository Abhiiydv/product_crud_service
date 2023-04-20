package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.exception.ProductNotFoundException;
import com.product.repository.ProductRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		log.info("Saving product..");
		Product savedProduct = productRepository.save(product);
		return savedProduct;
	}

	@Override
	public Product getProduct(long productId) {
		// TODO Auto-generated method stub
		log.info("Fetching product with Id.."+productId);
		Product existingProduct = productRepository.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException("Product", "id", productId));
		return existingProduct;
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		log.info("Fetching product list..");
		List<Product> listOfProducts = productRepository.findAll();
		return listOfProducts;
	}

	@Override
	public void deleteProduct(long productId) {
		// TODO Auto-generated method stub
		log.info("Deleting product with id.."+productId);
		Product existingProduct = productRepository.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException("Product", "id", productId));
		if (existingProduct != null) {
			productRepository.deleteById(productId);
		}

	}

	@Override
	public Product updateProduct(Product product, long productId) {
		// TODO Auto-generated method stub
		log.info("Updating product with id.."+productId);
		Product existingProduct = productRepository.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException("Product", "id", productId));

		existingProduct.setProductName(product.getProductName());
		existingProduct.setBrandName(product.getBrandName());
		existingProduct.setProductPrice(product.getProductPrice());

		Product updatedProduct = productRepository.save(existingProduct);

		return updatedProduct;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		productRepository.deleteAll();
	}
}
