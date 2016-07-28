package com.web.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.entities.BasicDetail;
import com.data.repository.BasicDetailJpaRepository;
import com.web.model.BasicDetailModel;
import com.web.services.BasicDetailService;

@RestController
@RequestMapping(value="/basicDetail")
public class BasicDetailRestController {
	
	@Autowired
	BasicDetailJpaRepository basicDetailJpaRepository;
	
	@RequestMapping(value="/getBasicDetail/")
	public BasicDetailModel getBasicDetail(Model model){
		BasicDetailService basicDetailService = new BasicDetailService();
		System.out.println("In basic detail controller");
		
		/*List<BasicDetail> basicDetails = basicDetailJpaRepository.findAll();
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
		}*/
		
		
		return basicDetailService.getBasicDetail();
	}
}
