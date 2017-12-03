package com.web.services;

import com.data.entities.User;
import com.data.entities.UserDetail;

public interface SessionRCService {
	User GetUser(Integer userId);
	User GetUser(String userName);
	UserDetail GetUserDetail(User user);
}
