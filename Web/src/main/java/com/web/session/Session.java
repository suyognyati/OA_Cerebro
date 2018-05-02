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
	
	private String CurrentVendorName = null;
	private User CurrentVendor = null;
	private UserDetail CurrentVendorDetail = null;
	
	private String CurrentUserName = null;
	private User CurrentUser = null;
	private UserDetail CurrentUserDetail = null;
	
	private User LoggedInUser = null;
	private UserDetail LoggedInUserDetail = null;
	
	private Boolean isApplicantFixed = false;
	private User Applicant = null;
	
	private Integer collegeId = null;
	private College College = null;
	
	
	
	/* Getters for user */
	
	public String getCurrentUserName() {
		return CurrentUserName;
	}

	public User getCurrentUser() {
		return CurrentUser;
	}

	public UserDetail getCurrentUserDetail() {
		return CurrentUserDetail;
	}

	/* Setters for user */
	
	public void setCurrentUserName()	{
		CurrentUserName = getPrincipal();
	}
	
	public void setCurrentUser() {
		if(CurrentUserName == null)
			setCurrentUserName();
		CurrentUser = sessionService.GetUser(CurrentUserName);
	}
	
	public void setCurrentUserDetail() {
		if(CurrentUserName == null)
			setCurrentUserName();
		if(CurrentUser == null)
			setCurrentUser();
		CurrentUserDetail = sessionService.GetUserDetail(CurrentUser);
	}
	
	/* Getters for vendor */
	
	public String getCurrentVendorName() {
		return CurrentVendorName;
	}

	public User getCurrentVendor() {
		return CurrentVendor;
	}

	public UserDetail getCurrentVendorDetail() {
		return CurrentVendorDetail;
	}

	/* Setters for vendor */
	
	public void setCurrentVendorName()	{
		CurrentVendorName = getPrincipal();
	}
	
	public void setCurrentVendor() {
		if(CurrentVendorName == null)
			setCurrentVendorName();
		CurrentVendor = sessionService.GetUser(CurrentVendorName);
	}
	
	public void setCurrentVendorDetail() {
		if(CurrentVendorName == null)
			setCurrentVendorName();
		if(CurrentVendor == null)
			setCurrentVendor();
		CurrentVendorDetail = sessionService.GetUserDetail(CurrentVendor);
	}
	
	/* Getter setter */
	
	public User getLoggedInUser() {
		return LoggedInUser;
	}
	public void setLoggedInUser(User loggedInUser) {
		LoggedInUser = loggedInUser;
	}

	public UserDetail getLoggedInUserDetail() {
		return LoggedInUserDetail;
	}
	public void setLoggedInUserDetail(UserDetail loggedInUserDetail) {
		LoggedInUserDetail = loggedInUserDetail;
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
