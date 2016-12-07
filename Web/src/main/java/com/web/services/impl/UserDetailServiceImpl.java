package com.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.UserDetail;
import com.data.repository.UserDetailJpaRepository;
import com.web.model.UserDetailModel;
import com.web.services.UserDetailService;
import com.web.session.Session;

@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailService{

	@Autowired
	UserDetailJpaRepository userDetailJpaRepository;
	
	@Autowired
	Session userSession;
	
	public UserDetailModel getUserDetail(){
		
		UserDetail userDetail = userDetailJpaRepository.findByUser(userSession.getCurrentUser());
		UserDetailModel userDetailModel = new UserDetailModel();
		
		if(userDetail != null) {
			userDetailModel.setLastName(userDetail.getLastName());
			userDetailModel.setFirstName(userDetail.getFirstName());
			userDetailModel.setBirthDate(userDetail.getDateOfBirth());
			userDetailModel.setEmail(userDetail.getEmail());
			userDetailModel.setMobileNo(userDetail.getMobileNo());
		}
		return userDetailModel;
	}
	
	public void saveUserDetail(UserDetailModel userDetailModel) {
		UserDetail userDetail = userDetailJpaRepository.findByUser(userSession.getCurrentUser());
		
		if(userDetail == null) {
			userDetail = new UserDetail();
			userDetail.setUser(userSession.getCurrentUser());
		}
		
		userDetail.setLastName(userDetailModel.getLastName());
		userDetail.setFirstName(userDetailModel.getFirstName());
		userDetail.setDateOfBirth(userDetailModel.getBirthDate());
		userDetail.setEmail(userDetailModel.getEmail());
		userDetail.setMobileNo(userDetailModel.getMobileNo());
		userDetail = userDetailJpaRepository.save(userDetail);
	}
}
