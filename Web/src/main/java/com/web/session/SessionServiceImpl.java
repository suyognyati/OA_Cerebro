package com.web.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.data.entities.User;
import com.data.entities.UserDetail;
import com.web.services.SessionRCService;

@Service("sessionService")
public class SessionServiceImpl implements SessionService {

	@Autowired
	private Session session;
	
	@Autowired
	private SessionRCService sessionRCService;
	
	User user = null;
	UserDetail userDetail = null;
	
	@Override
	public void setLoggedInUserDetails() {
		String username = getPrincipal();
		user = sessionRCService.GetUser(username);
		userDetail = sessionRCService.GetUserDetail(user);
		
		session.setLoggedInUser(user);
		session.setLoggedInUserDetail(userDetail);
		
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
