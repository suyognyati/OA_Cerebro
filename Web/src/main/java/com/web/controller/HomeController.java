package com.web.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
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
	
	@Autowired
    private TokenStore tokenStore;
	
	@RequestMapping(value = { "vendor/user/" }, method = RequestMethod.GET)
	public String userPageForVendor(ModelMap model) {
		String userName = session.getCurrentUserName();
		String accessTokenValue = "";
		Collection<OAuth2AccessToken> accessTokens = null;
		if(userName != null && userName != "") {
			accessTokens = tokenStore.findTokensByClientId(userName);
	        for(OAuth2AccessToken accessToken : accessTokens) {
	        	if(accessToken.isExpired() == false) {
	        		accessTokenValue = accessToken.getValue();
	        		break;	
	        	}
	        }
		}
		if(accessTokenValue == null || accessTokenValue == "") {
			return "redirect:/vendor/";
		}
		
		model.addAttribute("Bearer", accessTokenValue);
		model.addAttribute("vendor", session.getCurrentVendor());
		model.addAttribute("vendordetail", session.getCurrentVendorDetail());
		model.addAttribute("user", session.getCurrentUser());
		model.addAttribute("userdetail", session.getCurrentUserDetail());
		return "user/UserPageofVendor";
	}
	
	@RequestMapping(value = { "user/" }, method = RequestMethod.GET)
	public String userPage(ModelMap model) {
		sessionService.setLoggedInUserDetails();
		
		String userName = session.getCurrentUserName();
		String accessTokenValue = "";
		Collection<OAuth2AccessToken> accessTokens = null;
		if(userName != null && userName != "") {
			accessTokens = tokenStore.findTokensByClientId(userName);
	        for(OAuth2AccessToken accessToken : accessTokens) {
	        	if(accessToken.isExpired() == false) {
	        		accessTokenValue = accessToken.getValue();
	        		break;	
	        	}
	        }
		}
		/*if(accessTokenValue == null || accessTokenValue == "") {
			return "redirect:/user/";
		}*/
		
		model.addAttribute("Bearer", accessTokenValue);
		model.addAttribute("user", session.getLoggedInUser());
		model.addAttribute("userdetail", session.getLoggedInUserDetail());
		return "user/StudentView_newUI";
	}
	
	@RequestMapping(value = { "user/studentview/" }, method = RequestMethod.GET)
	public String studentViewPage(ModelMap model) {
		String userName = session.getCurrentUserName();
		String accessTokenValue = "";
		Collection<OAuth2AccessToken> accessTokens = null;
		if(userName != null && userName != "") {
			accessTokens = tokenStore.findTokensByClientId(userName);
	        for(OAuth2AccessToken accessToken : accessTokens) {
	        	if(accessToken.isExpired() == false) {
	        		accessTokenValue = accessToken.getValue();
	        		break;	
	        	}
	        }
		}
		/*if(accessTokenValue == null || accessTokenValue == "") {
			return "redirect:/user/";
		}*/
		
		model.addAttribute("Bearer", accessTokenValue);
		model.addAttribute("user", session.getCurrentUser());
		model.addAttribute("userdetail", session.getCurrentUserDetail());
		return "user/StudentView";
	}

	@RequestMapping(value = { "vendor/" }, method = RequestMethod.GET)
	public String vendorPage(ModelMap model) {
		Integer collegeId = 1;
		session.setCurrentVendorName();
		session.setCurrentVendor();
		session.setCurrentVendorDetail();
		sessionService.setCollege(collegeId);
		model.addAttribute("vendor", session.getCurrentVendor());
		model.addAttribute("vendordetail", session.getCurrentVendorDetail());
		return "vendor/vendor_newUI"; //VendorPage-topnavbar";
	}
	
	@RequestMapping(value = "admin/", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "admin";
	}
	
	@RequestMapping(value = "collegeadmin/", method = RequestMethod.GET)
	public String collegeAdmin(ModelMap model) {
		sessionService.setLoggedInUserDetails();
		model.addAttribute("collegeadmin", session.getLoggedInUser());
		model.addAttribute("collegeadmindetail", session.getLoggedInUserDetail());
		return "collegeadmin/college_admin";
	}

	@RequestMapping(value = "db/", method = RequestMethod.GET)
	public String dbaPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "dba";
	}

	@RequestMapping(value = "Access_Denied/", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginPage() {
		return "login-angular";
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