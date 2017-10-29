package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.University_Subject;

@Repository("university_SubjectJpaRepository")
public interface University_SubjectJpaRepository extends JpaRepository<University_Subject, Integer> {
	
}
