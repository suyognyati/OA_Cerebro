package com.data.repository;

import java.util.List;

import com.data.entities.Product;

public interface ProductRepository {

	Product save(Product product);

	List<Product> loadAll();
	
}
