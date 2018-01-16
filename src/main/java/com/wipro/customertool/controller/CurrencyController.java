package com.wipro.customertool.controller;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.customertool.data.Currency;
import com.wipro.customertool.service.CurrencyService;

@RestController
@RequestMapping(value = "/currency/")
public class CurrencyController {

	@Autowired
	CurrencyService service;

	
	@RequestMapping(value = "{userId}/{countryCode}")
	public List<Currency> getCountriesByUserId(@PathVariable(value = "userId") final String userId, 
			@PathVariable(value = "countryCode") final String countryCode) {
		return service.getCurrenciesByUserIdAndCountryCode(userId, countryCode);
	}
	
	@RequestMapping(method = POST)
	public String saveCountriesByUserId(@RequestBody List<Currency> currencies) {
		service.saveCurrencies(currencies);
		return "success";
	}
	
	@RequestMapping(value = "{userId}/{countryCode}/{flag}", method = DELETE)
	public String deleteCurrencyById(@PathVariable(value = "userId") final String userId,
			@PathVariable(value = "countryCode") final String countryCode,
			@PathVariable(value = "currencyCode") final String currencyCode,
			@PathVariable(value = "flag") final String flag) {
		service.deleteCurrencyById(userId, countryCode, currencyCode, flag);
		return "success";
	}
}
