package com.web.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.UserDetailModel;
import com.web.services.UserDetailService;

@RestController
@RequestMapping(value="/userDetail")
public class UserDetailRestController {
	
	@Autowired
	UserDetailService userDetailService;
	
	@RequestMapping(value="/get/")
	public UserDetailModel get(Model model){
		System.out.println("BasicDetailRestController - getBasicDetail");
		return userDetailService.getUserDetail();
	}
	
	@RequestMapping(value="/save/", method=RequestMethod.POST)
	public void save(@RequestBody UserDetailModel basicDetailModel) {
		userDetailService.saveUserDetail(basicDetailModel);
	}
}
