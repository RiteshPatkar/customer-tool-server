package com.wipro.customertool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.customertool.data.IsoCountry;
import com.wipro.customertool.service.IsoCountryService;

@RestController
@RequestMapping(value = "/isocountry")
public class IsoCountryController {
	
	@Autowired
	IsoCountryService service;
	
	public List<IsoCountry> getIsoCountries() {
		return service.getIsoCountries();
	}

}
