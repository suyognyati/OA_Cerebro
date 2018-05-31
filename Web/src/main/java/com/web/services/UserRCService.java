package com.web.services;

import com.data.entities.User;

public interface UserRCService {
	User GetUser(Integer userId);
	User GetUser(String userName);
}
