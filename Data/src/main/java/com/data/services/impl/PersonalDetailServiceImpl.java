package com.data.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.PersonalDetail;
import com.data.entities.Student;
import com.data.repository.PersonalDetailJpaRepository;
import com.data.services.PersonalDetailService;

@Service("personalDetailService")
public class PersonalDetailServiceImpl implements PersonalDetailService {

	@Autowired
	PersonalDetailJpaRepository personalDetailJpaRepository;
	
	public PersonalDetail getByStudent(Student student) {
		return personalDetailJpaRepository.findByStudent(student);
	}
	
	public void save(PersonalDetail personalDetail) {
		personalDetailJpaRepository.save(personalDetail);
	}

}
