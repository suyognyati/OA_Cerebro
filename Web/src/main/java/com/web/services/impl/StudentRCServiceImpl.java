package com.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.Student;
import com.data.services.StudentService;
import com.web.model.StudentModel;
import com.web.services.StudentRCService;
import com.web.session.Session;

@Service("studentRCService")
public class StudentRCServiceImpl implements StudentRCService{

	@Autowired
	StudentService studentService;
	
	@Autowired
	Session userSession;
	
	public StudentModel getStudent(){
		
		Student student = userSession.getStudent().getStudent();
		StudentModel studentModel = new StudentModel();
		
		if(student != null) {
			studentModel.setLastName(student.getLastName());
			studentModel.setFirstName(student.getFirstName());
			studentModel.setBirthDate(student.getDateOfBirth());
			studentModel.setEmail(student.getEmail());
			studentModel.setMobileNo(student.getMobileNo());
		}
		return studentModel;
	}
	
	public void saveStudent(StudentModel studentModel) {
		Student student = userSession.getStudent().getStudent();
		
		if(student == null) {
			student = new Student();
		}
		
		student.setLastName(studentModel.getLastName());
		student.setFirstName(studentModel.getFirstName());
		student.setDateOfBirth(studentModel.getBirthDate());
		student.setEmail(studentModel.getEmail());
		student.setMobileNo(studentModel.getMobileNo());
		student = studentService.save(student);
	}
}
