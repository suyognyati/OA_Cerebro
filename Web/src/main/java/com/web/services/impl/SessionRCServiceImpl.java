package com.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.User;
import com.data.services.UserDetailService;
import com.data.services.UserService;
import com.web.services.SessionRCService;

@Service("sessionRCService")
public class SessionRCServiceImpl implements SessionRCService {

	@Autowired
	UserService userService;
	
	@Autowired
	UserDetailService userDetailService;
	
	public User GetUser(Integer userId) {
		return userService.getByUserId(userId);
	}
	
	public User GetUser(String userName) {
		return userService.getByUserName(userName);
	}
	
}
