package com.dhakre.rohit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dhakre.rohit.models.User;
import com.dhakre.rohit.responses.BaseResponse;
import com.dhakre.rohit.services.ILoginService;

@RestController
@RequestMapping("/api/login")
public class LoginController {

	@Autowired
	@Qualifier("loginService")
	private ILoginService loginService;

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public BaseResponse loginUser(@RequestBody User user) {
		return loginService.validateUser(user);
	}

}
