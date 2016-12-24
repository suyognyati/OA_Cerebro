package com.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.BloodGroup;
import com.data.repository.BloodGroupJpaRepository;
import com.data.services.BloodGroupService;

@Service("bloodGroupSevice")
public class BloodGroupSeviceImpl implements BloodGroupService {

	@Autowired
	BloodGroupJpaRepository bloodGroupJpaRepository;
	
	public List<BloodGroup> getAll() {
		return bloodGroupJpaRepository.findAll();
	}
	
	public BloodGroup getByBloodGroupId(int bloodGroupId) {
		return bloodGroupJpaRepository.findByBloodGroupId(bloodGroupId);
	}

}
