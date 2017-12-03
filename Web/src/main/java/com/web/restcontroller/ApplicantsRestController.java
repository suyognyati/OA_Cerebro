package com.web.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.ApplicantsModel;
import com.web.services.ApplicantsRCService;
import com.web.session.Session;

@RestController
@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_COLLEGEADMIN')")
@RequestMapping(value={"/applicants"})
public class ApplicantsRestController {

	@Autowired
	ApplicantsRCService applicantsDetailRCService;
	
	@Autowired
	Session session;
	
	@RequestMapping(value="/getDetail/")
	public ApplicantsModel get(Model model){
		return applicantsDetailRCService.getApplicantDetail(session.getCurrentUser());
	}
}
