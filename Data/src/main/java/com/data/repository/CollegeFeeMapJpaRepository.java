package com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.College;
import com.data.entities.CollegeFeeMap;

@Repository("collegeFeeMapJpaRepository")
public interface CollegeFeeMapJpaRepository extends JpaRepository<CollegeFeeMap, Integer> {

	List<CollegeFeeMap> findByCollegeAndYear(College college, Integer year);
}
