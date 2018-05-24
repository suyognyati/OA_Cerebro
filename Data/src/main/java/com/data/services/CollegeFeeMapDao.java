package com.data.services;

import java.util.List;

import com.data.entities.College;
import com.data.entities.CollegeFeeMap;

public interface CollegeFeeMapDao {
	
	List<CollegeFeeMap> getByCollegeAndYear(College college, Integer year);

}
