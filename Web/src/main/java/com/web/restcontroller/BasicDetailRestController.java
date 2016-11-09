package com.web.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.BasicDetailModel;
import com.web.services.BasicDetailService;

@RestController
@RequestMapping(value="/basicDetail")
public class BasicDetailRestController {
	
	@Autowired
	BasicDetailService basicDetailService;
	
	@RequestMapping(value="/getBasicDetail/")
	public BasicDetailModel getBasicDetail(Model model){
		System.out.println("BasicDetailRestController - getBasicDetail");
		return basicDetailService.getBasicDetail();
	}
	
	@RequestMapping(value="/save/", method=RequestMethod.POST)
	public void save(@RequestBody BasicDetailModel basicDetailModel) {
		System.out.println("BasicDetailRestController - save" + basicDetailModel);
	}
}
