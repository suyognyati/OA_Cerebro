package com.web.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.CollegeFeeMap;
import com.data.entities.CollegeProgramFeeMap;
import com.data.entities.CollegeProgramMap;
import com.data.entities.Vendor;
import com.data.entities.VendorTransaction;
import com.data.services.CollegeFeeMapDao;
import com.data.services.CollegeProgramFeeMapDao;
import com.data.services.CollegeProgramMapService;
import com.data.services.VendorTransactionDao;
import com.web.services.VendorTransactionsRCService;
import com.web.staticandconstants.StaticMethods;

@Service("vendorTransactionsRCService")
public class VendorTransactionsRCServiceImpl implements VendorTransactionsRCService {

	@Autowired
	CollegeProgramMapService collegeProgramMapService;
	
	@Autowired
	CollegeProgramFeeMapDao collegeProgramFeeMapDao;
	
	@Autowired
	CollegeFeeMapDao collegeFeeMapDao;
	
	@Autowired
	VendorTransactionDao vendorTransactionDao;
	
	@Override
	public VendorTransaction payApplicationFee(Integer collegeProgramMapId, Vendor vendor) {
		CollegeProgramMap collegeProgramMap = collegeProgramMapService.getById(collegeProgramMapId);		
		
		Float amount = getApplicationFeeAmount(collegeProgramMap);		
		
		VendorTransaction vendorTransaction = vendorTransactionDao.debit(vendor, amount);	
		
		return vendorTransaction;
	}
	
	//Private function to get application fee amount
	private Float getApplicationFeeAmount(CollegeProgramMap collegeProgramMap) {
		Float applicationFee = 0f;
		Integer year = StaticMethods.GetCourseStartYear();
		//Getting fee details of particular program 
		List<CollegeProgramFeeMap> collegeProgramFeeMapList = collegeProgramFeeMapDao.getByCollegeProgramAndYear(collegeProgramMap.getCollege(), collegeProgramMap.getProgram(), year);
		//If fee details for particular program not available then getting it for entire college
		if(collegeProgramFeeMapList != null && collegeProgramFeeMapList.size() > 0) {
			applicationFee = getProgramFee(collegeProgramFeeMapList);
		} else {
			List<CollegeFeeMap> collegeFeeMapList = collegeFeeMapDao.getByCollegeAndYear(collegeProgramMap.getCollege(), year);
			applicationFee = getCollegeFee(collegeFeeMapList);
		}
		return applicationFee;
	}
	
	//Private function to get ptogram fee.
	//This will be called if any specific program contain special fee
	private Float getProgramFee(List<CollegeProgramFeeMap> collegeProgramFeeMapList) {
		
		Float vendorAmount = 0f;
		Float totalAmount = 0f;
		
		if(collegeProgramFeeMapList != null) {
			for(CollegeProgramFeeMap collegeProgramFeeMap : collegeProgramFeeMapList) {
				Float amount = collegeProgramFeeMap.getAmount();
				Boolean displayPurpose = collegeProgramFeeMap.getOnlyForDisplayPurpose();
				if(!displayPurpose)
					vendorAmount += amount;
				totalAmount += amount;
			}
		}		
		return vendorAmount; 
	}
	
	//Private function to get college Fee
	//This is by default fee and will be called if any specific program fee not available.
	private Float getCollegeFee(List<CollegeFeeMap> collegeFeeMapList) {
		
		Float vendorAmount = 0f;
		Float totalAmount = 0f;
		
		if(collegeFeeMapList != null) {
			for(CollegeFeeMap collegeFeeMap : collegeFeeMapList) {
				Float amount = collegeFeeMap.getAmount();
				Boolean displayPurpose = collegeFeeMap.getOnlyForDisplayPurpose();
				if(!displayPurpose)
					vendorAmount += amount;
				totalAmount += amount;
			}
		}			
		return vendorAmount; 
	}


}
