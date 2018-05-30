package com.web.services;

import com.data.entities.User;
import com.web.model.ApplicationFeeModel;
import com.web.model.PrintApplicationModel;

public interface ApplicationConfirmationRCService {

	/**
	 * This function collects required application information on the basis of user 
	 * @param user
	 * @return PrintApplicationModel
	 */
	PrintApplicationModel getPrintApplicationDetail(Integer collegeProgramMapId, User user);
	
	/**
	 * This function collects complete breakdown of fee.
	 * @param collegeProgramMapId
	 * @return ApplicationFeeModel
	 */
	ApplicationFeeModel getFeeStructure(Integer collegeProgramMapId);
	
	/**
	 * Submit application by paying application fee
	 * @param collegeProgramMapId
	 * @return Boolean
	 */
	Boolean submitApplication(User vendor, Integer collegeProgramMapId, Integer applicationId);
}
