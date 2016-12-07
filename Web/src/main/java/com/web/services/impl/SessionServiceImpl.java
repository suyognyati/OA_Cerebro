package com.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.User;
import com.data.entities.UserDetail;
import com.data.repository.UserDetailJpaRepository;
import com.data.repository.UserJpaRepository;
import com.web.services.SessionService;

@Service("sessionService")
public class SessionServiceImpl implements SessionService {

	@Autowired
	UserJpaRepository userJpaRepository;
	
	@Autowired
	UserDetailJpaRepository userDetailJpaRepository;
	
	@Override
	public User GetUser(String userName) {
		return userJpaRepository.findByUserName(userName);
	}

	@Override
	public UserDetail GetUserDetail(User user) {
		return userDetailJpaRepository.findByUser(user);
	}

}
