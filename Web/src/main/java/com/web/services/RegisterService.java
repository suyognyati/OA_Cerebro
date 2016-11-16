package com.web.services;

import com.web.model.UserDetailModel;

public interface RegisterService {
	Boolean IsUserAvailable(String userName);
	Boolean CreateUser(UserDetailModel userDetailModel);
}
