package com.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.UserDetail;
import com.data.services.UserDetailService;
import com.web.model.UserDetailModel;
import com.web.services.UserDetailRCService;
import com.web.session.Session;

@Service("userDetailRCService")
public class UserDetailRCServiceImpl implements UserDetailRCService{

	@Autowired
	UserDetailService userDetailService;
	
	@Autowired
	Session userSession;
	
	public UserDetailModel getUserDetail(){
		
		UserDetail userDetail = userSession.getStudent().getUserDetail();
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
		UserDetail userDetail = userSession.getStudent().getUserDetail();
		
		if(userDetail == null) {
			userDetail = new UserDetail();
		}
		
		userDetail.setLastName(userDetailModel.getLastName());
		userDetail.setFirstName(userDetailModel.getFirstName());
		userDetail.setDateOfBirth(userDetailModel.getBirthDate());
		userDetail.setEmail(userDetailModel.getEmail());
		userDetail.setMobileNo(userDetailModel.getMobileNo());
		userDetail = userDetailService.save(userDetail);
	}
}
