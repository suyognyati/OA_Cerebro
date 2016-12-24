package com.data.services;

import com.data.entities.User;

public interface UserService {
	User getByUserName(String userName);
	User save(User user);
}
