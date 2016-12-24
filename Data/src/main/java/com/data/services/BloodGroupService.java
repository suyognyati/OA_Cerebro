package com.data.services;

import java.util.List;

import com.data.entities.BloodGroup;

public interface BloodGroupService {
	List<BloodGroup> getAll();
	BloodGroup getByBloodGroupId(int bloodGroupId);
}
