package com.web.services;

import com.web.model.PersonalDetailModel;

public interface PersonalDetailRCService {
	PersonalDetailModel getPersonalDetail();
	void savePersonalDetail(PersonalDetailModel personalDetailModel);
}
