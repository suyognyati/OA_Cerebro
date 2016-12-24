package com.data.services;

import com.data.entities.User;
import com.data.entities.UserDetail;

public interface UserDetailService {
	UserDetail getByUser(User user);
	UserDetail save(UserDetail userDetail);
}
