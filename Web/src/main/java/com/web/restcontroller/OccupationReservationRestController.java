package com.web.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.OccupationReservationModel;
import com.web.services.OccupationReservationRCService;

@RestController
@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping(value="/rest/occupationreservation")
public class OccupationReservationRestController {
	
	@Autowired
	OccupationReservationRCService occupationReservationRCService;
	
	@RequestMapping(value="/get/")
	public OccupationReservationModel get(Model model){
		return occupationReservationRCService.getOccupationReservation();
	}
	
	@RequestMapping(value="/save/", method=RequestMethod.POST)
	public void save(@RequestBody OccupationReservationModel occupationReservationModel) {
		occupationReservationRCService.saveOccupationReservation(occupationReservationModel);
	}
}
