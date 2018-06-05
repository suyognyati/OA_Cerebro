package com.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.College;
import com.data.entities.CollegeProgramMap;
import com.data.entities.ProgramCategoryWeightage;
import com.data.repository.ProgramCategoryWeightageJpaRepository;
import com.data.services.ProgramCategoryWeightageDao;

@Service("programCategoryWeightageDao")
public class ProgramCategoryWeightageDaoImpl implements ProgramCategoryWeightageDao {

	@Autowired
	ProgramCategoryWeightageJpaRepository programCategoryWeightageJpaRepository;
	
	@Override
	public List<ProgramCategoryWeightage> getByCollege(College college) {
		return programCategoryWeightageJpaRepository.findByCollege(college);
	}

	@Override
	public List<ProgramCategoryWeightage> getByCollegeProgramMap(CollegeProgramMap collegeProgramMap) {
		return programCategoryWeightageJpaRepository.findByCollegeProgram(collegeProgramMap);
	}

}
