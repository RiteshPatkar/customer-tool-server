package com.wipro.customertool.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.customertool.data.IsoCountry;
import com.wipro.customertool.entity.IsoCountryEntity;
import com.wipro.customertool.repository.IsoCountryRepository;

@Service
public class IsoCountryService {
	
	@Autowired
	IsoCountryRepository repository;
	
	public IsoCountry getIsoCountries() {
		IsoCountry response = new IsoCountry();
		List<String> countryCodes = new ArrayList<>();
		
		List<IsoCountryEntity> entities = repository.findAll();
		for(IsoCountryEntity entity: entities) {
			countryCodes.add(entity.getCountryCode());
		}
		return response.setCountryCodes(countryCodes);
	}

}
