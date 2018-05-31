package com.web.session;

public interface SessionService {

	/**
	 * This will save logged in user detail in LoggedInUser variable of current session.
	 * Prefer to not use this for student 
	 */
	void setLoggedInUser();
	/**
	 * This will save logged in student detail in Student variable of current session.
	 */
	void setStudent();
	/**
	 * This will save logged in student detail in Student variable of current session.
	 * This function is helper function to save detail for temporary use 
	 * @param userId
	 */
	void setStudent(Integer userId);
	/**
	 * This will save logged in student detail in Student variable of current session.
	 * This function is helper function to save detail for temporary use 
	 * @param userName
	 */
	void setStudent(String userName);
	
	/**
	 * To set college in session
	 * @param collegeId
	 */
	void setCollege(Integer collegeId);
}
