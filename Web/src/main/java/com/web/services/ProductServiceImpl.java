package com.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.data.entities.Product;
import com.data.repository.ProductRepository;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Transactional
	public List<Product> findAllProducts() {
		return productRepository.loadAll();
	}
}
