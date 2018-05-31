package com.web.services;

import com.web.model.StudentModel;

public interface StudentRCService {

	StudentModel getStudent();
	void saveStudent(StudentModel basicDetailModel);	
}
