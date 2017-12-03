package com.data.services;

import com.data.entities.User;

public interface UserService {
	User getByUserId(Integer userId);
	User getByUserName(String userName);
	User save(User user);
}
