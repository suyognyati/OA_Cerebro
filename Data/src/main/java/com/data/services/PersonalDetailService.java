package com.data.services;

import com.data.entities.PersonalDetail;
import com.data.entities.UserDetail;

public interface PersonalDetailService {
	PersonalDetail getByUserDetail(UserDetail userDetail);
	void save(PersonalDetail personalDetail);
}
