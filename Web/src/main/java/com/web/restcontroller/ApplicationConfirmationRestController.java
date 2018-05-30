package com.web.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value="/printApplication/getPrintDetail/{collegeProgramMapId}")
	public PrintApplicationModel getPrintApplicationDetail(@PathVariable(value="collegeProgramMapId") Integer collegeProgramMapId) {
		return applicationConfirmationRCService.getPrintApplicationDetail(collegeProgramMapId, session.getStudent());
	}
	
	@RequestMapping(value="/application/paymentdetail/{collegeProgramMapId}/{applicationId}")
	public ApplicationFeeModel getApplicationPaymentDetail(
			@PathVariable(value="collegeProgramMapId") Integer collegeProgramMapId,
			@PathVariable(value="applicationId") Integer applicationId) {
		ApplicationFeeModel applicationFeeModel = applicationConfirmationRCService.getFeeStructure(collegeProgramMapId);
		applicationFeeModel.setApplicationId(applicationId);	//Setting applicationId to use for next step.
		return applicationFeeModel;
	}
	
	@RequestMapping(value="/application/payAndSubmit/{collegeProgramMapId}/{applicationId}")
	public Boolean payApplicationFee(
			@PathVariable(value="collegeProgramMapId") Integer collegeProgramMapId,
			@PathVariable(value="applicationId") Integer applicationId) {
		
		Boolean success = applicationConfirmationRCService.submitApplication(session.getLoggedInUser(), collegeProgramMapId, applicationId);
		return success;
	}
}
