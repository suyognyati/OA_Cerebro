package com.web.services;

import com.data.entities.User;
import com.web.model.PrintApplicationModel;

public interface PrintApplicationRCService {

	PrintApplicationModel getPrintApplicationDetail(User user);
}
