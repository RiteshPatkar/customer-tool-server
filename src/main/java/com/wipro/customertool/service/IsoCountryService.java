package com.wipro.customertool.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.customertool.data.IsoCountry;
import com.wipro.customertool.entity.IsoCountryEntity;
import com.wipro.customertool.repository.CountryRepository;
import com.wipro.customertool.repository.IsoCountryRepository;

@Service
public class IsoCountryService {
	
	@Autowired
	IsoCountryRepository isoRepository;
	
	@Autowired
	CountryRepository countryRepository;
	
	public IsoCountry getIsoCountries() {
		IsoCountry response = new IsoCountry();
		List<String> countryCodes = new ArrayList<>();
		
		List<IsoCountryEntity> entities = isoRepository.findAll();
		for(IsoCountryEntity entity: entities) {
			countryCodes.add(entity.getCountryCode());
		}
		return response.setCountryCodes(countryCodes);
	}

	public IsoCountry getIsoCountries(String userId) {
		IsoCountry response = new IsoCountry();
		String[] retrievedCountryCodes = countryRepository.getcountryCodesForYFlag(Integer.valueOf(userId));
//		return isoRepository.findByCountryCodeIn(Arrays.asList(retrievedCountryCodes));
		
		return response.setCountryCodes(Arrays.asList(retrievedCountryCodes));
	}

}
