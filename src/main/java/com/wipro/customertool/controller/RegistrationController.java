package com.wipro.customertool.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.customertool.data.User;
import com.wipro.customertool.service.UserService;

@RestController
@RequestMapping(value = "/register/")
public class RegistrationController {
	
	@Autowired
	UserService service;
	
	@RequestMapping(method = POST)
	public String register(@RequestBody User user) {
		service.register(user);
		return "success";
	}

}
