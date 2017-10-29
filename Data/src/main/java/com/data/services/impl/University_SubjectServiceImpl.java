package com.data.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.repository.University_SubjectJpaRepository;
import com.data.services.University_SubjectService;

@Service("university_SubjectService")
public class University_SubjectServiceImpl implements University_SubjectService {

	@Autowired
	University_SubjectJpaRepository university_SubjectJpaRepository;
}
