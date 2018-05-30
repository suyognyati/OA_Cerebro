package com.web.services;

import com.data.entities.Vendor;
import com.data.entities.VendorTransaction;

public interface VendorTransactionsRCService {

	/**
	 * By calling this function application fee will be paid.
	 * This function will calculate fee and will pay internally. 
	 * @param collegeProgramMapId
	 * @param vendor
	 * @return Boolean
	 */
	VendorTransaction payApplicationFee(Integer collegeProgramMapId, Vendor vedor);
	
}
