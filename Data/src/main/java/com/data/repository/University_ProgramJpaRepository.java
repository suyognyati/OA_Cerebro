package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.University_Program;

@Repository("university_ProgramJpaRepository")
public interface University_ProgramJpaRepository extends JpaRepository<University_Program, Integer>{

}
