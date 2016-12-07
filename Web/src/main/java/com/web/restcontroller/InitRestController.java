package com.web.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.session.Session;

@RestController
@RequestMapping(value="/rest/init")
public class InitRestController {
	@Autowired
	Session session;
	
	@RequestMapping(value="/setuser/", method=RequestMethod.GET)
	public void setUser(Model model){
		session.setCurrentUserName();
		session.setCurrentUser();
		session.setCurrentUserDetail();
	}
}
