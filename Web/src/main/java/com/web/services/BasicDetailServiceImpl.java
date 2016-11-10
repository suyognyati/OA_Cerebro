package com.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.BasicDetail;
import com.data.repository.BasicDetailJpaRepository;
import com.web.common.UserSession;
import com.web.model.BasicDetailModel;

@Service("basicDetailService")
public class BasicDetailServiceImpl implements BasicDetailService{

	@Autowired
	BasicDetailJpaRepository basicDetailJpaRepository;
	
	@Autowired
	UserSession userSession;
	
	public BasicDetailModel getBasicDetail(){
		
		BasicDetail basicDetail = basicDetailJpaRepository.findByUser(userSession.getCurrentUser());
		BasicDetailModel basicDetailModel = new BasicDetailModel();
		
		basicDetailModel.setLastName(basicDetail.getLastName());
		basicDetailModel.setFirstName(basicDetail.getFirstName());
		basicDetailModel.setMiddleName(basicDetail.getMidleName());
		basicDetailModel.setMothersName(basicDetail.getMotherName());
		basicDetailModel.setBirthDate(basicDetail.getDateOfBirth());
		basicDetailModel.setEmail(basicDetail.getEmail());
		basicDetailModel.setMobileNo(basicDetail.getMobileNo());
		basicDetailModel.setOtherContactNo(basicDetail.getOtherContact());
		
		return basicDetailModel;
	}
	
	public void saveBasicDetail(BasicDetailModel basicDetailModel) {
		BasicDetail basicDetail = basicDetailJpaRepository.findByUser(userSession.getCurrentUser());
		basicDetail.setLastName(basicDetailModel.getLastName());
		basicDetail.setFirstName(basicDetailModel.getFirstName());
		basicDetail.setMidleName(basicDetailModel.getMiddleName());
		basicDetail.setMotherName(basicDetailModel.getMothersName());
		basicDetail.setDateOfBirth(basicDetailModel.getBirthDate());
		basicDetail.setEmail(basicDetailModel.getEmail());
		basicDetail.setMobileNo(basicDetailModel.getMobileNo());
		basicDetail.setOtherContact(basicDetailModel.getOtherContactNo());		
		basicDetailJpaRepository.save(basicDetail);
	}
}
