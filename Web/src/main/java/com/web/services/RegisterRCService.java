package com.web.services;

import com.web.model.StudentModel;

public interface RegisterRCService {
	Boolean IsUserAvailable(String userName);
	Boolean CreateUser(StudentModel studentModel);
}
