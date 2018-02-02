package com.wipro.customertool.controller;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.customertool.data.BankBranch;
import com.wipro.customertool.service.BankBranchService;

@RestController
@RequestMapping(value = "/bankBranch/")
public class BankBranchController {

	@Autowired
	BankBranchService service;

	
	@RequestMapping(value = "{bankCode}")
	public List<BankBranch> getBankBranchesByBankCode(@PathVariable(value = "bankCode") final String bankCode) {
		return service.getBanksByBankCode(bankCode);
	}
	
	@RequestMapping(method = POST)
	public String saveBankBranches(@RequestBody List<BankBranch> bankBranches) {
		service.saveBankBranches(bankBranches);
		return "success";
	}
	
	@RequestMapping(value = "{bankBranchCode}/{action}", method = DELETE)
	public String deleteBankById(@PathVariable(value = "bankBranchCode") final String bankBranchCode,
			@PathVariable(value = "action") final String action) {
		service.deleteBankById(bankBranchCode, action);
		return "success";
	}
}
