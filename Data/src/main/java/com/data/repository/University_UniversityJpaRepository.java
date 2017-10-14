package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.University_University;

@Repository("university_UniversityJpaRepository")
public interface University_UniversityJpaRepository extends JpaRepository<University_University, Integer>{
	University_University findByBoardUniversityId(Integer userId);
}
