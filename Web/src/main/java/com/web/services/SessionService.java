package com.web.services;

import com.data.entities.User;
import com.data.entities.UserDetail;

public interface SessionService {
	User GetUser(String userName);
	UserDetail GetUserDetail(User user);
}
