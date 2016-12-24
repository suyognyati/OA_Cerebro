package com.data.services;

import com.data.entities.PersonalDetail;
import com.data.entities.User;

public interface PersonalDetailService {
	PersonalDetail getByUser(User user);
	void save(PersonalDetail personalDetail);
}
