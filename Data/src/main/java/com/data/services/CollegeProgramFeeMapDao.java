package com.data.services;

import java.util.List;

import com.data.entities.College;
import com.data.entities.CollegeProgramFeeMap;
import com.data.entities.University_Program;

public interface CollegeProgramFeeMapDao {
	
	List<CollegeProgramFeeMap> getByCollegeProgramAndYear(College college, University_Program program, Integer year);

}
