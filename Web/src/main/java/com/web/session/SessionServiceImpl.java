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
		User user = userRCService.getUser(username);		
		session.setLoggedInUser(user);
	}
	
	@Override
	public void setStudentUser() {
		String username = session.getStudentName();
		User user = userRCService.getUser(username);		
		session.setStudent(user);
	}
	
	@Override
	public void setStudentUser(Integer userId) {
		User user = userRCService.getUser(userId);		
		session.setStudent(user);		
	}
	
	@Override
	public void setStudentUser(String userName) {
		User user = userRCService.getUser(userName);		
		session.setStudent(user);		
	}
	
	@Override
	public void setStudentUserByStudentId(Integer studentId) {
		User user = userRCService.getUserByStudentId(studentId);		
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
