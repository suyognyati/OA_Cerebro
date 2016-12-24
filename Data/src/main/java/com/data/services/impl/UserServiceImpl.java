package com.data.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.User;
import com.data.repository.UserJpaRepository;
import com.data.services.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserJpaRepository userJpaRepository;
	
	public User getByUserName(String userName) {
		return userJpaRepository.findByUserName(userName);
	}
	
	public User save(User user) {
		return userJpaRepository.save(user);
	}
}
