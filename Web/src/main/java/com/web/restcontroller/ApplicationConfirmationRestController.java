package com.web.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.ApplicationFeeModel;
import com.web.model.PrintApplicationModel;
import com.web.services.ApplicationConfirmationRCService;
import com.web.session.Session;
 
@RestController
 
public class ApplicationConfirmationRestController {

	@Autowired
	ApplicationConfirmationRCService applicationConfirmationRCService;
	
	@Autowired
	Session session;
	
	@RequestMapping(value="/printApplication/getPrintDetail/")
	public PrintApplicationModel getPrintApplicationDetail(Model model) {
		return applicationConfirmationRCService.getPrintApplicationDetail(session.getStudent());
	}
	
	@RequestMapping(value="/application/paymentdetail/{collegeProgramMapId}")
	public ApplicationFeeModel getApplicationPaymentDetail(@PathVariable(value="collegeProgramMapId") Integer collegeProgramMapId) {
		ApplicationFeeModel applicationFeeModel = applicationConfirmationRCService.getFeeStructure(collegeProgramMapId);
		return applicationFeeModel;
	}
}
