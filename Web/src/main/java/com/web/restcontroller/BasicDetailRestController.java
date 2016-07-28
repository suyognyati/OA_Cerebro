package com.web.restcontroller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.BasicDetailModel;
import com.web.services.BasicDetailService;

@RestController
@RequestMapping(value="/basicDetail")
public class BasicDetailRestController {
	@RequestMapping(value="/getBasicDetail/")
	public BasicDetailModel getBasicDetail(Model model){
		BasicDetailService basicDetailService = new BasicDetailService();
		System.out.println("In basic detail controller");
		return basicDetailService.getBasicDetail();
	}
}
