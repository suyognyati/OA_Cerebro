package com.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.User;
import com.data.repository.UserJpaRepository;
import com.data.services.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserJpaRepository userJpaRepository;
	
	@Override
	public User getByUserId(Integer userId) {
		return userJpaRepository.findOne(userId);
	}
	
	@Override
	public User getByUserName(String userName) {
		return userJpaRepository.findByUserName(userName);
	}
	
	@Override
	public User save(User user) {
		return userJpaRepository.save(user);
	}

	@Override
	public User getByStudentId(Integer studentId) {
		List<User> users = userJpaRepository.findByStudentId(studentId);
		if(users != null && users.size() > 0)
			return users.get(0);
		else {
			return null;
		}
	}
}
