package com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.College;
import com.data.entities.CollegeProgramMap;
import com.data.entities.ProgramCategoryWeightage;

@Repository("programCategoryWeightageJpaRepository")
public interface ProgramCategoryWeightageJpaRepository extends JpaRepository<ProgramCategoryWeightage, Integer>{

	/**
	 * This function will give list of weightage for category by college program map
	 * Here category represents to SC, Nt, OBC OPEN etc.
	 * In this list category name (i.e. value) 0 represents for total
	 * @param collegeProgram
	 * @return List<ProgramCategoryWeightage>
	 */
	List<ProgramCategoryWeightage> findByCollegeProgram(CollegeProgramMap collegeProgramMap);
		
	/**
	 * This function will give list of weightage for category
	 * Here category represents to SC, Nt, OBC OPEN etc.
	 * In this list category name (i.e. value) 0 represents for total
	 * @param college
	 * @return List<ProgramCategoryWeightage>
	 */
	List<ProgramCategoryWeightage> findByCollege(College college);
}
