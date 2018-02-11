package com.wipro.customertool.controller;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.customertool.data.BankBranches;
import com.wipro.customertool.service.BankBranchService;

@RestController
@RequestMapping(value = "/bankBranch/")
public class BankBranchController {

	@Autowired
	BankBranchService service;

	@RequestMapping(value = "{userId}")
	public BankBranches getBankBranchesByUserId(@PathVariable(value = "userId") final String userId) {
		return service.getBankBranchesByUserIdAndCountryCodes(userId, null);
	}
	
	@RequestMapping(value = "{userId}/{countryCodes}")
	public BankBranches getBankBranchesByUserIdAndCountryCode(@PathVariable(value = "userId") final String userId, 
			@PathVariable(value = "countryCodes") final String[] countryCodes) {
		return service.getBankBranchesByUserIdAndCountryCodes(userId, countryCodes);
	}
	
	@RequestMapping(method = POST)
	public String saveBankBranches(@RequestBody BankBranches bankBranches) {
		service.saveBankBranches(bankBranches);
		return "success";
	}
	
	@RequestMapping(value = "{id}", method = DELETE)
	public String deleteBankById(@PathVariable(value = "id") final Integer id) {
		service.deleteBankBranchById(id);
		return "success";
	}
}
