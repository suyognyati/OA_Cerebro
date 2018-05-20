package com.data.services.impl;

import org.springframework.stereotype.Service;

import com.data.entities.College;
import com.data.entities.CollegeVendorMap;
import com.data.entities.UserDetail;
import com.data.repository.CollegeVendorMapJpaRepository;
import com.data.services.CollegeVendorMapDao;

@Service("collegeVendorMapService")
public class CollegeVendorMapDaoImpl implements CollegeVendorMapDao {

	CollegeVendorMapJpaRepository collegeVendorMapJpaRepository;
	
	Boolean enable = true;
	
	@Override
	public CollegeVendorMap getCollegesOfVendor(UserDetail vendor) {
		enable = true;
		return collegeVendorMapJpaRepository.findByVendorAndEnabled(vendor, enable);
	}

	@Override
	public CollegeVendorMap getVendorsOfCollege(College college) {
		enable = true;
		return collegeVendorMapJpaRepository.findByCollegeAndEnabled(college, enable);
	}

	@Override
	public CollegeVendorMap getDisabledCollegesOfVendor(UserDetail vendor) {
		enable = false;
		return collegeVendorMapJpaRepository.findByVendorAndEnabled(vendor, enable);
	}

	@Override
	public CollegeVendorMap getDisabledVendorsOfCollege(College college) {
		enable = false;
		return collegeVendorMapJpaRepository.findByCollegeAndEnabled(college, enable);
	}

}
