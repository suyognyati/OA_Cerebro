package com.web.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.data.entities.College;
import com.data.entities.User;
import com.data.entities.UserDetail;
import com.web.services.SessionRCService;

@Component
@Scope(value="session",proxyMode=ScopedProxyMode.TARGET_CLASS)
public class Session {
	@Autowired
	SessionRCService sessionService;
	
	private String StudentName = null;
	private User Student = null;
	
	private User LoggedInUser = null;
	
	private Boolean isApplicantFixed = false;
	private User Applicant = null;
	
	private Integer collegeId = null;
	private College College = null;
	
	
	
	/* Getter Setter of Student */
	
	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName()	{
		StudentName = getPrincipal();
	}
	
	public User getStudent() {
		return Student;
	}

	public void setStudent() {
		if(StudentName == null)
			setStudentName();
		Student = sessionService.GetUser(StudentName);
	}
	
	/* Getter setter */
	
	public User getLoggedInUser() {
		return LoggedInUser;
	}
	public void setLoggedInUser(User loggedInUser) {
		LoggedInUser = loggedInUser;
	}

	public Boolean getIsApplicantFixed() {
		return isApplicantFixed;
	}
	public void setIsApplicantFixed(Boolean isApplicantFixed) {
		this.isApplicantFixed = isApplicantFixed;
	}

	public User getApplicant() {
		return Applicant;
	}
	public void setApplicant(User applicant) {
		if(!isApplicantFixed)
			Applicant = applicant;
	}

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
