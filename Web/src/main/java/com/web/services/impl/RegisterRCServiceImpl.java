package com.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.StudentCredentials;
import com.data.entities.User;
import com.data.entities.Student;
import com.data.entities.UserRole;
import com.data.services.StudentCredentialsService;
import com.data.services.StudentService;
import com.data.services.UserRoleService;
import com.data.services.UserService;
import com.web.model.StudentModel;
import com.web.services.RegisterRCService;
import com.web.staticandconstants.StaticConstants;

@Service("registerRCService")
public class RegisterRCServiceImpl implements RegisterRCService {

	@Autowired
	UserService userService;
	
	@Autowired
	UserRoleService userRoleService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	StudentCredentialsService studentCredentialsService;
	
	public Boolean IsUserAvailable(String userName) {
		User user = userService.getByUserName(userName);
		return (user == null) ? true : false;
	}
	
	public Boolean CreateUser(StudentModel studentModel) {
		if(!IsUserAvailable(studentModel.getUserName())) {
			return false;
		}
		
		//First creating user detail 
		Student student = new Student();
		student.setFirstName(studentModel.getFirstName());
		student.setLastName(studentModel.getLastName());
		student.setEmail(studentModel.getEmail());
		student.setMobileNo(studentModel.getMobileNo());
		student.setDateOfBirth(studentModel.getBirthDate());
		student = studentService.save(student);
		
		//Creating user
		User user = new User();
		user.setUserName(studentModel.getUserName());
		user.setPassword(studentModel.getPassword());
		user.setEnabled(1);
		user.setStudent(student);
		user = userService.save(user);
		
		//Assigning role to user as ROLE_STUDENT
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(StaticConstants.ROLE.ROLE_STUDENT);
		userRole = userRoleService.save(userRole);
		
		//Creating new credential for rest apis
		StudentCredentials studentCredential = new StudentCredentials();
		studentCredential.setClient_id(studentModel.getUserName());
		studentCredential.setClient_secret(studentModel.getPassword());
		studentCredentialsService.createStudent(studentCredential, 60*60, 24*60*60);
		
		return true;
	}
	
}
