package com.web.restcontroller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.StudentModel;
import com.web.services.RegisterRCService;

@RestController
@RequestMapping(value = "/login")
public class RegisterRestController {
	@Autowired
	RegisterRCService registerService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/checkuseravailability", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> checkUserAvailability(@RequestBody String username) {
		JSONObject obj = new JSONObject();
		obj.put("available", registerService.IsUserAvailable(username));
		return new ResponseEntity<JSONObject>(obj, HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/createuser", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> createUser(@RequestBody StudentModel studentModel) {
		Boolean isUserCreated = registerService.CreateUser(studentModel);
		JSONObject obj = new JSONObject();
		obj.put("isUserCreated", isUserCreated);
		return new ResponseEntity<JSONObject>(obj, HttpStatus.OK);
	}
}
