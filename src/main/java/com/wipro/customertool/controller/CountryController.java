package com.wipro.customertool.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
	
	@RequestMapping(value = "/country")
	public String getAllCountries() {
		return "Hellow World";
	}

	@RequestMapping(value = "/country/{countryId}")
	public String getCountryById(@PathVariable(value = "countryId") final Integer countryId) {
		return "Hello World by ID!!";
	}
}
