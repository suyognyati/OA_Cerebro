package com.web.services;

import com.web.model.PersonalDetailModel;

public interface PersonalDetailService {
	PersonalDetailModel getPersonalDetail();
	void savePersonalDetail(PersonalDetailModel personalDetailModel);
}
