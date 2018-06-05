package com.data.services;

import java.util.List;

import com.data.entities.College;
import com.data.entities.CollegeProgramMap;
import com.data.entities.ProgramCategoryWeightage;

public interface ProgramCategoryWeightageDao {

	
	/**
	 * This function will give list of weightage for category by college
	 * Here category represents to SC, Nt, OBC OPEN etc.
	 * @param college
	 * @return
	 */
	List<ProgramCategoryWeightage> getByCollege(College college);
	
	/**
	 * This function will give list of weightage for category by college program map
	 * Here category represents to SC, Nt, OBC OPEN etc.
	 * @param collegeProgramMap
	 * @return
	 */
	List<ProgramCategoryWeightage> getByCollegeProgramMap(CollegeProgramMap collegeProgramMap);
}
