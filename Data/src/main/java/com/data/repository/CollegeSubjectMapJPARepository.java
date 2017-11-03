package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.CollegeSubjectMap;

@Repository("collegeSubjectMapJpaRepository")
public interface CollegeSubjectMapJPARepository extends JpaRepository<CollegeSubjectMap, Integer> {
	
}
