package com.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.ProgramCategory;
import com.data.repository.ProgramCategoryJpaRepository;
import com.data.services.ProgramCategoryService;

@Service("programCategoryService")
public class ProgramCategoryServiceImpl implements ProgramCategoryService {

	@Autowired
	ProgramCategoryJpaRepository programCategoryJpaRepository;
	
	@Override
	public List<ProgramCategory> getAllProgramCategories() {
		return programCategoryJpaRepository.findAll();
	}

}
