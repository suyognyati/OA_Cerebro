package com.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.College;
import com.data.entities.CollegeProgramFeeMap;
import com.data.entities.University_Program;
import com.data.repository.CollegeProgramFeeMapJpaRepository;
import com.data.services.CollegeProgramFeeMapDao;

@Service("collegeProgramFeeMapDao")
public class CollegeProgramFeeMapDaoImpl implements CollegeProgramFeeMapDao {

	@Autowired
	CollegeProgramFeeMapJpaRepository collegeProgramFeeMapJpaRepository;
	
	@Override
	public List<CollegeProgramFeeMap> getByCollegeProgramAndYear(College college, University_Program program, Integer year) {
		List<CollegeProgramFeeMap> collegeProgramFeeMapList = collegeProgramFeeMapJpaRepository.findByCollegeAndProgramAndYear(college, program, year);
		if(!(collegeProgramFeeMapList != null && collegeProgramFeeMapList.size() > 0)) {
			collegeProgramFeeMapList = collegeProgramFeeMapJpaRepository.findByCollegeAndProgramAndYear(college, program, null);
		}
		return collegeProgramFeeMapList;
	}

}
