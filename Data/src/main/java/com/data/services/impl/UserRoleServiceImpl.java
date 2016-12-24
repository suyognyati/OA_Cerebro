package com.data.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.UserRole;
import com.data.repository.UserRoleJpaRepository;
import com.data.services.UserRoleService;

@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	UserRoleJpaRepository userRoleJpaRepository;
	
	public UserRole save(UserRole userRole) {
		return userRoleJpaRepository.save(userRole);
	}

}
