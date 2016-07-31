package com.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.User;
import com.data.repository.UserJpaRepository;
import com.web.model.BasicDetailModel;

@Service("basicDetailService")
public class BasicDetailServiceImpl implements BasicDetailService{

	@Autowired
	UserJpaRepository userJpaRepository;
	
	public BasicDetailModel getBasicDetail(){
		
		List<User> basicDetails = userJpaRepository.findAll();
		BasicDetailModel basicDetailModel = new BasicDetailModel();	
		
		for (User basicDetail : basicDetails) {
			basicDetailModel.setLastName(basicDetail.getLastName());
			basicDetailModel.setFirstName(basicDetail.getFirstName());
			basicDetailModel.setMiddleName(basicDetail.getMidleName());
			basicDetailModel.setMothersName(basicDetail.getMotherName());
			basicDetailModel.setBirthDate(basicDetail.getDateOfBirth());
			basicDetailModel.setEmail(basicDetail.getEmail());
			basicDetailModel.setMobileNo(basicDetail.getMobileNo());
			basicDetailModel.setOtherContactNo(basicDetail.getOtherContact());
		}
		return basicDetailModel;
	}
}
