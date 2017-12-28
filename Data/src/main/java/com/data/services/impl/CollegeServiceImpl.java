package com.data.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.College;
import com.data.repository.CollegeJpaRepository;
import com.data.services.CollegeService;

@Service("collegeService")
public class CollegeServiceImpl implements CollegeService {

	@Autowired
	CollegeJpaRepository collegeJPARepository;
	
	@Override
	public College getCollege(Integer collegeId) {
		return collegeJPARepository.getOne(collegeId);
	}

}
