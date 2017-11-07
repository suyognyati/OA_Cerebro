package com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.College;
import com.data.entities.CollegeSubjectMap;
import com.data.entities.University_Program;

@Repository("collegeSubjectMapJpaRepository")
public interface CollegeSubjectMapJPARepository extends JpaRepository<CollegeSubjectMap, Integer> {

	List<CollegeSubjectMap> findByCollegeAndProgram(College college, University_Program program);
}
