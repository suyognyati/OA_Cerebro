package com.web.restcontroller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.session.Session;

@RestController
@RequestMapping(value="/rest/init")
public class InitRestController {
	@Autowired
	Session session;
	
	@Autowired
    private TokenStore tokenStore;
	
	@RequestMapping(value="/setuser/", method=RequestMethod.GET)
	public void setUser(Model model){
		session.setStudentName();
		session.setStudent();
	}
	
	@RequestMapping(value = "/oauth/revoketoken", method = RequestMethod.POST)
    public void revokeToken(@RequestBody String tokenValue) {
		Collection<OAuth2AccessToken> accessTokens = tokenStore.findTokensByClientId(session.getStudentName());
        //OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
        for(OAuth2AccessToken accessToken : accessTokens)
        	tokenStore.removeAccessToken(accessToken);
    }
}
