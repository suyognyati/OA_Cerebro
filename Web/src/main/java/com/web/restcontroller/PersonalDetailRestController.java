package com.web.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.PersonalDetailModel;
import com.web.services.PersonalDetailService;

@RestController
@RequestMapping(value="/personalDetail")
public class PersonalDetailRestController {
	
	@Autowired
	PersonalDetailService personalDetailService;
	
	@RequestMapping(value="/getPersonalDetail/")
	public PersonalDetailModel getPersonalDetail(Model model){
		//PersonalDetailServiceImpl personalDetailService = new PersonalDetailServiceImpl();
		
		return personalDetailService.getPersonalDetail();
	}
}
