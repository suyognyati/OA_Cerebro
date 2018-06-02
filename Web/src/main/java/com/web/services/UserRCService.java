package com.web.services;

import com.data.entities.User;

public interface UserRCService {
	User getUser(Integer userId);
	User getUser(String userName);
	User getUserByStudentId(Integer studentId);
}
