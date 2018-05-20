package com.data.services;

import com.data.entities.College;
import com.data.entities.CollegeVendorMap;
import com.data.entities.UserDetail;

public interface CollegeVendorMapDao {

	CollegeVendorMap getCollegesOfVendor(UserDetail vendor);
	CollegeVendorMap getVendorsOfCollege(College college);
	
	CollegeVendorMap getDisabledCollegesOfVendor(UserDetail vendor);
	CollegeVendorMap getDisabledVendorsOfCollege(College college);
}
