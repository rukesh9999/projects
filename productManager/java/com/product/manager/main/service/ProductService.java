package com.product.manager.main.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.manager.main.model.Product;
import com.product.manager.main.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public void saveProduct(Product product) {
		productRepository.save(product);
	}

	public Product getProduct(long id) {
		return productRepository.findById(id).get();
	}

	public List<Product> getAllproducts() {
		return productRepository.findAll();
	}

	public void deleteProduct(long id) {
		productRepository.deleteById(id);
	}

}
