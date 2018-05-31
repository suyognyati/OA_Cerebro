package com.web.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.College;
import com.data.entities.User;
import com.data.services.CollegeService;
import com.web.services.UserRCService;

@Service("sessionService")
public class SessionServiceImpl implements SessionService {

	@Autowired
	private Session session;
	
	@Autowired
	private UserRCService userRCService;
	
	@Autowired
	CollegeService collegeService;
	
	@Override
	public void setLoggedInUser() {
		String username = session.getLoggedInUserName();
		User user = userRCService.GetUser(username);		
		session.setLoggedInUser(user);
	}
	
	@Override
	public void setStudent() {
		String username = session.getStudentName();
		User user = userRCService.GetUser(username);		
		session.setStudent(user);
	}
	
	@Override
	public void setStudent(Integer userId) {
		User user = userRCService.GetUser(userId);		
		session.setStudent(user);		
	}
	
	@Override
	public void setStudent(String userName) {
		User user = userRCService.GetUser(userName);		
		session.setStudent(user);		
	}	

	@Override
	public void setCollege(Integer collegeId) {
		College college = collegeService.getCollege(collegeId);
		session.setCollegeId(collegeId);
		session.setCollege(college);		
	}

	/**
	 * Gives the currently logged in user name
	 * */
	/*private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}*/
	
}
