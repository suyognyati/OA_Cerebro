package com.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.College;
import com.data.entities.CollegeProgramMap;
import com.data.entities.ProgramCategory;
import com.data.entities.University_Program;
import com.data.repository.CollegeJpaRepository;
import com.data.repository.CollegeProgramMapJPARepository;
import com.data.repository.ProgramCategoryJpaRepository;
import com.data.repository.University_ProgramJpaRepository;
import com.data.services.CollegeProgramMapService;

@Service("collegeProgramMapService")
public class CollegeProgramMapServiceImpl implements CollegeProgramMapService {
	
	@Autowired
	CollegeProgramMapJPARepository collegeProgramMapJPARepository;
	
	@Autowired
	ProgramCategoryJpaRepository programCategoryJpaRepository;
	
	@Autowired
	CollegeJpaRepository collegeJpaRepository;
	
	@Autowired
	University_ProgramJpaRepository university_ProgramJpaRepository;
	
	@Override
	public List<CollegeProgramMap> getCollegeProgramsByCategory(Integer collegeId, Integer programCategoryId) {
		ProgramCategory programCategory = programCategoryJpaRepository.getOne(programCategoryId);
		College college = collegeJpaRepository.getOne(collegeId);
		
		return collegeProgramMapJPARepository.findByCollegeAndProgramCategory(college, programCategory);
	}
	
	@Override
	public List<CollegeProgramMap> getAllProgramsOfCollege(Integer collegeId) {
		College college = collegeJpaRepository.findOne(collegeId);		
		return collegeProgramMapJPARepository.findByCollege(college);
	}

	@Override
	public List<CollegeProgramMap> getAllProgramsOfCollege(College college) {
		return collegeProgramMapJPARepository.findByCollege(college);
	}
	
	@Override
	public CollegeProgramMap getCollegeProgramByCollegeAndProgram(Integer collegeId, Integer programId) {
		College college = collegeJpaRepository.findOne(collegeId);
		University_Program program = university_ProgramJpaRepository.findOne(programId);
		return collegeProgramMapJPARepository.findByCollegeAndProgram(college, program);
	}
	
	@Override
	public CollegeProgramMap getById(Integer id) {		
		return collegeProgramMapJPARepository.findOne(id);
	}

	

	

	
}
