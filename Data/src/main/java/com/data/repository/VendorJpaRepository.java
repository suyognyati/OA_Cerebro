package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.data.entities.Vendor;

public interface VendorJpaRepository extends JpaRepository<Vendor, Integer> {

	
}
