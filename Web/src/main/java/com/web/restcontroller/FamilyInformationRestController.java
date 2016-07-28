package com.web.restcontroller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.FamilyInformationModel;
import com.web.services.FamilyInformationService;

@RestController
public class FamilyInformationRestController {
	@RequestMapping(value="/familyInformation/getFamilyInformation/")
	public FamilyInformationModel getFamilyInformation(Model model){
		FamilyInformationService familyInformationService = new FamilyInformationService();
		
		return familyInformationService.getFamilyInformation();
	}
}
