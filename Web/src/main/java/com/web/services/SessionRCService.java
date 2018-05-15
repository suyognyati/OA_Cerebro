package com.web.services;

import com.data.entities.User;

public interface SessionRCService {
	User GetUser(Integer userId);
	User GetUser(String userName);
}
