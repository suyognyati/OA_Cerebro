package com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.Student;

@Repository("studentJpaRepository")
public interface StudentJpaRepository extends JpaRepository<Student, Integer> {
	List<Student> findByFirstName(String firstName);
}
