package com.web.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.PersonalDetailModel;
import com.web.services.PersonalDetailService;

@RestController
@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping(value="/personalDetail")
public class PersonalDetailRestController {
	
	@Autowired
	PersonalDetailService personalDetailService;
	
	@RequestMapping(value="/get/")
	public PersonalDetailModel get(Model model){
		return personalDetailService.getPersonalDetail();
	}
	
	@RequestMapping(value="/save/", method=RequestMethod.POST)
	public void save(@RequestBody PersonalDetailModel personalDetailModel) {
		personalDetailService.savePersonalDetail(personalDetailModel);
	}
}
