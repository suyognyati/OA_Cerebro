package com.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.EducationalInformation;
import com.data.repository.EducationalInformationJpaRepository;
import com.data.services.EducationalInformationService;

@Service("educationalInformationService")
public class EducationalInformationServiceImpl implements EducationalInformationService {

	@Autowired
	EducationalInformationJpaRepository educationalInformationJpaRepository;
	
	public List<EducationalInformation> getAll() {
		return educationalInformationJpaRepository.findAll();
	}

}
