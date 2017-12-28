package com.web.session;

public interface SessionService {

	void setApplicant(Integer userId);
	void setLoggedInUserDetails();
	void setCollege(Integer collegeId);
}
