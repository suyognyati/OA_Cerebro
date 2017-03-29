package com.data.services;

import com.data.entities.StudentCredentials;

public interface StudentCredentialsService {
	Boolean createStudent(StudentCredentials studentCredential, Integer accessTokenValidity, Integer refreshTokenValidity);
}
