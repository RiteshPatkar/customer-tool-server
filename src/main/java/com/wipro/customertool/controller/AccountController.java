package com.wipro.customertool.controller;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.customertool.data.Accounts;
import com.wipro.customertool.service.AccountService;

@RestController
@RequestMapping(value = "/account/")
public class AccountController {

	@Autowired
	AccountService service;

	
	@RequestMapping(value = "{userId}")
	public Accounts getAccountsByUserId(@PathVariable(value = "userId") final String userId) {
		return service.getAccountsByUserIdAndCountryCodes(userId, null);
	}
	
	@RequestMapping(value = "{userId}/{countryCodes}")
	public Accounts getAccountsByUserIdAndCountryCode(@PathVariable(value = "userId") final String userId, 
			@PathVariable(value = "countryCodes") final String[] countryCodes) {
		return service.getAccountsByUserIdAndCountryCodes(userId, countryCodes);
	}
	
	@RequestMapping(method = POST)
	public String saveAccounts(@RequestBody Accounts accounts) {
		service.saveAccounts(accounts);
		return "success";
	}
	
	@RequestMapping(value = "{id}", method = DELETE)
	public String deleteAccountById(@PathVariable(value = "id") final Integer id) {
		service.deleteAccountById(id);
		return "success";
	}
}
