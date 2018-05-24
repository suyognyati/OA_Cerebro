package com.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.College;
import com.data.entities.CollegeFeeMap;
import com.data.repository.CollegeFeeMapJpaRepository;
import com.data.services.CollegeFeeMapDao;

@Service("collegeFeeMapDao")
public class CollegeFeeMapDaoImpl implements CollegeFeeMapDao {

	@Autowired
	CollegeFeeMapJpaRepository collegeFeeMapJpaRepository;
	
	@Override
	public List<CollegeFeeMap> getByCollegeAndYear(College college, Integer year) {
		List<CollegeFeeMap> collegeFeeMapList = collegeFeeMapJpaRepository.findByCollegeAndYear(college, year);
		if(!(collegeFeeMapList != null && collegeFeeMapList.size() > 0)) {
			collegeFeeMapList = collegeFeeMapJpaRepository.findByCollegeAndYear(college, null);
		}
		return collegeFeeMapList;
	}

}
