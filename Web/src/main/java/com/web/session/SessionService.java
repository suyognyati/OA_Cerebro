package com.web.session;

public interface SessionService {

	void setApplicant(Integer userId);
	void setLoggedInUser();
	void setCollege(Integer collegeId);
}
