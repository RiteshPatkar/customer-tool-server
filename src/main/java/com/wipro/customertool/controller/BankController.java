package com.wipro.customertool.controller;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.customertool.data.Country;
import com.wipro.customertool.service.CountryService;

@RestController
@RequestMapping(value = "/bank/")
public class BankController {

	@Autowired
	CountryService service;

	
	@RequestMapping(value = "{userId}")
	public List<Country> getCountriesByUserId(@PathVariable(value = "userId") final String userId) {
//		return service.getCountriesByUserId(userId);
		return null;
	}
	
	@RequestMapping(method = POST)
	public String saveCountriesByUserId(@RequestBody List<Country> countries) {
		service.saveCountriesByUserId(countries);
		return "success";
	}
	
	@RequestMapping(value = "{userId}/{countryCode}/{flag}", method = DELETE)
	public String deleteCountryById(@PathVariable(value = "userId") final String userId,
			@PathVariable(value = "countryCode") final String countryCode) {
		service.deleteCountryById(userId, countryCode);
		return "success";
	}
}
