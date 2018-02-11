package com.wipro.customertool.controller;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.customertool.data.Banks;
import com.wipro.customertool.service.BankService;

@RestController
@RequestMapping(value = "/bank/")
public class BankController {

	@Autowired
	BankService service;

	
	@RequestMapping(value = "{userId}")
	public Banks getBanksByUserId(@PathVariable(value = "userId") final String userId) {
		return service.getBanksByUserIdAndCountryCodes(userId, null);
	}
	
	@RequestMapping(value = "{userId}/{countryCodes}")
	public Banks getBanksByUserIdAndCountryCode(@PathVariable(value = "userId") final String userId, 
			@PathVariable(value = "countryCodes") final String[] countryCodes) {
		return service.getBanksByUserIdAndCountryCodes(userId, countryCodes);
	}
	
	@RequestMapping(method = POST)
	public String saveBanks(@RequestBody Banks banks) {
		service.saveBanks(banks);
		return "success";
	}
	
	@RequestMapping(value = "{id}", method = DELETE)
	public String deleteBankById(@PathVariable(value = "id") final Integer id) {
		service.deleteBankById(id);
		return "success";
	}
}
