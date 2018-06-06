package com.web.services;

import com.data.entities.College;
import com.web.model.ProgramCategoryWeightageModel;

public interface ProgramCategoryWeightageRCService {

	ProgramCategoryWeightageModel getCategoryWeightage(Integer collegeProgramMapId, College college);
	ProgramCategoryWeightageModel getCategoryWeightageByProgramId(Integer programId, College college);
	
	Boolean setCategoryWeightage(ProgramCategoryWeightageModel programCategoryWeightageModel);
}
