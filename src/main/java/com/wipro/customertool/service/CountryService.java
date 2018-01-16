package com.wipro.customertool.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.customertool.data.Country;
import com.wipro.customertool.entity.CountryEntity;
import com.wipro.customertool.entity.CountryEntityKey;
import com.wipro.customertool.repository.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	CountryRepository repository;
	
	public List<Country> getCountriesByUserId(final String userId) {
		List<CountryEntity> countryEntities =  repository.findByIdUserIdIgnoreCase(userId);
		return buildTOFromEntites(countryEntities);
	}

	public void saveCountriesByUserId(List<Country> countries) {
		List<CountryEntity> countryEntities = buildEntitesFromTO(countries);
		repository.save(countryEntities);
	}

	public void deleteCountryById(String userId, String countryCode, String flag) {
		CountryEntityKey key = new CountryEntityKey();
		key.setCountryCode(countryCode).setFlag(flag).setUserId(userId);
		repository.delete(new CountryEntity().setId(key));
	}
	
	private List<Country> buildTOFromEntites(List<CountryEntity> entities) {
		List<Country> countries = new ArrayList<>();
		
		for (CountryEntity entity : entities) {
			Country country = new Country();
			country.setCountryCode(entity.getId().getCountryCode());
			country.setFlag(entity.getId().getFlag());
			country.setUserId(entity.getId().getUserId());
			country.setCurrencyCode(entity.getCurrencyCode());
			country.setDescription(entity.getDescription());
			country.setPostalCodeLength(entity.getPostalCodeLength());
			country.setPostalCodePosition(entity.getPostalCodePosition());
			
			countries.add(country);
		}
		return countries;
	}
	
	private List<CountryEntity> buildEntitesFromTO(List<Country> countries) {
		List<CountryEntity> entities = new ArrayList<>();
		
		for (Country country : countries) {
			CountryEntity entity = new CountryEntity();
			
			CountryEntityKey key = new CountryEntityKey();
			key.setCountryCode(country.getCountryCode());
			key.setFlag(country.getFlag());
			key.setUserId(country.getUserId());
			
			entity.setId(key);
			entity.setCurrencyCode(country.getCurrencyCode());
			entity.setDescription(country.getDescription());
			entity.setPostalCodeLength(country.getPostalCodeLength());
			entity.setPostalCodePosition(country.getPostalCodePosition());
			
			entities.add(entity);
		}
		return entities;
	}

}
