package com.data.services;

import com.data.entities.College;
import com.data.entities.CollegeVendorMap;
import com.data.entities.Vendor;

public interface CollegeVendorMapDao {

	CollegeVendorMap getCollegesOfVendor(Vendor vendor);
	CollegeVendorMap getVendorsOfCollege(College college);
	
	CollegeVendorMap getDisabledCollegesOfVendor(Vendor vendor);
	CollegeVendorMap getDisabledVendorsOfCollege(College college);
}
