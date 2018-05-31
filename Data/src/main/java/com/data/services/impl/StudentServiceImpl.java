package com.data.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.Student;
import com.data.repository.StudentJpaRepository;
import com.data.services.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentJpaRepository studentJpaRepository;
	
	public Student save(Student student) {
		return studentJpaRepository.save(student);
	}

}
