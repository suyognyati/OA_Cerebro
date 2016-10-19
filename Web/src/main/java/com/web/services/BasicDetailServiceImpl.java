package com.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.BasicDetail;
import com.data.repository.BasicDetailJpaRepository;
import com.web.model.BasicDetailModel;

@Service("basicDetailService")
public class BasicDetailServiceImpl implements BasicDetailService{

	@Autowired
	BasicDetailJpaRepository basicDetailJpaRepository;
	
	public BasicDetailModel getBasicDetail(){
		
		List<BasicDetail> basicDetails = basicDetailJpaRepository.findAll();
		BasicDetailModel basicDetailModel = new BasicDetailModel();	
		
		for (BasicDetail basicDetail : basicDetails) {
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
