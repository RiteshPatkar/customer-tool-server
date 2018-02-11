package com.wipro.customertool.controller;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.customertool.data.Companies;
import com.wipro.customertool.service.CompanyService;

@RestController
@RequestMapping(value = "/company/")
public class CompanyController {

	@Autowired
	CompanyService service;

	
	@RequestMapping(value = "{userId}")
	public Companies getCompaniesByUserIdAndCountryCode(@PathVariable(value = "userId") final String userId) {
		return service.getCompaniesByUserIdAndCountryCodes(userId, null);
	}
	
	@RequestMapping(value = "{userId}/{countryCodes}")
	public Companies getCompaniesByUserIdAndCountryCode(@PathVariable(value = "userId") final String userId, 
			@PathVariable(value = "countryCodes") final String[] countryCodes) {
		return service.getCompaniesByUserIdAndCountryCodes(userId, countryCodes);
	}
	
	@RequestMapping(method = POST)
	public String saveCompanies(@RequestBody Companies companies) {
		service.saveCompanies(companies);
		return "success";
	}
	
	@RequestMapping(value = "{id}", method = DELETE)
	public String deleteCompanyById(@PathVariable(value = "id") final Integer id) {
		service.deleteCompanyById(id);
		return "success";
	}
}
