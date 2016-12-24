package com.web.services;

import com.web.model.UserDetailModel;

public interface UserDetailRCService {

	UserDetailModel getUserDetail();
	void saveUserDetail(UserDetailModel basicDetailModel);	
}
