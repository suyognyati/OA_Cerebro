package com.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.session.Session;
import com.web.session.SessionService;

@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	private Session session;
	
	@Autowired
	private SessionService sessionService;
	
	@RequestMapping(value = { "student/" }, method = RequestMethod.GET)
	public String userPage(ModelMap model) {
		
		sessionService.setStudent();
		model.addAttribute("user", session.getStudent());
		model.addAttribute("student", session.getStudent().getStudent());
		
		return "student/student";
	}
	
	@RequestMapping(value = { "vendor/" }, method = RequestMethod.GET)
	public String vendorPage(ModelMap model) {
		Integer collegeId = 1;
		sessionService.setLoggedInUser();
		sessionService.setCollege(collegeId);
		model.addAttribute("vendor", session.getLoggedInUser());
		model.addAttribute("vendordetail", session.getLoggedInUser().getStudent());
		return "vendor/vendor"; //VendorPage-topnavbar";
	}
	
	@RequestMapping(value = "admin/", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		model.addAttribute("admin", getPrincipal());
		return "admin";
	}
	
	@RequestMapping(value = "collegeadmin/", method = RequestMethod.GET)
	public String collegeAdmin(ModelMap model) {
		Integer collegeId = 1;
		sessionService.setCollege(collegeId);
		sessionService.setLoggedInUser();
		model.addAttribute("collegeadmin", session.getLoggedInUser());
		model.addAttribute("collegeadmindetail", session.getLoggedInUser().getStudent());
		return "collegeadmin/collegeadmin";
	}

	@RequestMapping(value = "db/", method = RequestMethod.GET)
	public String dbaPage(ModelMap model) {
		model.addAttribute("db", getPrincipal());
		return "dba";
	}

	@RequestMapping(value = "Access_Denied/", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginPage() {
		return "login/login-angular";
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
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