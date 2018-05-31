package com.web.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.data.entities.College;
import com.data.entities.User;
import com.web.services.UserRCService;

@Component
@Scope(value="session",proxyMode=ScopedProxyMode.TARGET_CLASS)
public class Session {
	@Autowired
	UserRCService sessionService;
	
	private String StudentName = null;
	private User Student = null;
	
	private String LoggedInUserName = null;
	private User LoggedInUser = null;
	
	/*private Boolean isApplicantFixed = false;
	private User Applicant = null;*/
	
	private Integer collegeId = null;
	private College College = null;
	
	
	
	/* Getter Setter of Student */
	
	public String getStudentName() {
		StudentName = getPrincipal();
		return StudentName;
	}
	
	public User getStudent() {
		return Student;
	}
	public void setStudent(User student) {
		this.Student = student;
	}
	
	public String getLoggedInUserName() {
		LoggedInUserName = getPrincipal();
		return LoggedInUserName;
	}

	public User getLoggedInUser() {
		return LoggedInUser;
	}
	public void setLoggedInUser(User loggedInUser) {
		LoggedInUser = loggedInUser;
	}

	/*public Boolean getIsApplicantFixed() {
		return isApplicantFixed;
	}
	public void setIsApplicantFixed(Boolean isApplicantFixed) {
		this.isApplicantFixed = isApplicantFixed;
	}*/

	/*public User getStudent() {
		//return Applicant;
		if(Applicant != null) {
			User tempStudent = Applicant;
			if(!isApplicantFixed)
				Applicant = null;
			return tempStudent;
		}
		return Student;
	}
	public void setStudent(User applicant) {
		if(!isApplicantFixed)
			Applicant = applicant;
	}*/

	public Integer getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(Integer collegeId) {
		this.collegeId = 1;
	}

	public College getCollege() {
		return College;
	}
	public void setCollege(College college) {
		College = college;
	}
	
	
	
	/**
	 * Gives the currently logged in user name
	 * */
	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
}
