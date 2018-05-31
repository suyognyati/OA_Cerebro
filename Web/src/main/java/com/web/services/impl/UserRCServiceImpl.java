package com.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.User;
import com.data.services.UserService;
import com.web.services.UserRCService;

@Service("sessionRCService")
public class UserRCServiceImpl implements UserRCService {

	@Autowired
	UserService userService;
	
	public User GetUser(Integer userId) {
		return userService.getByUserId(userId);
	}
	
	public User GetUser(String userName) {
		return userService.getByUserName(userName);
	}
	
}
