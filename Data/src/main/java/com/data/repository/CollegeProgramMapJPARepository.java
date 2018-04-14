package com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.College;
import com.data.entities.CollegeProgramMap;
import com.data.entities.ProgramCategory;

@Repository("collegeProgramMapJpaRepository")
public interface CollegeProgramMapJPARepository extends JpaRepository<CollegeProgramMap, Integer> {
	
	List<CollegeProgramMap> findByCollegeAndProgramCategory(College college, ProgramCategory programCategory);
	List<CollegeProgramMap> findByCollege(College college);
}
