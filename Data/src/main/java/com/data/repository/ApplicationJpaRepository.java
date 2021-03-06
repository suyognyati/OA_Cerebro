package com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.data.entities.College;
import com.data.entities.Application;
import com.data.entities.Student;
import com.data.poco.AppliedStudentPOCO;

@Repository("applicationsJpaRepository")
public interface ApplicationJpaRepository extends JpaRepository<Application, Integer> {
	List<Application> findByStudentAndCollegeProgramMapCollege(Student student, College college);
	
	@Query(name="Applications.getAllMeritStudents")
	List<AppliedStudentPOCO> getMeritStudents(@Param("collegeProgramMapId") Integer collegeProgramMapId);
	
}