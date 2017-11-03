package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.ProgramCategory;

@Repository("programCategoryJpaRepository")
public interface ProgramCategoryJpaRepository extends JpaRepository<ProgramCategory, Integer> {

}
