package com.wipro.customertool.controller;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.customertool.data.Currencies;
import com.wipro.customertool.service.CurrencyService;

@RestController
@RequestMapping(value = "/currency/")
public class CurrencyController {

	@Autowired
	CurrencyService service;

	
	@RequestMapping(value = "{userId}")
	public Currencies getCurrenciesByUserId(@PathVariable(value = "userId") final String userId) {
		return service.getCurrenciesByUserIdAndCountryCodes(userId, null);
	}
	
	@RequestMapping(value = "{userId}/{countryCodes}")
	public Currencies getCurrenciesByUserIdAndCountryCode(@PathVariable(value = "userId") final String userId, 
			@PathVariable(value = "countryCodes") final String[] countryCodes) {
		return service.getCurrenciesByUserIdAndCountryCodes(userId, countryCodes);
	}
	
	@RequestMapping(method = POST)
	public String saveCurrencies(@RequestBody Currencies currencies) {
		service.saveCurrencies(currencies);
		return "success";
	}
	
	@RequestMapping(value = "{id}", method = DELETE)
	public String deleteCurrencyById(@PathVariable(value = "id") final Integer id) {
		service.deleteCurrencyById(id);
		return "success";
	}
}
