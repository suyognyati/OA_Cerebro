package com.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.Application;
import com.data.entities.CollegeProgramMap;
import com.data.entities.StudentSelectedSubject;
import com.data.entities.UserDetail;
import com.data.repository.StudentSelectedSubjectJpaRepository;
import com.data.services.StudentSelectedSubjectsDao;

@Service("studentSelectedSubjectsDao")
public class StudentSelectedSubjectsDaoImpl implements StudentSelectedSubjectsDao {

	@Autowired
	StudentSelectedSubjectJpaRepository studentSelectedSubjectjpaRepository;
	
	@Override
	public List<StudentSelectedSubject> save(List<StudentSelectedSubject> studentSelectedSubjectList) {
		return studentSelectedSubjectjpaRepository.save(studentSelectedSubjectList);
	}
	
	@Override
	public List<StudentSelectedSubject> getSelectedSubjectOfApplication(Application application, CollegeProgramMap collegeProgramMap, UserDetail student){
		return studentSelectedSubjectjpaRepository.findByApplicationAndCollegeProgramMapAndStudent(application, collegeProgramMap, student);
	}
}
