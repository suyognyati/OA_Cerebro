package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.College;
import com.data.entities.CollegeVendorMap;
import com.data.entities.UserDetail;

@Repository("collegeVendorMapJpaRepository")
public interface CollegeVendorMapJpaRepository extends JpaRepository<CollegeVendorMap, Integer> {

	CollegeVendorMap findByCollegeAndEnabled(College college, Boolean enabled);
	CollegeVendorMap findByVendorAndEnabled(UserDetail vendor, Boolean enabled);
}