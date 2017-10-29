package com.data.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.repository.University_UniversityJpaRepository;
import com.data.services.University_UniversityService;

@Service("university_UniversityService")
public class University_UniversityServiceImpl implements University_UniversityService {
	
	@Autowired
	University_UniversityJpaRepository university_UniversityJpaRepository;
}
