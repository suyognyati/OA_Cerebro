package com.data.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.University_Program;
import com.data.repository.University_ProgramJpaRepository;
import com.data.services.University_ProgramService;

@Service("university_ProgramService")
public class University_ProgramServiceImpl implements University_ProgramService {
	
	@Autowired
	University_ProgramJpaRepository university_ProgramJpaRepository;

	@Override
	public University_Program getById(Integer programId) {
		return university_ProgramJpaRepository.findOne(programId);
	}
	
}
