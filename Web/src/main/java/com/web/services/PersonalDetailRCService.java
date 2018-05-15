package com.web.services;

import com.data.entities.User;
import com.web.model.PersonalDetailModel;

public interface PersonalDetailRCService {
	PersonalDetailModel getPersonalDetail(User user);
	void savePersonalDetail(PersonalDetailModel personalDetailModel, User user);
}
