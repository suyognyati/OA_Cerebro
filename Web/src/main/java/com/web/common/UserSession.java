package com.web.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.data.entities.User;
import com.data.repository.UserJpaRepository;

@Component
@Scope(value="session",proxyMode=ScopedProxyMode.TARGET_CLASS)
public class UserSession {
	@Autowired
	UserJpaRepository userJpaRepository;
	
	private String CurrentUserName = null;
	private User CurrentUser = null;
	
	public String getCurrentUserName() {
		return CurrentUserName;
	}

	public User getCurrentUser() {
		return CurrentUser;
	}

	public void setCurrentUserName()	{
		//if(CurrentUserName == null) {
			CurrentUserName = getPrincipal();
		//}
	}
	
	public void setCurrentUser() {
		//if(CurrentUser == null) {
			if(CurrentUserName == null)
				setCurrentUserName();
			CurrentUser = userJpaRepository.findByUserName(CurrentUserName);
		//}
	}
	
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
