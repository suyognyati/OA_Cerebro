package com.web.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.PrintApplicationModel;
import com.web.services.PrintApplicationRCService;
import com.web.session.Session;
import com.web.session.SessionService;
 
@RestController
 
public class PrintApplicationRestController {

	@Autowired
	PrintApplicationRCService printApplicationRCService;
	
	@Autowired
	Session session;
	
	@Autowired
	SessionService sessionService;
	
	@RequestMapping(value="/printApplication/getPrintDetail/")
	public PrintApplicationModel getPrintApplicationDetail(Model model) {
		return printApplicationRCService.getPrintApplicationDetail(session.getStudent());
	}
}
