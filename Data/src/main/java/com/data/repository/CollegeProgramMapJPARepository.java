package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.CollegeProgramMap;

@Repository("collegeProgramMapJpaRepository")
public interface CollegeProgramMapJPARepository extends JpaRepository<CollegeProgramMap, Integer> {
	
}
