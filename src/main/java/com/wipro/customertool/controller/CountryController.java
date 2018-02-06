package com.wipro.customertool.controller;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.customertool.data.Countries;
import com.wipro.customertool.service.CountryService;

@RestController
@RequestMapping(value = "/country/")
public class CountryController {

	@Autowired
	CountryService service;

	
	@RequestMapping(value = "user/{userId}")
	public Countries getCountriesByUserId(@PathVariable(value = "userId") final Integer userId) {
		return service.getCountriesByUserId(userId);
	}
	
	@RequestMapping(method = POST)
	public String saveCountries(@RequestBody Countries countries) {
		service.saveCountries(countries);
		return "success";
	}
	
	@RequestMapping(value = "{id}", method = DELETE)
	public String deleteCountryById(@PathVariable(value = "id") final Integer id) {
		service.deleteCountryById(id);
		return "success";
	}
}
