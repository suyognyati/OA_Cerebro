package com.web.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.data.entities.Enums.GenderType;
import com.data.entities.PersonalDetail;
import com.data.repository.PersonalDetailJpaRepository;

@RestController
@RequestMapping(value="/personaldetail")
public class personalDetailController {
	@Autowired
	PersonalDetailJpaRepository personalDetailJpaRepository;
	
	PersonalDetail personalDetail = new PersonalDetail();
	
	@RequestMapping(value="/getall", method = RequestMethod.GET)
	public ResponseEntity<List<PersonalDetail>> getPersonalDetails(Model model) {
		List<PersonalDetail> personalDetail;
		personalDetail = personalDetailJpaRepository.findAll();
		System.out.println("in personal detail");
		return new ResponseEntity<List<PersonalDetail>>(personalDetail, HttpStatus.OK);
	}
	
	@RequestMapping(value="/checkenum", method = RequestMethod.GET)
	public ResponseEntity<List<PersonalDetail>> checkEnum(Model model) {
		List<PersonalDetail> personalDetailList;
		System.out.println("value - " + personalDetail.getGender());
		personalDetail.setGender(GenderType.Female);
		System.out.println("value - " + personalDetail.getGender());
		personalDetailList = personalDetailJpaRepository.findAll();
		return new ResponseEntity<List<PersonalDetail>>(personalDetailList, HttpStatus.OK);
	}
}
