package com.wipro.customertool.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.customertool.data.Countries;
import com.wipro.customertool.data.Country;
import com.wipro.customertool.data.IsoCountry;
import com.wipro.customertool.entity.CountryEntity;
import com.wipro.customertool.entity.CountryEntityKey;
import com.wipro.customertool.repository.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	CountryRepository repository;
	
	@Autowired
	IsoCountryService isoCountryService;
	
	public Countries getCountriesByUserId(final String userId) {
		List<CountryEntity> countryEntities =  repository.findByIdUserIdIgnoreCase(userId);
//		IsoCountry isoCountry = isoCountryService.getIsoCountries();
		return (new Countries()).setUserCountries(buildTOFromEntites(countryEntities));
//				.setIsoCountryCodes(isoCountry.getCountryCodes());
	}

	public void saveCountriesByUserId(List<Country> countries) {
		List<CountryEntity> countryEntities = buildEntitesFromTO(countries);
		repository.save(countryEntities);
	}

	public void deleteCountryById(String userId, String countryCode) {
		CountryEntityKey key = new CountryEntityKey();
		key.setCountryCode(countryCode).setUserId(userId);
		repository.delete(new CountryEntity().setId(key));
	}
	
	private List<Country> buildTOFromEntites(List<CountryEntity> entities) {
		List<Country> countries = new ArrayList<>();
		
		for (CountryEntity entity : entities) {
			Country country = new Country();
			country.setCountryCode(entity.getId().getCountryCode());
			country.setFlag(entity.getFlag());
			country.setUserId(entity.getId().getUserId());
			country.setCurrencyCode(entity.getCurrencyCode());
			country.setCountryDescription(entity.getDescription());
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
			key.setUserId(country.getUserId());
			
			entity.setId(key);
			entity.setFlag(country.getFlag());
			entity.setCurrencyCode(country.getCurrencyCode());
			entity.setDescription(country.getCountryDescription());
			entity.setPostalCodeLength(country.getPostalCodeLength());
			entity.setPostalCodePosition(country.getPostalCodePosition());
			
			entities.add(entity);
		}
		return entities;
	}

}
