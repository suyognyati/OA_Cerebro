package com.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.College;
import com.data.entities.CollegeSubjectMap;
import com.data.entities.University_Program;
import com.data.repository.CollegeJpaRepository;
import com.data.repository.CollegeSubjectMapJPARepository;
import com.data.repository.University_ProgramJpaRepository;
import com.data.services.CollegeSubjectMapService;

@Service("collegeSubjectMapService")
public class CollegeSubjectMapServiceImpl implements CollegeSubjectMapService {

	@Autowired
	CollegeSubjectMapJPARepository collegeSubjectMapJPARepository;
	
	@Autowired
	University_ProgramJpaRepository programJpaRepository;
	
	@Autowired
	CollegeJpaRepository collegeJpaRepository;
	
	@Override
	public List<CollegeSubjectMap> getCollegeSubjectsByProgram(Integer collegeId, Integer programId) {
		University_Program program = programJpaRepository.getOne(programId);
		College college = collegeJpaRepository.getOne(collegeId);
		
		return collegeSubjectMapJPARepository.findByCollegeAndProgram(college, program);
	}

}
