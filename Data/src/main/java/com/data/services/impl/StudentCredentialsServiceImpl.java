package com.data.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.StudentCredentials;
import com.data.repository.StudentCredentialsJpaRepository;
import com.data.services.StudentCredentialsService;

@Service("studentCredentialsService")
public class StudentCredentialsServiceImpl implements StudentCredentialsService {

	@Autowired
	StudentCredentialsJpaRepository studentCredentialsJpaRepository;
	
	@Override
	public Boolean createStudent(StudentCredentials newStudentCredential, Integer accessTokenValidity, Integer refreshTokenValidity) {
		newStudentCredential.setScope("read,write,trust");
		newStudentCredential.setAuthorized_grant_types("password,authorization_code,refresh_token,implicit");
		newStudentCredential.setAuthorities("ROLE_CLIENT,ROLE_TRUSTED_CLIENT");
		newStudentCredential.setAccess_token_validity(accessTokenValidity);
		newStudentCredential.setRefresh_token_validity(refreshTokenValidity);
		newStudentCredential.setAdditional_information("{}");
		newStudentCredential.setAutoapprove("");
		
		StudentCredentials studentCredential = studentCredentialsJpaRepository.save(newStudentCredential);
		if(studentCredential == null)
			return false;
		else
			return true;
	}

}
