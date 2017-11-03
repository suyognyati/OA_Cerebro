package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.College;

@Repository("collegeJpaRepository")
public interface CollegeJpaRepository extends JpaRepository<College, Integer> {

}
