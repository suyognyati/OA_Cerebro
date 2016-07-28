package com.web.restcontroller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.OtherInformationModel;
import com.web.services.OtherInformationService;

@RestController
public class OtherInformationRestController {
	@RequestMapping(value="/otherInformation/getOtherInformation/")
	public OtherInformationModel getOtherInformation(Model model){
		OtherInformationService otherInformationService = new OtherInformationService();
		
		return otherInformationService.getOtherInformation();
	}
}
