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
	void setStudentUser();
	/**
	 * This will save logged in student detail in Student variable of current session.
	 * This function is helper function to save detail for temporary use 
	 * @param userId
	 */
	void setStudentUser(Integer userId);
	/**
	 * This will save logged in student detail in Student variable of current session.
	 * This function is helper function to save detail for temporary use 
	 * @param userName
	 */
	void setStudentUser(String userName);
	/**
	 * This function will search for studentId in user table and save student user in session.
	 * This function is helper function to save detail before getting data 
	 * @param studentId
	 */
	void setStudentUserByStudentId(Integer studentId);
	
	/**
	 * To set college in session
	 * @param collegeId
	 */
	void setCollege(Integer collegeId);
}
