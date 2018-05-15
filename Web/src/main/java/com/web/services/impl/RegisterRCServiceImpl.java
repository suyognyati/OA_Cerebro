package com.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.StudentCredentials;
import com.data.entities.User;
import com.data.entities.UserDetail;
import com.data.entities.UserRole;
import com.data.services.StudentCredentialsService;
import com.data.services.UserDetailService;
import com.data.services.UserRoleService;
import com.data.services.UserService;
import com.web.model.UserDetailModel;
import com.web.services.RegisterRCService;

@Service("registerRCService")
public class RegisterRCServiceImpl implements RegisterRCService {

	@Autowired
	UserService userService;
	
	@Autowired
	UserRoleService userRoleService;
	
	@Autowired
	UserDetailService userDetailService;
	
	@Autowired
	StudentCredentialsService studentCredentialsService;
	
	public Boolean IsUserAvailable(String userName) {
		User user = userService.getByUserName(userName);
		return (user == null) ? true : false;
	}
	
	public Boolean CreateUser(UserDetailModel userDetailModel) {
		if(!IsUserAvailable(userDetailModel.getUserName())) {
			return false;
		}
				
		UserDetail userDetail = new UserDetail();
		userDetail.setFirstName(userDetailModel.getFirstName());
		userDetail.setLastName(userDetailModel.getLastName());
		userDetail.setEmail(userDetailModel.getEmail());
		userDetail.setMobileNo(userDetailModel.getMobileNo());
		userDetail.setDateOfBirth(userDetailModel.getBirthDate());
		userDetail = userDetailService.save(userDetail);
		
		User user = new User();
		user.setUserName(userDetailModel.getUserName());
		user.setPassword(userDetailModel.getPassword());
		user.setEnabled(1);
		user.setUserDetail(userDetail);
		user = userService.save(user);
		
		UserRole userRole = new UserRole();
		userRole.setUserName(user);
		userRole.setRole("ROLE_USER");
		userRole = userRoleService.save(userRole);
		
		StudentCredentials studentCredential = new StudentCredentials();
		studentCredential.setClient_id(userDetailModel.getUserName());
		studentCredential.setClient_secret(userDetailModel.getPassword());
		studentCredentialsService.createStudent(studentCredential, 60*60, 24*60*60);
		
		return true;
	}
	
}
