package com.web.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.data.entities.College;
import com.data.entities.User;
import com.data.entities.Student;
import com.data.services.CollegeService;
import com.web.services.UserRCService;

@Service("sessionService")
public class SessionServiceImpl implements SessionService {

	@Autowired
	private Session session;
	
	@Autowired
	private UserRCService sessionRCService;
	
	@Autowired
	CollegeService collegeService;
	
	User user = null;
	Student student = null;
	
	@Override
	public void setLoggedInUser() {
		String username = getPrincipal();
		user = sessionRCService.GetUser(username);		
		session.setLoggedInUser(user);		
	}
	
	@Override
	public void setApplicant(Integer userId) {
		user = sessionRCService.GetUser(userId);		
		session.setApplicant(user);		
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

	@Override
	public void setCollege(Integer collegeId) {
		College college = collegeService.getCollege(collegeId);
		session.setCollegeId(collegeId);
		session.setCollege(college);		
	}

	
	
}
