package com.data.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.data.entities.Product;

@Repository("productRepository")
public class ProductRepositoryImpl implements ProductRepository {

	@PersistenceContext
	private EntityManager em;
	
	public Product save(Product product) {
		
		em.persist(product);
		
		em.flush();
		
		return product;
	}

	public List<Product> loadAll() {
		//Query query = em.createQuery("Select g from Goal g");

		TypedQuery<Product> query = em.createNamedQuery(Product.FIND_ALL_PRODUCTS, Product.class);
		
		return query.getResultList();
	}
}
