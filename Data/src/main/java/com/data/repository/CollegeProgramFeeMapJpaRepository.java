package com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.College;
import com.data.entities.CollegeProgramFeeMap;
import com.data.entities.University_Program;

@Repository("collegeProgramFeeMapJpaRepository")
public interface CollegeProgramFeeMapJpaRepository extends JpaRepository<CollegeProgramFeeMap, Integer> {

	List<CollegeProgramFeeMap> findByCollegeAndProgramAndYear(College college, University_Program program, Integer year);
}
