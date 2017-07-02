package com.dhakre.rohit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dhakre.rohit.models.User;
import com.dhakre.rohit.responses.BaseResponse;
import com.dhakre.rohit.services.IRegistrationService;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {

	@Autowired
	@Qualifier("registrationService")
	private IRegistrationService registrationService;

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public BaseResponse registerNewUser(@RequestBody User user) {
		return registrationService.registerUser(user);
	}

}
