package com.web.restcontroller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.PersonalDetailModel;
import com.web.services.PersonalDetailService;

@RestController
public class PersonalDetailRestController {
	@RequestMapping(value="/personalDetail/getPersonalDetail/")
	public PersonalDetailModel getPersonalDetail(Model model){
		PersonalDetailService personalDetailService = new PersonalDetailService();
		
		return personalDetailService.getPersonalDetail();
	}
}
