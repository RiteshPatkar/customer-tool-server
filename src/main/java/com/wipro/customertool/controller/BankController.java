package com.wipro.customertool.controller;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.customertool.data.Bank;
import com.wipro.customertool.service.BankService;

@RestController
@RequestMapping(value = "/bank/")
public class BankController {

	@Autowired
	BankService service;

	
	@RequestMapping(value = "{userId}")
	public List<Bank> getBanksByUserId(@PathVariable(value = "userId") final String userId) {
		return service.getBanksByUserId(userId);
	}
	
	@RequestMapping(method = POST)
	public String saveBanks(@RequestBody List<Bank> banks) {
		service.saveBanks(banks);
		return "success";
	}
	
	@RequestMapping(value = "{userId}/{bankCode}", method = DELETE)
	public String deleteBankById(@PathVariable(value = "userId") final String userId,
			@PathVariable(value = "bankCode") final String bankCode) {
		service.deleteBankById(userId, bankCode);
		return "success";
	}
}
