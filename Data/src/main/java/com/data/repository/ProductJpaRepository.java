package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.Product;

@Repository("productJpaRepository")
public interface ProductJpaRepository extends JpaRepository<Product, Integer> {

}
