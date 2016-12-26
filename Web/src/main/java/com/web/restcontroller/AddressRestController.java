package com.web.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.AddressModel;
import com.web.services.AddressRCService;

@RestController
@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping(value="/rest/address")
public class AddressRestController {
	
	@Autowired
	AddressRCService addressRCService;
	
	@RequestMapping(value="/get/")
	public AddressModel get(Model model){
		return addressRCService.getAddress();
	}
	
	@RequestMapping(value="/save/", method=RequestMethod.POST)
	public void save(@RequestBody AddressModel addressModel) {
		addressRCService.saveAddress(addressModel);
	}
}