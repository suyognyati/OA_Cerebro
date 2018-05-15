package com.data.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.User;
import com.data.entities.UserDetail;
import com.data.repository.UserDetailJpaRepository;
import com.data.services.UserDetailService;

@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailService {

	@Autowired
	UserDetailJpaRepository userDetailJpaRepository;
	
	public UserDetail save(UserDetail userDetail) {
		return userDetailJpaRepository.save(userDetail);
	}

}
