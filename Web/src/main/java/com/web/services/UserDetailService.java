package com.web.services;

import com.web.model.UserDetailModel;

public interface UserDetailService {

	UserDetailModel getUserDetail();
	void saveUserDetail(UserDetailModel basicDetailModel);	
}
