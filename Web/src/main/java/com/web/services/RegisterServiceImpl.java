package com.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.User;
import com.data.entities.UserDetail;
import com.data.entities.UserRole;
import com.data.repository.UserDetailJpaRepository;
import com.data.repository.UserJpaRepository;
import com.data.repository.UserRoleJpaRepository;
import com.web.model.UserDetailModel;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	UserJpaRepository userJpaRepository;
	
	@Autowired
	UserRoleJpaRepository userRoleJpaRepository;
	
	@Autowired
	UserDetailJpaRepository userDetailJpaRepository;
	
	public Boolean IsUserAvailable(String userName) {
		User user = userJpaRepository.findByUserName(userName);
		return (user == null) ? true : false;
	}
	
	public Boolean CreateUser(UserDetailModel userDetailModel) {
		if(!IsUserAvailable(userDetailModel.getUserName())) {
			return false;
		}
		User user = new User();
		user.setUserName(userDetailModel.getUserName());
		user.setPassword(userDetailModel.getPassword());
		user.setEnabled(1);
		user = userJpaRepository.save(user);
		
		UserDetail userDetail = new UserDetail();
		userDetail.setFirstName(userDetailModel.getFirstName());
		userDetail.setLastName(userDetailModel.getLastName());
		userDetail.setEmail(userDetailModel.getEmail());
		userDetail.setMobileNo(userDetailModel.getMobileNo());
		userDetail.setDateOfBirth(userDetailModel.getBirthDate());
		userDetail.setUser(user);
		userDetail = userDetailJpaRepository.save(userDetail);
		
		UserRole userRole = new UserRole();
		userRole.setUserName(user);
		userRole.setRole("ROLE_USER");
		userRole = userRoleJpaRepository.save(userRole);
		
		return true;
	}
	
}
