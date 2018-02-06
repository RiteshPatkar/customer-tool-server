package com.wipro.customertool.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.customertool.data.Countries;
import com.wipro.customertool.data.Country;
import com.wipro.customertool.entity.CountryEntity;
import com.wipro.customertool.repository.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	CountryRepository repository;
	
	@Autowired
	IsoCountryService isoCountryService;
	
	public Countries getCountriesByUserId(final Integer userId) {
		List<CountryEntity> countryEntities =  repository.findByUserId(userId);
//		IsoCountry isoCountry = isoCountryService.getIsoCountries();
		return (new Countries()).setUserCountries(buildTOFromEntites(countryEntities));
//				.setIsoCountryCodes(isoCountry.getCountryCodes());
	}

	public void saveCountries(Countries input) {
		List<Country> countries = input.getUserCountries();
		List<CountryEntity> countryEntities = buildEntitesFromTO(countries);
		repository.save(countryEntities);
	}

	public void deleteCountryById(Integer id) {
		repository.delete(new CountryEntity().setId(id));
	}
	
	private List<Country> buildTOFromEntites(List<CountryEntity> entities) {
		List<Country> countries = new ArrayList<>();
		
		for (CountryEntity entity : entities) {
			Country country = new Country();
			country.setId(entity.getId());
			country.setCountryCode(entity.getCountryCode());
			country.setFlag(entity.getFlag());
			country.setUserId(entity.getUserId());
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
			entity.setId(country.getId());
			entity.setCountryCode(country.getCountryCode());
			entity.setUserId(country.getUserId());
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
