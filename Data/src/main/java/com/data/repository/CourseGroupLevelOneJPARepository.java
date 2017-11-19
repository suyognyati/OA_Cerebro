package com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.CourseGroupLevelOne;
import com.data.entities.University_Program;

@Repository("courseGroupLevelOneJPARepository")
public interface CourseGroupLevelOneJPARepository extends JpaRepository<CourseGroupLevelOne, Integer> {

	List<CourseGroupLevelOne> findByUniversityProgram(University_Program program);
}
