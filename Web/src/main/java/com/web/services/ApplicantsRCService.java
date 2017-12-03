package com.web.services;

import com.data.entities.User;
import com.web.model.ApplicantsModel;

public interface ApplicantsRCService {

	ApplicantsModel getApplicantDetail(User user);
}
