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
	
	public List<IsoCountry> getIsoCountries() {
		List<IsoCountry> IsoCountries = new ArrayList<>();
		
		List<IsoCountryEntity> entities = repository.findAll();
		for(IsoCountryEntity entity: entities) {
			IsoCountry isoCountry = new IsoCountry();
			isoCountry.setCountryCode(entity.getCountryCode());
		}
		return IsoCountries;
	}

}
